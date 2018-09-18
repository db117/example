package com.example.elasticsearch.contorller;

import cn.hutool.core.collection.IterUtil;
import cn.hutool.core.util.RandomUtil;
import com.example.elasticsearch.dao.SearchInfoDao;
import com.example.elasticsearch.entity.SearchInfo;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.MatchQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.index.query.WildcardQueryBuilder;
import org.elasticsearch.search.aggregations.AbstractAggregationBuilder;
import org.elasticsearch.search.aggregations.Aggregation;
import org.elasticsearch.search.aggregations.AggregationBuilders;
import org.elasticsearch.search.aggregations.metrics.sum.SumAggregationBuilder;
import org.elasticsearch.search.aggregations.metrics.valuecount.ValueCountAggregationBuilder;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.elasticsearch.core.query.NativeSearchQuery;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.data.elasticsearch.core.query.UpdateQueryBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 大兵
 * @date 2018-09-10 22:08
 **/
@RestController
public class SearchController {
    @Autowired
    private SearchInfoDao searchInfoDao;

    //http://localhost:8888/save
    @GetMapping("save")
    public String save(){
        for (int i = 0; i < 1000; i++) {

            SearchInfo searchInfo = new SearchInfo().setId(System.currentTimeMillis()).setFieldId(RandomUtil.randomLong(0,Long.MAX_VALUE))
                    .setIdCard(RandomUtil.randomLong(0,Long.MAX_VALUE)+"").setValue(RandomUtil.randomUUID());
            searchInfoDao.save(searchInfo);
        }
        return "success";
    }

    //http://localhost:8888/delete?id=1525415333329
    @GetMapping("delete")
    public String delete(long id){
        searchInfoDao.deleteById(id);
        return "success";
    }

    //http://localhost:8888/update?id=1525417362754&name=修改&description=修改
    @GetMapping("update")
    public String update(long id,String name,String description){
        SearchInfo searchInfo = new SearchInfo();
        searchInfoDao.save(searchInfo);
        return "success";
    }

    //http://localhost:8888/getOne?id=1525417362754
    @GetMapping("getOne")
    public SearchInfo getOne(long id){
        return searchInfoDao.findById(id).orElse(null);
    }

    @GetMapping("searchAll")
    public List<SearchInfo> search(String s) {
        List<SearchInfo> list = new ArrayList<>();

        BoolQueryBuilder query = QueryBuilders.boolQuery();
        Iterable<SearchInfo> all = searchInfoDao.findAll();

        all.forEach(list::add);
        return  list;
    }

    @GetMapping("wildcardQuery")
    public List<SearchInfo> wildcardQuery() {
        BoolQueryBuilder boolQuery = QueryBuilders.boolQuery();

        WildcardQueryBuilder wildcardQuery = QueryBuilders.wildcardQuery("value", "*2*");

        MatchQueryBuilder matchQuery = QueryBuilders.matchQuery("idCard", "2417974083318229614");

        boolQuery.must(wildcardQuery);
//                .must(matchQuery);


        NativeSearchQuery build = new NativeSearchQueryBuilder()
                .addAggregation(AggregationBuilders.terms("idCard").field("idCard.keyword").size(Integer.MAX_VALUE)
                        .subAggregation(AggregationBuilders.count("count_idCard").field("idCard.keyword")) )
//                .addAggregation(AggregationBuilders.count("sum_sales").field("idCard"))
                .withQuery(boolQuery)
                .build();



        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();

        System.out.println(searchSourceBuilder.aggregation(AggregationBuilders.terms("sss").field("idCard.keyword").size(Integer.MAX_VALUE)
                .subAggregation(AggregationBuilders.count("sum_sales").field("idCard.keyword"))).toString());

        System.out.println(build.getQuery());
        Iterable<SearchInfo> iterable = searchInfoDao.search(build);
        return IterUtil.toList(iterable);
    }


    @GetMapping("group")
    public List<SearchInfo> group() {
        WildcardQueryBuilder wildcardQuery = QueryBuilders.wildcardQuery("value", "*2*");
        ValueCountAggregationBuilder count = AggregationBuilders.count("idCard");

        return null;
    }


    @GetMapping("findByIdCardLike")
    public List<SearchInfo> findByIdCardLike() {
        return searchInfoDao.findByIdCardLike("*2831261757459",  PageRequest.of(0, 120));
    }
    @GetMapping("countByValueLike")
    public List countByValueLike() {
        return searchInfoDao.countByValueLike("*45*");
    }
    //每页数量
    private Integer PAGESIZE=10;


    @GetMapping("findDistinctIdCardByValueLike")
    public List findDistinctByValueIsLike() {
        return searchInfoDao.findDistinctIdCardByValueLike("*5*");
    }
    //http://localhost:8888/getGoodsList?query=商品
    //http://localhost:8888/getGoodsList?query=商品&pageNumber=1
    //根据关键字"商品"去查询列表，name或者description包含的都查询
//    @GetMapping("getGoodsList")
//    public List<SearchInfo> getList(Integer pageNumber, String query){
//        if(pageNumber==null) pageNumber = 0;
//        //es搜索默认第一页页码是0
//        SearchQuery searchQuery=getEntitySearchQuery(pageNumber,PAGESIZE,query);
//        Page<SearchInfo> goodsPage = searchInfoDao.search(searchQuery);
//        return goodsPage.getContent();
//    }


//    private SearchQuery getEntitySearchQuery(int pageNumber, int pageSize, String searchContent) {
//        FunctionScoreQueryBuilder functionScoreQueryBuilder = QueryBuilders.functionScoreQuery()
//                .add(QueryBuilders.matchPhraseQuery("name", searchContent),
//                        ScoreFunctionBuilders.weightFactorFunction(100))
//                .add(QueryBuilders.matchPhraseQuery("description", searchContent),
//                        ScoreFunctionBuilders.weightFactorFunction(100))
//                //设置权重分 求和模式
//                .scoreMode("sum")
//                //设置权重分最低分
//                .setMinScore(10);
//
//        // 设置分页
//        Pageable pageable = new PageRequest(pageNumber, pageSize);
//        return new NativeSearchQueryBuilder()
//                .withPageable(pageable)
//                .withQuery(functionScoreQueryBuilder).build();
//    }

}
