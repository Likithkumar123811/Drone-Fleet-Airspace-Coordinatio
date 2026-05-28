import org.apache.zookeeper.ZooKeeper;

public class ZooKeeperConnector {
    public static void main(String[] args) throws Exception {

        String host = "localhost:2181";

        ZooKeeper zk = new ZooKeeper(host, 3000, event -> {
            System.out.println("Connected to ZooKeeper");
        });

        Thread.sleep(5000);

        zk.close();
    }
}