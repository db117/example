package com.example.elasticsearch.entity;

import lombok.Data;
import lombok.experimental.Accessors;
import org.springframework.data.elasticsearch.annotations.Document;

import java.io.Serializable;

/**
 * 查询详情
 *
 * @author 大兵
 * @date 2018-09-10 21:51
 **/
@Document(indexName = "user",type = "info")
@Data
@Accessors(chain = true)
public class SearchInfo implements Serializable {

    /**
     * 记录id
     */
    private Long id;
    /**
     * 身份证
     */
    private String idCard;
    /**
     * 字段id
     */
    private Long fieldId;
    /**
     * 值
     */
    private String value;
}
