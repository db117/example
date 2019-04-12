package com.db117.example.zk.api;

import org.apache.zookeeper.*;
import org.apache.zookeeper.data.Stat;

import java.io.IOException;

/**
 * @author db117
 */
public class ZookeeperCrud {

    private ZooKeeper zookeeper;

    public ZookeeperCrud() {
        try {
            String connectString = "127.0.0.1:2181";
            zookeeper = new ZooKeeper(connectString, 5000, null);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 创建持久节点
     *
     * @param path
     * @param data 数据
     * @return 路径
     */
    public String createPersistent(String path, String data) {
        try {
            return zookeeper.create(path, data.getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
        } catch (KeeperException | InterruptedException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 创建临时节点
     *
     * @param path 路径
     * @param data 数据
     * @return
     */
    public String createEphemeral(String path, String data) {
        try {
            return zookeeper.create(path, data.getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.EPHEMERAL);
        } catch (KeeperException | InterruptedException e) {
            e.printStackTrace();
        }
        return null;
    }


    /***
     * 获取信息
     */
    public String getData(String path) throws KeeperException, InterruptedException {
        byte data[] = zookeeper.getData(path, false, null);
        data = (data == null) ? "null".getBytes() : data;
        return new String(data);
    }


    /***
     * 更新信息
     */
    public Stat setData(String path, String data) throws KeeperException, InterruptedException {
        return zookeeper.setData(path, data.getBytes(), -1);
    }

    /***
     * 是否存在
     */
    public Stat exists(String path) throws KeeperException, InterruptedException {
        return zookeeper.exists(path, false);

    }


    /***
     * 删除
     */
    public void delete(String path) throws KeeperException, InterruptedException {
        zookeeper.delete(path, -1);
    }

    /***
     * 删除 递归
     */
    public void deleteRecursive(String path) throws KeeperException, InterruptedException {
        ZKUtil.deleteRecursive(zookeeper, path);
    }

    public void close() throws InterruptedException {
        zookeeper.close();
    }
}
