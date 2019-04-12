package com.db117.example.zk.zkClient;

import lombok.extern.slf4j.Slf4j;
import org.I0Itec.zkclient.IZkDataListener;
import org.I0Itec.zkclient.IZkStateListener;
import org.I0Itec.zkclient.ZkClient;
import org.I0Itec.zkclient.serialize.SerializableSerializer;
import org.apache.zookeeper.Watcher;

import java.util.List;

/**
 * zkClient操作zk
 *
 * @author db117
 * @date 2019/4/12
 **/
@Slf4j
public class ZkClientCrud<T> {
    private ZkClient zkClient;

    public ZkClientCrud() {
        String connectString = "127.0.0.1:2181";
        this.zkClient = new ZkClient(connectString
                , 5000
                , 5000
                , new SerializableSerializer());
    }


    /**
     * 创建持久节点
     *
     * @param path 路径
     * @param data 数据
     */
    public void createPersistent(String path, Object data) {
        zkClient.createPersistent(path, data);
    }

    /**
     * 读取数据
     *
     * @param path 路径
     * @return 实例
     */
    public T readData(String path) {
        return zkClient.readData(path);

    }

    /**
     * 获取子节点
     *
     * @param path 路径
     * @return 子节点
     */
    public List<String> getChildren(String path) {
        return zkClient.getChildren(path);

    }

    /**
     * 写入数据
     *
     * @param path   路径
     * @param object 写入对象
     */
    public void writeData(String path, Object object) {
        zkClient.writeData(path, object);

    }

    /**
     * 递归删除
     *
     * @param path 路径
     */
    public void deleteRecursive(String path) {
        zkClient.deleteRecursive(path);

    }


    /***
     * 支持创建递归方式
     * @param path 路径
     * @param createParents 是否递归创建
     */
    public void createPersistent(String path, boolean createParents) {
        zkClient.createPersistent(path, createParents);
    }

    public void close() {
        zkClient.close();
    }

    public void lister(String path) {
        //对父节点添加监听变化。
        zkClient.subscribeDataChanges(path, new IZkDataListener() {
            @Override
            public void handleDataChange(String dataPath, Object data) throws Exception {
                log.info("变更的节点为:[{}],[{}]", dataPath, data);
            }

            @Override
            public void handleDataDeleted(String dataPath) throws Exception {
                log.info("删除的节点为:[{}]", dataPath);
            }
        });
        //对父节点添加监听子节点变化。
        zkClient.subscribeChildChanges(path,
                (parentPath, currentChilds) ->
                        log.info("parentPath: [{}],currentChilds:[{}]"
                                , parentPath
                                , currentChilds)
        );
        //对父节点添加监听子节点变化。
        zkClient.subscribeStateChanges(new IZkStateListener() {
            @Override
            public void handleStateChanged(Watcher.Event.KeeperState state) throws Exception {
                if (state == Watcher.Event.KeeperState.SyncConnected) {
                    // 当我重新启动后start，监听触发
                    log.info("连接成功");
                } else if (state == Watcher.Event.KeeperState.Disconnected) {
                    // 当我在服务端将zk服务stop时，监听触发
                    log.info("连接断开");
                } else {
                    log.info("其他状态[{}]", state);
                }
            }

            @Override
            public void handleNewSession() throws Exception {
                log.info("重建session");
            }

            @Override
            public void handleSessionEstablishmentError(Throwable error) throws Exception {
            }
        });

    }
}
