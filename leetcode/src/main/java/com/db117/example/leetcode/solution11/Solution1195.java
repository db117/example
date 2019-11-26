package com.db117.example.leetcode.solution11;

import java.util.function.IntConsumer;

/**
 * 1195. 交替打印字符串
 * 编写一个可以从 1 到 n 输出代表这个数字的字符串的程序，但是：
 * <p>
 * 如果这个数字可以被 3 整除，输出 "fizz"。
 * 如果这个数字可以被 5 整除，输出 "buzz"。
 * 如果这个数字可以同时被 3 和 5 整除，输出 "fizzbuzz"。
 * 例如，当 n = 15，输出： 1, 2, fizz, 4, buzz, fizz, 7, 8, fizz, buzz, 11, fizz, 13, 14, fizzbuzz。
 * <p>
 * 假设有这么一个类：
 * <p>
 * class FizzBuzz {
 *   public FizzBuzz(int n) { ... }               // constructor
 * public void fizz(printFizz) { ... }          // only output "fizz"
 * public void buzz(printBuzz) { ... }          // only output "buzz"
 * public void fizzbuzz(printFizzBuzz) { ... }  // only output "fizzbuzz"
 * public void number(printNumber) { ... }      // only output the numbers
 * }
 * 请你实现一个有四个线程的多线程版  FizzBuzz， 同一个 FizzBuzz 实例会被如下四个线程使用：
 * <p>
 * 线程A将调用 fizz() 来判断是否能被 3 整除，如果可以，则输出 fizz。
 * 线程B将调用 buzz() 来判断是否能被 5 整除，如果可以，则输出 buzz。
 * 线程C将调用 fizzbuzz() 来判断是否同时能被 3 和 5 整除，如果可以，则输出 fizzbuzz。
 * 线程D将调用 number() 来实现输出既不能被 3 整除也不能被 5 整除的数字。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/fizz-buzz-multithreaded
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author db117
 * @date 2019/11/21/021 16:28
 */
public class Solution1195 {
    class FizzBuzz {
        private int n;
        private int i = 1;
        private final Object lock = new Object();

        public FizzBuzz(int n) {
            this.n = n;
        }

        // printFizz.run() outputs "fizz".
        public void fizz(Runnable printFizz) throws InterruptedException {
            while (i <= n) {
                synchronized (lock) {
                    int num = i;
                    if (num <= n && num % 3 == 0 && num % 5 != 0) {
                        i++;
                        printFizz.run();
                    }
                }
            }

        }

        // printBuzz.run() outputs "buzz".
        public void buzz(Runnable printBuzz) throws InterruptedException {
            while (i <= n) {
                synchronized (lock) {
                    int num = i;
                    if (num <= n && num % 3 != 0 && num % 5 == 0) {
                        i++;
                        printBuzz.run();
                    }
                }
            }
        }

        // printFizzBuzz.run() outputs "fizzbuzz".
        public void fizzbuzz(Runnable printFizzBuzz) throws InterruptedException {
            while (i <= n) {
                synchronized (lock) {
                    int num = i;
                    if (num <= n && num % 15 == 0) {
                        i++;
                        printFizzBuzz.run();
                    }
                }
            }
        }

        // printNumber.accept(x) outputs "x", where x is an integer.
        public void number(IntConsumer printNumber) throws InterruptedException {
            while (i <= n) {
                synchronized (lock) {
                    int num = i;
                    if (num <= n && num % 3 != 0 && num % 5 != 0) {
                        i++;
                        printNumber.accept(num);
                    }
                }
            }
        }

    }
}
