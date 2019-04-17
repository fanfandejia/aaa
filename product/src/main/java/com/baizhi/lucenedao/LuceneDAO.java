package com.baizhi.lucenedao;

import com.baizhi.entity.Product;

import java.util.List;

public interface LuceneDAO {
    public List<Product> queryAll(String centent);
    public void register(Product product);
}
