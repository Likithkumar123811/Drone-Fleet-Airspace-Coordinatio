import org.apache.zookeeper.ZooKeeper;

public class ZoneLockManager {

    private LockManager zone1;
    private LockManager zone2;

    public ZoneLockManager(ZooKeeper zk) throws Exception {
        zone1 = new LockManager(zk, "/zone1");
        zone2 = new LockManager(zk, "/zone2");
    }

    public LockManager getZone1Lock() {
        return zone1;
    }

    public LockManager getZone2Lock() {
        return zone2;
    }
}