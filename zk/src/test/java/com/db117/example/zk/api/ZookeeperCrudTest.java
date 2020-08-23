package com.db117.example.zk.api;

import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.data.Stat;
import org.junit.*;

@Ignore
public class ZookeeperCrudTest {
    private ZookeeperCrud crud;

    @Before
    public void setUp() throws Exception {
        crud = new ZookeeperCrud();
        crud.createPersistent("/test", "test");
    }

    @After
    public void tearDown() throws Exception {
        crud.deleteRecursive("/test");
        crud.close();
    }

    @Test
    public void createPersistent() {
        String path = "/test/Persistent";
        String test = crud.createPersistent(path, "test");
        Assert.assertEquals(test, path);
    }

    @Test
    public void createEphemeral() throws KeeperException, InterruptedException {
        String path = "/test/Ephemeral";
        String data = "test";

        String test = crud.createPersistent(path, data);
        String result = crud.getData(path);

        Assert.assertEquals(test, path);
        Assert.assertEquals(result, data);
    }


    @Test
    public void setData() throws KeeperException, InterruptedException {
        String path = "/test/Persistent";
        crud.createPersistent(path, "test");
        Stat stat = crud.setData(path, "Persistent");
        String data = crud.getData(path);
        Assert.assertEquals(data, "Persistent");
    }

    @Test
    public void exists() throws KeeperException, InterruptedException {
        Stat exists = crud.exists("/test");
        Assert.assertNotNull(exists);
    }

}