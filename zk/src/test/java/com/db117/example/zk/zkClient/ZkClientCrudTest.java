package com.db117.example.zk.zkClient;

import com.db117.example.common.domain.User;
import org.junit.*;

import java.time.LocalDate;

@Ignore
public class ZkClientCrudTest {
    private ZkClientCrud<User> client;

    @Before
    public void setUp() {
        client = new ZkClientCrud<>();
        client.createPersistent("/test/aaa", true);
        client.writeData("/test/aaa"
                , User.builder()
                        .age(17)
                        .birthday(LocalDate.now())
                        .name("117")
                        .build());
    }

    @After
    public void tearDown() throws Exception {
        client.deleteRecursive("/test");
        client.close();
    }


    @Test
    public void readData() {
        User user = client.readData("/test/aaa");
        Assert.assertEquals(User.builder()
                .age(17)
                .birthday(LocalDate.now())
                .name("117")
                .build(), user);
    }

}