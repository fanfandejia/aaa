package com.baizhi.service;

import com.baizhi.entity.Product;

import java.util.List;

public interface ProductService {
    public List<Product> queryAll(String content);
    public void register(Product product);
}
