package com.db117.example.test.jvm;

/**
 * 置空测试
 *
 * @author 117
 * @date 2019/8/14/014
 */
public class NullTest {
    /**
     * -Xms50M -Xmx50M -verbose:gc -XX:+PrintGCDetails -XX:+HeapDumpOnOutOfMemoryError
     */
    public static void main(String[] args) throws InterruptedException {
        // 20M
        int[] data = new int[1024 * 1024 * 5];
        data = null;
        // 20M
        int[] data1 = new int[1024 * 1024 * 5];
        data1 = null;
        int[] data2 = new int[1024 * 1024 * 5];
    }
}
