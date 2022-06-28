package com.db117.example.util;

import cn.hutool.core.collection.CollUtil;
import com.baomidou.mybatisplus.extension.conditions.query.ChainQuery;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.extern.slf4j.Slf4j;

import java.util.function.Consumer;

/**
 * myBatis-Plus 分页处理数据工具
 *
 * @author db117
 * @since 2022/6/28 15:41
 **/
@Slf4j
public class MyBatisPlusPageUtil {
    /**
     * 分页处理数据
     *
     * @param query    查询条件
     * @param pageSize 分页大小
     * @param consumer 消费数据
     * @param <T>      泛型
     */
    public static <T> void process(ChainQuery<T> query, int pageSize, Consumer<T> consumer) {
        int cur = 1;
        Page<T> page = query.page(new Page<>(cur, pageSize));

        while (CollUtil.isNotEmpty(page.getRecords())) {
            for (T record : page.getRecords()) {
                try {
                    consumer.accept(record);
                } catch (Exception e) {
                    log.error(e.getMessage(), e);
                }
            }

            if (!page.hasNext()) {
                break;
            }

            cur++;
            page = query.page(new Page<>(cur, pageSize));
        }
    }
}
