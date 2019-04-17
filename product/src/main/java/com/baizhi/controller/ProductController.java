package com.baizhi.controller;

import com.baizhi.entity.Product;
import com.baizhi.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("product")
public class ProductController {
    @Resource
    private ProductService productService;

    @RequestMapping("queryAll")
    public String queryAll(String content, HttpSession session){
        List<Product> products = productService.queryAll(content);
        session.setAttribute("products",products);
        return "index";
    }
    @RequestMapping("add")
    public void add(Product product){
        productService.register(product);
    }

}
