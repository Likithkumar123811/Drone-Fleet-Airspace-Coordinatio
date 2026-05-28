import org.apache.zookeeper.ZooKeeper;
import java.io.FileWriter;

public class Drone {

    public static void main(String[] args) throws Exception {

        String host = "localhost:2181";

        ZooKeeper zk = new ZooKeeper(host, 3000, event -> {
            System.out.println("Connected to ZooKeeper");
        });

        Thread.sleep(2000);

        // Lock manager
        LockManager lock = new LockManager(zk, "/locks");

        // Add header only once (Drone 1)
        if (args[0].equals("1")) {
            FileWriter fw = new FileWriter("drone_log.txt", true);
            fw.write("\n--- MUTUAL EXCLUSION TEST ---\n");
            fw.close();
        }

        System.out.println("Drone " + args[0] + " requesting lock");

        FileWriter fw1 = new FileWriter("drone_log.txt", true);
        fw1.write("Drone " + args[0] + " requesting lock\n");
        fw1.write("Drone " + args[0] + " WAITING for lock\n");
        fw1.close();

        // Acquire lock
        lock.acquireLock();

        System.out.println("Drone " + args[0] + " ENTERED zone");

        FileWriter fw2 = new FileWriter("drone_log.txt", true);
        fw2.write("Drone " + args[0] + " ENTERED zone\n");
        fw2.write("Only one drone is allowed at a time → Mutual Exclusion\n\n");
        fw2.close();

        Thread.sleep(3000);

        System.out.println("Drone " + args[0] + " leaving zone");

        lock.releaseLock();

        zk.close();
    }
}