package com.qfedu.dao;

import com.qfedu.proxy.GenaralDAO;

//配置aop的时候不能实现接口
public class StudentImpl{

    public void insert() {
        System.out.println("------insert--student");
    }


    public void delete() {
        System.out.println("------delete--student");
    }


    public void update() {
        System.out.println("------update--student");
    }
}
