package com.db117.example.util;

import org.springframework.scheduling.support.CronSequenceGenerator;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.TimeZone;

/**
 * 定时任务表达式工具类
 *
 * @author 大兵-db117
 * @since 2020/8/11 15:23
 */
public class CronPatternUtil {

    public static void main(String[] args) {
        long s = System.currentTimeMillis();
        System.out.println(beforeDate("0 0 0 20 8 *"));
        System.out.println(System.currentTimeMillis() - s);
    }

    /**
     * 当前时间前一次执行的时间
     *
     * @param pattern 表达式
     * @return 上一次应该执行的时间
     */
    public static LocalDateTime beforeDate(String pattern) {
        // 当前时间
        long s = System.currentTimeMillis();
        Date curDate = new Date(s);
        // Cron序列发生器
        CronSequenceGenerator generator = new CronSequenceGenerator(pattern,
                TimeZone.getDefault());
        // 计算步长
        long step = generator.next(curDate).getTime() - s;

        // 往前一步一步计算
        for (long l = s - step; l > 0; l -= step) {
            Date temp = generator.next(new Date(l));
            // 找到第一个比当前时间小的
            if (temp.before(curDate)) {
                return LocalDateTime.ofInstant(Instant.ofEpochMilli(temp.getTime()),
                        ZoneId.systemDefault());
            }
        }
        // 没有找到返回最小值
        return LocalDateTime.MIN;
    }
}