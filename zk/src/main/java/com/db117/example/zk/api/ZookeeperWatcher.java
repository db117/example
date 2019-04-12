package com.db117.example.zk.api;

import lombok.extern.slf4j.Slf4j;
import org.apache.zookeeper.*;
import org.apache.zookeeper.data.Stat;

/**
 * @author db117
 * @date 2019/4/12
 **/
@Slf4j
public class ZookeeperWatcher implements Watcher {

    private ZooKeeper zookeeper;

    public ZookeeperWatcher() {
        try {
            String connectString = "127.0.0.1:2181";
            this.zookeeper = new ZooKeeper(connectString, 5000, this);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /***
     * 创建持久节点
     */
    public String createPersistent(String path, String data) {
        try {
            return zookeeper.create(path, data.getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
        } catch (KeeperException | InterruptedException e) {
            log.error(e.getMessage(), e);
        }
        return null;
    }

    /***
     * 创建临时节点
     */
    public String createEphemeral(String path, String data) {
        try {
            return zookeeper.create(path, data.getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.EPHEMERAL);
        } catch (KeeperException | InterruptedException e) {
            log.error(e.getMessage(), e);
        }
        return null;
    }

    /***
     * 更新信息
     */
    public Stat setData(String path, String data) throws KeeperException, InterruptedException {
        return zookeeper.setData(path, data.getBytes(), -1);
    }

    /***
     * 获取信息
     * @param path
     * @return
     */
    public String getData(String path, boolean watcher) throws KeeperException, InterruptedException {
        byte[] data = zookeeper.getData(path, watcher, null);
        data = (data == null) ? "null".getBytes() : data;
        return new String(data);
    }

    /***
     * 是否存在
     * @param path path
     * @return
     */
    public Stat exists(String path, boolean watcher) throws KeeperException, InterruptedException {
        return zookeeper.exists(path, watcher);

    }

    /***
     * 删除
     */
    public void delete(String path) throws KeeperException, InterruptedException {
        zookeeper.delete(path, -1);
    }

    /***
     * 删除
     */
    public void deleteRecursive(String path) throws KeeperException, InterruptedException {
        ZKUtil.deleteRecursive(zookeeper, path);
    }

    public void close() throws InterruptedException {
        zookeeper.close();
    }

    @Override
    public void process(WatchedEvent event) {
        // 连接状态
        Event.KeeperState keeperState = event.getState();
        // 事件类型
        Event.EventType eventType = event.getType();
        // 受影响的path
        String path = event.getPath();
        //step 1:
        log.info("连接状态:[{}],事件类型：[{}],受影响的path:[{}]"
                , keeperState
                , eventType
                , path);

        try {
            if (null != this.exists("/wukong", true)) {
                log.info("内容:[{}]", this.getData("/wukong", true));
            }
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }
    }
}
