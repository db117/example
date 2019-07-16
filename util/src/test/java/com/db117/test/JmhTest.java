package com.db117.test;

import lombok.extern.slf4j.Slf4j;
import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.Fork;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.State;

/**
 * @author db117
 * @date 2019/7/16
 **/
@Slf4j
@State(Scope.Benchmark)
public class JmhTest {

    public String testString = "fdasfawetgefgasdgegertasetawetwatastest";

    @Benchmark
    @Fork(1)
    public void reverseTest1() {
        //  25383923.581 ±(99.9%) 13248323.941 ops/s [Average]
        //  (min, avg, max) = (19728013.520, 25383923.581, 27919917.471), stdev = 3440547.656
        //  CI (99.9%): [12135599.640, 38632247.521] (assumes normal distribution)
        reverseString(testString.toCharArray());
    }

    @Benchmark
    @Fork(1)
    public void reverseTest2() {
        // 18528672.342 ±(99.9%) 403193.232 ops/s [Average]
        //  (min, avg, max) = (18435242.840, 18528672.342, 18679032.004), stdev = 104708.002
        //  CI (99.9%): [18125479.111, 18931865.574] (assumes normal distribution)
        reverseString1(testString.toCharArray());
    }

    public void reverseString(char[] s) {
        int left = 0, right = s.length - 1;
        while (left < right) {
            // 头尾交换
            char c = s[left];
            s[left] = s[right];
            s[right] = c;
            left++;
            right--;
        }
    }

    public void reverseString1(char[] s) {
        int left = 0, right = s.length - 1;
        while (left < right) {
            // 异或交换
            s[left] ^= s[right];
            s[right] ^= s[left];
            s[left] ^= s[right];
            left++;
            right--;
        }
    }
}
