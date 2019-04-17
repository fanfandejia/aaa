package com.baizhi.serviceImpl;

import com.baizhi.dao.ProductMapper;
import com.baizhi.entity.Product;
import com.baizhi.lucenedao.LuceneDAO;
import com.baizhi.service.ProductService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.List;

@Service
@Transactional
public class ProductServiceImpl implements ProductService {
    @Resource
    private ProductMapper productMapper;
    @Resource
    private LuceneDAO luceneDAO;

    @Override
    public List<Product> queryAll(String content) {
        List<Product> products = luceneDAO.queryAll(content);
        return products;
    }

    @Override
    public void register(Product product) {
        try {
            luceneDAO.register(product);
            productMapper.insertSelective(product);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
