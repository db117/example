package com.db117.example.util;

import lombok.Cleanup;
import lombok.Data;
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
 * 文本关键字搜索
 *
 * @author db117
 * @since 2020/12/4
 */
@Slf4j
public class TextSearchUtil {

    private static final Directory directory = new ByteBuffersDirectory();
    private static final IndexWriterConfig defaultConfig = new IndexWriterConfig();

    private static DirectoryReader reader;

    static {
        try {
            reader = DirectoryReader.open(directory);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        TextSearchUtil.add("123", "2342");
        TextSearchUtil.append("123", "4444444");

        System.out.println(TextSearchUtil.getByKey("123"));
    }

    /**
     * 添加单个数据
     */
    public static void add(String key, String text) {
        // 先删除

        try {
            IndexWriter writer = new IndexWriter(directory, defaultConfig);
            writer.deleteDocuments(new Term("key", key));

            List<StringField> list = new ArrayList<>(2);
            list.add(new StringField("key", key, Field.Store.YES));
            list.add(new StringField("text", text, Field.Store.YES));
            writer.addDocument(list);

            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        // 添加


    }

    public static void delete(String key) {
        try {
            IndexWriter writer = new IndexWriter(directory, defaultConfig);
            writer.deleteDocuments(new Term("key", key));

            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void append(String key, String text) {
        try {
            IndexSearcher searcher = new IndexSearcher(reader);
            TopDocs docs = searcher
                    .search(new TermQuery(new Term("key", key)), 1);

            int doc = docs.scoreDocs[0].doc;

            String oldText = searcher.doc(doc).get("text");

            IndexWriter writer = new IndexWriter(directory, defaultConfig);
            writer.updateDocValues(new Term("key", key),
                    new StringField("text", oldText + text, Field.Store.YES));

            writer.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static String getByKey(String key) {
        try {
            IndexSearcher searcher = new IndexSearcher(reader);
            TopDocs docs = searcher
                    .search(new TermQuery(new Term("key", key)), 1);

            return searcher.doc(0).get("text");


        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
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

    @Data
    public static class SearchObject {
        /**
         * 关键
         */
        private String key;
        /**
         * 搜索文本
         */
        private String text;
    }
}
