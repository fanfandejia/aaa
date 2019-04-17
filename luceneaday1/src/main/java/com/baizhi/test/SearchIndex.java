package com.baizhi.test;

import org.apache.lucene.document.Document;
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.index.Term;
import org.apache.lucene.search.*;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;

import java.io.File;
import java.io.IOException;

public class SearchIndex {
    public static void main(String[] args) throws IOException {
        //指定索引库的位置
        Directory dir = FSDirectory.open(new File("E:/后期项目/lucene/index"));
        //创建索引搜索器
        IndexReader reader= DirectoryReader.open(dir);
        IndexSearcher indexSearcher=new IndexSearcher(reader);
        //指定搜索条件和内容
        Query query=new TermQuery(new Term("title","背影"));
        //参数query：搜索条件和内容    n:要查询多少条
        TopDocs topDocs = indexSearcher.search(query, 20);
        ScoreDoc[] scoreDocs = topDocs.scoreDocs;
        for (int i = 0; i < scoreDocs.length; i++) {
            ScoreDoc scoreDoc = scoreDocs[i];
            int doc = scoreDoc.doc;
            Document document = indexSearcher.doc(doc);
            System.out.println(scoreDoc.score);
            System.out.println("编号"+document.get("id"));
            System.out.println("标题"+document.get("title"));
            System.out.println("作者"+document.get("author"));
            System.out.println("内容"+document.get("content"));
        }


    }
}
