package com.example.elasticsearch.contorller;

import cn.hutool.core.collection.IterUtil;
import cn.hutool.core.util.RandomUtil;
import com.example.elasticsearch.dao.SearchInfoDao;
import com.example.elasticsearch.entity.SearchInfo;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.action.search.SearchType;
import org.elasticsearch.index.query.*;
import org.elasticsearch.search.aggregations.Aggregation;
import org.elasticsearch.search.aggregations.AggregationBuilders;
import org.elasticsearch.search.aggregations.Aggregations;
import org.elasticsearch.search.aggregations.bucket.terms.StringTerms;
import org.elasticsearch.search.aggregations.bucket.terms.Terms;
import org.elasticsearch.search.aggregations.bucket.terms.TermsAggregationBuilder;
import org.elasticsearch.search.aggregations.metrics.valuecount.ValueCountAggregationBuilder;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.core.ResultsExtractor;
import org.springframework.data.elasticsearch.core.query.NativeSearchQuery;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * @author 大兵
 * @date 2018-09-10 22:08
 **/
@RestController
public class SearchController {
    @Autowired
    private SearchInfoDao searchInfoDao;
    @Autowired
    private ElasticsearchTemplate template;
    //http://localhost:8888/save
    @GetMapping("save")
    public String save() {
        for (int i = 0; i < 1000; i++) {

            SearchInfo searchInfo = new SearchInfo().setId(System.currentTimeMillis()).setFieldId(RandomUtil.randomLong(0, Long.MAX_VALUE))
                    .setIdCard(RandomUtil.randomLong(0, Long.MAX_VALUE) + "").setValue(RandomUtil.randomUUID());
            searchInfoDao.save(searchInfo);
        }
        return "success";
    }

    //http://localhost:8888/delete?id=1525415333329
    @GetMapping("delete")
    public String delete(long id) {
        searchInfoDao.deleteById(id);
        return "success";
    }

    //http://localhost:8888/update?id=1525417362754&name=修改&description=修改
    @GetMapping("update")
    public String update(long id, String name, String description) {
        SearchInfo searchInfo = new SearchInfo();
        searchInfoDao.save(searchInfo);
        return "success";
    }

    //http://localhost:8888/getOne?id=1525417362754
    @GetMapping("getOne")
    public SearchInfo getOne(long id) {
        return searchInfoDao.findById(id).orElse(null);
    }

    @GetMapping("searchAll")
    public List<SearchInfo> search(String s) {
        List<SearchInfo> list = new ArrayList<>();

        BoolQueryBuilder query = QueryBuilders.boolQuery();
        Iterable<SearchInfo> all = searchInfoDao.findAll();

        all.forEach(list::add);
        return list;
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
                        .subAggregation(AggregationBuilders.count("count_idCard").field("idCard.keyword")))
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
        return searchInfoDao.findByIdCardLike("*2831261757459", PageRequest.of(0, 120));
    }

    @GetMapping("countByValueLike")
    public List countByValueLike() {
        return searchInfoDao.countByValueLike("*45*");
    }


    @RequestMapping("aggr")
    @ResponseBody
    public List aggr() {

        //目标：搜索写博客写得最多的用户（一个博客对应一个用户），通过搜索博客中的用户名的频次来达到想要的结果
        //首先新建一个用于存储数据的集合
        List<String> ueserNameList = new ArrayList<>();
        //1.创建查询条件，也就是QueryBuild
        QueryBuilder matchAllQuery = QueryBuilders.matchAllQuery();//设置查询所有，相当于不设置查询条件
        //2.构建查询
        NativeSearchQueryBuilder nativeSearchQueryBuilder = new NativeSearchQueryBuilder();
        //2.0 设置QueryBuilder
        nativeSearchQueryBuilder.withQuery(matchAllQuery);
        //2.1设置搜索类型，默认值就是QUERY_THEN_FETCH，参考https://blog.csdn.net/wulex/article/details/71081042
        nativeSearchQueryBuilder.withSearchType(SearchType.QUERY_THEN_FETCH);//指定索引的类型，只先从各分片中查询匹配的文档，再重新排序和排名，取前size个文档
        //2.2指定索引库和文档类型
        nativeSearchQueryBuilder.withIndices("user").withTypes("info");//指定要查询的索引库的名称和类型，其实就是我们文档@Document中设置的indedName和type
        //2.3重点来了！！！指定聚合函数,本例中以某个字段分组聚合为例（可根据你自己的聚合查询需求设置）
        //该聚合函数解释：计算该字段(假设为username)在所有文档中的出现频次，并按照降序排名（常用于某个字段的热度排名）
        TermsAggregationBuilder order = AggregationBuilders.terms("给聚合查询取的名").field("idCard").order(Terms.Order.count(false));
        nativeSearchQueryBuilder.addAggregation(order);
        //2.4构建查询对象
        NativeSearchQuery nativeSearchQuery = nativeSearchQueryBuilder.build();
        //3.执行查询
        //3.1方法1,通过reporitory执行查询,获得有Page包装了的结果集
        Page<SearchInfo> search = searchInfoDao.search(nativeSearchQuery);
        List<SearchInfo> content = search.getContent();
        for (SearchInfo esBlog : content) {
            ueserNameList.add(esBlog.getIdCard());
        }
        //获得对应的文档之后我就可以获得该文档的作者，那么就可以查出最热门用户了
        //3.2方法2,通过elasticSearch模板elasticsearchTemplate.queryForList方法查询
        List<SearchInfoDao> queryForList = template.queryForList(nativeSearchQuery, SearchInfoDao.class);
        //3.3方法3,通过elasticSearch模板elasticsearchTemplate.query()方法查询,获得聚合(常用)
        Aggregations aggregations = template.query(nativeSearchQuery, new ResultsExtractor<Aggregations>() {
            @Override
            public Aggregations extract(SearchResponse response) {
                return response.getAggregations();
            }
        });
        //转换成map集合
        Map<String, Aggregation> aggregationMap = aggregations.asMap();
        //获得对应的聚合函数的聚合子类，该聚合子类也是个map集合,里面的value就是桶Bucket，我们要获得Bucket
        StringTerms stringTerms = (StringTerms) aggregationMap.get("给聚合查询取的名");
        //获得所有的桶
        List<StringTerms.Bucket> buckets = stringTerms.getBuckets();
        //将集合转换成迭代器遍历桶,当然如果你不删除buckets中的元素，直接foreach遍历就可以了
        Iterator<StringTerms.Bucket> iterator = buckets.iterator();

        while (iterator.hasNext()) {
            //bucket桶也是一个map对象，我们取它的key值就可以了
            String username = iterator.next().getKeyAsString();//或者bucket.getKey().toString();
            //根据username去结果中查询即可对应的文档，添加存储数据的集合
            ueserNameList.add(username);
        }
        //最后根据ueserNameList搜索对应的结果集

        return ueserNameList;

    }

}
