package com.baizhi.test;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.TokenStream;
import org.apache.lucene.analysis.cjk.CJKAnalyzer;
import org.apache.lucene.analysis.cn.smart.SmartChineseAnalyzer;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.analysis.tokenattributes.CharTermAttribute;
import org.apache.lucene.util.Version;
import org.wltea.analyzer.lucene.IKAnalyzer;

import java.io.IOException;
import java.io.StringReader;

public class CreateIndex {
    public static void main(String[] args) throws IOException {
      /*  //声明一个文件夹为索引库
        Directory dir = FSDirectory.open(new File("E:/后期项目/lucene/index"));
        //创建标准分词器对象
        Analyzer analyzer=new StandardAnalyzer(Version.LUCENE_44);
        //索引写入器的相关配置
        IndexWriterConfig conf =new  IndexWriterConfig(Version.LUCENE_44, analyzer);
        //参数1：索引的目录  参数2：索引写入器的相关配置
        IndexWriter indexWriter= new IndexWriter(dir,conf);
        for (int i=0;i<=11;i++) {
            Document document=new Document();
            //YES:表示往元数据中存入   No：不存
            document.add(new StringField("title","背影", Field.Store.YES));
            document.add(new StringField("author","朱自清",Field.Store.YES));
            document.add(new StringField("content","你站在这里不要动，我去给你买几个香蕉",Field.Store.YES));
            document.add(new StringField("id",i+"",Field.Store.YES));
            indexWriter.addDocument(document);
        }


        indexWriter.commit();
        indexWriter.close();
        */
      //标准分词器
        test(new StandardAnalyzer(Version.LUCENE_44),"让暴风雨来的更猛烈吧");
        //CJK分词器  二分分词器
        test(new CJKAnalyzer(Version.LUCENE_44),"让暴风雨来的更猛烈吧");
        //智能分词器
        test(new SmartChineseAnalyzer(Version.LUCENE_44),"让暴风雨来的更猛烈吧");
        //IK分词器 可以自定义停用词和关键词  配置文件：IKAnalyzer.cfg.xml  ext.dic    stopword.dic
        test(new IKAnalyzer(),"让暴风雨来的更猛烈吧");
    }
    public static void  test(Analyzer analyzer,String text) throws IOException{

        System.out.println("当前分词器:--->"+analyzer.getClass().getName());

        TokenStream tokenStream = analyzer.tokenStream("content", new StringReader(text));

        tokenStream.addAttribute(CharTermAttribute.class);

        tokenStream.reset();
        while(tokenStream.incrementToken()){
            CharTermAttribute attribute = tokenStream.getAttribute(CharTermAttribute.class);
            System.out.println(attribute.toString());
        }

        tokenStream.end();
    }
}
