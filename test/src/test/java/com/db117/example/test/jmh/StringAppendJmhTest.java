package com.db117.example.test.jmh;

import lombok.extern.slf4j.Slf4j;
import org.openjdk.jmh.annotations.*;

import java.util.HashMap;
import java.util.Map;

/**
 * string拼接测试
 *
 * @author db117
 * @since 2020/7/29 16:11
 */
@Slf4j
@State(Scope.Benchmark)
public class StringAppendJmhTest {

    private Map<String, String> data;

    @Setup
    public void buildTestData() {


        data = new HashMap<>();

        for (int i = 0; i < 10000; i++) {
            data.put(i + "k", i + "v");
        }
    }

    @Benchmark
    @Fork(1)
    public void add() {
        data.forEach((s, s2) -> {
            String res = s + s2;
        });
    }

    @Benchmark
    @Fork(1)
    public void format() {
        data.forEach((s, s2) -> {
            String res = String.format("%s%s", s, s2);
        });
    }

    @Benchmark
    @Fork(1)
    public void stringBuild() {
        data.forEach((s, s2) -> {
            String res = new StringBuilder().append(s).append(s2).toString();
        });
    }


}
