package com.db117.example.util;

import cn.hutool.core.util.RandomUtil;
import lombok.Cleanup;
import lombok.extern.slf4j.Slf4j;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.StringField;
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.index.Term;
import org.apache.lucene.search.*;
import org.apache.lucene.store.ByteBuffersDirectory;
import org.apache.lucene.store.Directory;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * 单字段通配符搜索
 *
 * @author db117
 * @date 2019/10/29/029 17:06
 */
@Slf4j
public class SingleSearchUtil {
    public static void main(String[] args) throws IOException {
        SingleSearchUtil util = new SingleSearchUtil();
        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i < 10000; i++) {
            list.add(RandomUtil.randomString(20));
        }
        util.addAll(list);

        long l = System.currentTimeMillis();
        for (int i = 0; i < 100; i++) {
            util.search("*117*", 10).forEach(System.out::println);
        }
        System.out.println(System.currentTimeMillis() - l);
    }

    private Directory directory = new ByteBuffersDirectory();
    private IndexWriterConfig defaultConfig = new IndexWriterConfig();

    /**
     * 添加单个数据
     */
    public void add(String data) {
        StringField only = new StringField("only", data, Field.Store.YES);
        try {
            @Cleanup IndexWriter writer = new IndexWriter(directory, defaultConfig);
            writer.addDocument(Collections.singletonList(only));
        } catch (IOException e) {
            log.warn(e.getMessage(), e);
        }
    }

    /**
     * 批量添加
     */
    public void addAll(Collection<String> collection) {
        try {
            @Cleanup IndexWriter writer = new IndexWriter(directory, defaultConfig);
            for (String s : collection) {
                StringField only = new StringField("only", s, Field.Store.YES);
                writer.addDocument(Collections.singletonList(only));
            }
        } catch (IOException e) {
            log.warn(e.getMessage(), e);
        }
    }

    /**
     * 搜索
     *
     * @param search 搜索
     * @param size   页大小
     */
    public List<String> search(String search, Integer size) {
        if (size == null) {
            size = 10;
        }
        List<String> res = new ArrayList<>();
        // 搜索条件
        Query query = new WildcardQuery(new Term("only", search));
        try {
            @Cleanup DirectoryReader reader = DirectoryReader.open(directory);
            IndexSearcher searcher = new IndexSearcher(reader);
            TopDocs tops = searcher.search(query, size);

            for (ScoreDoc scoreDoc : tops.scoreDocs) {
                res.add(searcher.doc(scoreDoc.doc).get("only"));
            }
        } catch (IOException e) {
            log.warn(e.getMessage(), e);
        }
        return res;
    }
}
