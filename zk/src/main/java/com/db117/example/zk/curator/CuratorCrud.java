package com.db117.example.zk.curator;

import lombok.extern.slf4j.Slf4j;
import org.apache.curator.RetryPolicy;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.apache.zookeeper.CreateMode;

/**
 * @author db117
 */
@Slf4j
public class CuratorCrud {
    private CuratorFramework cf;

    public CuratorCrud() {
        //1 重试策略：初试时间为1s 重试10次
        RetryPolicy retryPolicy = new ExponentialBackoffRetry(1000, 10);
        //2 通过工厂创建连接
        String connectString = "127.0.0.1:2181";
        cf = CuratorFrameworkFactory.builder()
                .connectString(connectString)
                .sessionTimeoutMs(5000)
                .retryPolicy(retryPolicy)
                .build();
        //3 开启连接
        cf.start();
    }

    public String createPersistent(String path, String data) {
        try {
            cf.create()
                    .creatingParentsIfNeeded()
                    .withMode(CreateMode.PERSISTENT)
                    .forPath(path, data.getBytes());
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }

        return null;
    }

    public String getData(String path) {
        try {
            return new String(cf.getData().forPath(path));
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }
        return null;
    }


    public void delete(String path) {
        try {
            cf.delete().guaranteed().deletingChildrenIfNeeded().forPath(path);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }

    }


    public void setData(String path, String data) {
        try {
            cf.setData().forPath(path, data.getBytes());
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }
    }

}
