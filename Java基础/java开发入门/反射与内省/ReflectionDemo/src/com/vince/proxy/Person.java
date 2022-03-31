package com.vince.proxy;

public class Person implements Subject,Hotel{

    @Override
    public void shopping() {
        System.out.println("付款，买到心仪的商品");
    }

    @Override
    public void reserve() {
        System.out.println("找到心仪的酒店");
    }
}
