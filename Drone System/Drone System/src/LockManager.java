import org.apache.zookeeper.*;
import java.util.Collections;
import java.util.List;
public class LockManager {
    private ZooKeeper zk;
    private String lockPath;
    private String currentNode;
    // UPDATED CONSTRUCTOR (supports multiple paths)
    public LockManager(ZooKeeper zk, String path) throws Exception {
        this.zk = zk;
        this.lockPath = path;
        try {
            if (zk.exists(lockPath, false) == null) {
                zk.create(lockPath, new byte[0],
                        ZooDefs.Ids.OPEN_ACL_UNSAFE,
                        CreateMode.PERSISTENT);
                System.out.println("Created " + lockPath + " node");
            }
        } catch (KeeperException.NodeExistsException e) {
            // ignore
        }
    }
    public void acquireLock() throws Exception {
        currentNode = zk.create(lockPath + "/lock-",
                new byte[0],
                ZooDefs.Ids.OPEN_ACL_UNSAFE,
                CreateMode.EPHEMERAL_SEQUENTIAL);

        System.out.println("Created node: " + currentNode);
        while (true) {
            List<String> children = zk.getChildren(lockPath, false);
            Collections.sort(children);

            String smallest = children.get(0);

            if (currentNode.endsWith(smallest)) {
                System.out.println("Lock acquired: " + currentNode);
                return;
            } else {
                System.out.println("Waiting for lock in " + lockPath + "...");
                Thread.sleep(2000);
            }
        }
    }
    public boolean tryLock() throws Exception {
    currentNode = zk.create(lockPath + "/lock-",
            new byte[0],
            ZooDefs.Ids.OPEN_ACL_UNSAFE,
            CreateMode.EPHEMERAL_SEQUENTIAL);
    List<String> children = zk.getChildren(lockPath, false);
    Collections.sort(children);
    String smallest = children.get(0);
    if (currentNode.endsWith(smallest)) {
        System.out.println("Lock acquired: " + currentNode);
        return true;
    } else {
        System.out.println("Lock NOT acquired, waiting...");
        return false;
    }
    }
    public void releaseLock() throws Exception {
        zk.delete(currentNode, -1);
        System.out.println("Lock released: " + currentNode);
    }
}