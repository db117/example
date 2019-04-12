package com.db117.example.common.domain;

import lombok.Builder;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * 对象
 *
 * @author db117
 * @date 2019/4/12
 **/
@Slf4j
@Data
@Builder
public class User implements Serializable {
    /**
     * 姓名
     */
    private String name;
    /**
     * 年龄
     */
    private Integer age;
    /**
     * 生日
     */
    private LocalDate birthday;
}
