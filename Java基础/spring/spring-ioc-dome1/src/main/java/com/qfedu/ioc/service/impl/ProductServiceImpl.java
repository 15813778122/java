package com.qfedu.ioc.service.impl;

import com.qfedu.ioc.service.ProductService;

public class ProductServiceImpl implements ProductService {

    @Override
    public void listProduct() {
        System.out.println("-----------热销商品");
    }
}
