package com.example.elasticsearch.dao;

import com.example.elasticsearch.entity.SearchInfo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

/**
 * @author 大兵
 * @date 2018-09-10 22:02
 **/
public interface SearchInfoDao extends ElasticsearchRepository<SearchInfo,Long> {
    public List<SearchInfo> findByIdCardLike(String idCard, Pageable page);

    List<Object> countByValueLike(String value);

    List<SearchInfo> findDistinctIdCardByValueLike(String value);

}
