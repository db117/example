package com.db117.example.test.jmh;


import lombok.extern.slf4j.Slf4j;
import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.results.format.ResultFormatType;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

/**
 * string遍历测试
 *
 * @author db117
 * @since 2020/7/29 16:11
 */
@Slf4j
@State(Scope.Benchmark)
public class StringForEachJmhTest {
    public String testString;
    private int len = 10000;

    public static void main(String[] args) throws RunnerException {
        Options opt = new OptionsBuilder()
                .include(StringForEachJmhTest.class.getSimpleName())
                .resultFormat(ResultFormatType.JSON).build();
        new Runner(opt).run();
    }


    @Setup
    public void buildTestData() {

        StringBuilder b = new StringBuilder(len);

        for (int i = 0; i < len; i++) {
            b.append((char) i % 128);
        }

        testString = b.toString();
    }

    @Benchmark
    @Fork(1)
    public void charAt() {
        for (int i = 0; i < len; i++) {
            char c = testString.charAt(i);

        }
    }

    @Benchmark
    @Fork(1)
    public void toCharArray() {
        char[] chars = testString.toCharArray();
        for (char c : chars) {

        }
    }
}
