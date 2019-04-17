package com.baizhi.test;

import com.baizhi.util.LuceneUtil;
import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.StringField;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.index.Term;
import org.apache.lucene.search.*;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;
import org.apache.lucene.util.Version;
import org.junit.Test;

import java.io.File;
import java.io.IOException;

public class TestLucene {
    @Test
    public void testDelete() throws IOException {
        //声明一个文件夹为索引库
        Directory dir = FSDirectory.open(new File("E:/后期项目/lucene/index"));
        //创建标准分词器对象
        Analyzer analyzer=new StandardAnalyzer(Version.LUCENE_44);
        //索引写入器的相关配置
        IndexWriterConfig conf =new  IndexWriterConfig(Version.LUCENE_44, analyzer);
        //参数1：索引的目录  参数2：索引写入器的相关配置
        IndexWriter indexWriter= new IndexWriter(dir,conf);
        //   indexWriter.deleteAll();
        indexWriter.deleteDocuments(new TermQuery(new Term("id","9")));
        indexWriter.commit();
        indexWriter.close();
    }
    @Test
    public void testUpdate() throws IOException {
        //声明一个文件夹为索引库
        Directory dir = FSDirectory.open(new File("E:/后期项目/lucene/index"));
        //创建标准分词器对象
        Analyzer analyzer=new StandardAnalyzer(Version.LUCENE_44);
        //索引写入器的相关配置
        IndexWriterConfig conf =new  IndexWriterConfig(Version.LUCENE_44, analyzer);
        //参数1：索引的目录  参数2：索引写入器的相关配置
        IndexWriter indexWriter= new IndexWriter(dir,conf);
        Document document=new Document();
        document.add(new StringField("title","背影", Field.Store.YES));
        document.add(new StringField("author","朱自清",Field.Store.YES));
        document.add(new StringField("content","你站在这里不要动，我去给你买几个橘子",Field.Store.YES));
        document.add(new StringField("id","11",Field.Store.YES));
        indexWriter.updateDocument(new Term("id","11"),document);

        indexWriter.commit();
        indexWriter.close();
    }
    @Test
    public void add(){
        IndexWriter indexWriter= LuceneUtil.gerIndexWriter();
        try {
        Document document=new Document();
        document.add(new StringField("title","背影", Field.Store.YES));
        document.add(new StringField("author","朱自清",Field.Store.YES));
        document.add(new StringField("content","你站在这里不要动，我去给你买几个橙子",Field.Store.YES));
        document.add(new StringField("id","11",Field.Store.YES));
        indexWriter.addDocument(document);
        LuceneUtil.commit(indexWriter);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void select(){
        IndexSearcher indexSearcher=LuceneUtil.gerIndexSearcher();
        Query query=new TermQuery(new Term("content","橙"));
        try{
            TopDocs search = indexSearcher.search(query, 10);
            ScoreDoc[] scoreDocs = search.scoreDocs;
            for(int i=0;i<scoreDocs.length;i++){
                ScoreDoc scoreDoc = scoreDocs[i];
                int doc = scoreDoc.doc;
                Document document = indexSearcher.doc(doc);
                System.out.println(scoreDoc.score);
                System.out.println("编号"+document.get("id"));
                System.out.println("标题"+document.get("title"));
                System.out.println("作者"+document.get("author"));
                System.out.println("内容"+document.get("content"));
                System.out.println();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
