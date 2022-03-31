package com.qfedu.ioc.servlet;

import com.qfedu.ioc.service.ProductService;
import com.qfedu.ioc.service.impl.ProductServiceImpl;

public class TestServlet {
    ProductService productService;

    public void setProductService(ProductService productService) {
        this.productService = productService;
    }

    public void doGet(){
        doPost();
    }
    public void doPost(){
        productService.listProduct();
    }
}
