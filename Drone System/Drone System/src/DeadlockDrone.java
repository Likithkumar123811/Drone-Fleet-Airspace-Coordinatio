import org.apache.zookeeper.ZooKeeper;
import java.io.FileWriter;
import java.util.HashMap;
import java.util.Map;

public class DeadlockDrone {
    static java.util.Map<String, String> waiting = new java.util.HashMap<>();
    static java.util.Map<String, String> holding = new java.util.HashMap<>();
    static Map<String, String> holding = new HashMap<>();
    static Map<String, String> waiting = new HashMap<>();
    public static void main(String[] args) throws Exception {
        ZooKeeper zk = new ZooKeeper("localhost:2181", 3000, e -> {});
        Thread.sleep(2000);
        ZoneLockManager manager = new ZoneLockManager(zk);
        String id = args[0];
        if (id.equals("1")) {
            System.out.println("Drone1 acquiring Zone1...");
            manager.getZone1Lock().acquireLock();
            holding.put("Drone1", "Zone1");
            Thread.sleep(2000);
            System.out.println("Drone1 trying Zone2...");
            boolean gotLock = manager.getZone2Lock().tryLock();
            if (!gotLock) {
                System.out.println("Drone1 waiting for Zone2");
                waiting.put("Drone1", "Zone2");
                detectDeadlock();
            }
        }
        else {
            System.out.println("Drone2 acquiring Zone2...");
            manager.getZone2Lock().acquireLock();
            holding.put("Drone2", "Zone2");
            Thread.sleep(2000);
            System.out.println("Drone2 trying Zone1...");
            boolean gotLock = manager.getZone1Lock().tryLock();
            if (!gotLock) {
                System.out.println("Drone2 waiting for Zone1");
                waiting.put("Drone2", "Zone1");
                detectDeadlock();
            }
        }
        zk.close();
    }
    //  Deadlock Detection
    public static void detectDeadlock() {
        if (waiting.containsKey("Drone1") && waiting.containsKey("Drone2")) {
            if (waiting.get("Drone1").equals("Zone2") &&
            waiting.get("Drone2").equals("Zone1") &&
            holding.get("Drone1").equals("Zone1") &&
            holding.get("Drone2").equals("Zone2")) {
            System.out.println("🚨 DEADLOCK DETECTED!");
            System.out.println("Resolving deadlock by stopping Drone2");
        }
    }
}
    // Deadlock Resolution
    public static void resolveDeadlock() throws Exception {
        System.out.println("Resolving deadlock by releasing Drone2");
        log("Resolving deadlock: releasing Drone2");
        holding.remove("Drone2");
        waiting.remove("Drone2");
        System.out.println("Drone2 released its lock");
        log("Drone2 released its lock\n");
    }

    //  Logging helper
    public static void log(String message) throws Exception {
        FileWriter fw = new FileWriter("drone_log.txt", true);
        fw.write(message + "\n");
        fw.close();
    }
}