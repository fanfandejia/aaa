package com.baizhi.lucenedaoimpl;

import com.baizhi.entity.Product;
import com.baizhi.lucenedao.LuceneDAO;
import com.baizhi.util.LuceneUtil;
import org.apache.lucene.document.*;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.Term;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.TermQuery;
import org.apache.lucene.search.TopDocs;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
//表示把当前类的对象交给工厂
@Component
public class LuceneDAOImpl implements LuceneDAO {
    @Override
    public List<Product> queryAll(String centent) {
        ArrayList<Product> list = new ArrayList<>();
        IndexSearcher indexSearcher = LuceneUtil.gerIndexSearcher();
        try {
            TopDocs topDocs = indexSearcher.search(new TermQuery(new Term("name",centent)), 20);
            ScoreDoc[] scoreDocs = topDocs.scoreDocs;
            for (int i = 0; i < scoreDocs.length; i++) {
                ScoreDoc scoreDoc = scoreDocs[i];
                int doc = scoreDoc.doc;
                Document doc1 = indexSearcher.doc(doc);
                Product product=new Product();
                product.setId(Integer.parseInt(doc1.get("id")));
                product.setName(doc1.get("name"));
                product.setContent(doc1.get("content"));
                product.setCity(doc1.get("city"));
                product.setImgpath(doc1.get("imgpath"));
                product.setPrice(Double.parseDouble(doc1.get("price")));
                product.setUptime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(doc1.get("uptime")));
                list.add(product);
            }
        }catch (IOException e){
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public void register(Product product) {
        IndexWriter indexWriter = LuceneUtil.gerIndexWriter();
        Document document = new Document();
        document.add(new IntField("id",product.getId(), Field.Store.YES));
        document.add(new DoubleField("price",product.getPrice(), Field.Store.YES));
        document.add(new TextField("name",product.getName(), Field.Store.YES));
        document.add(new TextField("content",product.getContent(), Field.Store.YES));
        document.add(new TextField("city",product.getCity(), Field.Store.YES));
        document.add(new StringField("imgpath",product.getImgpath(), Field.Store.YES));
        try {
            indexWriter.addDocument(document);
            LuceneUtil.commit(indexWriter);
        } catch (IOException e) {
            LuceneUtil.rollback(indexWriter);
            e.printStackTrace();
        }
    }
}
