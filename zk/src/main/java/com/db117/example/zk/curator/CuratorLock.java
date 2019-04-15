package com.db117.example.zk.curator;

import lombok.extern.slf4j.Slf4j;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.framework.recipes.locks.InterProcessMutex;
import org.apache.curator.retry.ExponentialBackoffRetry;

/**
 * @author 117
 */
@Slf4j
public class CuratorLock implements Runnable {

    private final static CuratorFramework client = CuratorFrameworkFactory.builder()
            .connectString("127.0.0.1:2181")
            .retryPolicy(new ExponentialBackoffRetry(100, 1))
            .build();
    private static int i = 0;
    private final InterProcessMutex lock = new InterProcessMutex(client, "/lock");


    public static void main(String[] args) throws InterruptedException {
        long l = System.currentTimeMillis();
        client.start();
        CuratorLock lockTest2 = new CuratorLock();
        Thread t1 = new Thread(lockTest2);
        Thread t2 = new Thread(lockTest2);
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        log.info(String.valueOf(i));
        log.info(String.valueOf(System.currentTimeMillis() - l));
    }

    @Override
    public void run() {
        try {
            for (int j = 0; j < 30; j++) {
                lock.acquire();

                i++;
                lock.release();
            }

        } catch (Exception e) {
            log.info(e.getMessage(), e);
        }


    }
}
