package com.qfedu.ioc.service.impl;

import com.qfedu.ioc.service.ProductService;

public class ProductServiceImpl2 implements ProductService {

    @Override
    public void listProduct() {
        System.out.println("-----------高端商品");
    }
}
