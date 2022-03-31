package com.qfedu.test;

import com.qfedu.dao.BookDAOImpl;
import com.qfedu.proxy.GenaralDAO;
import com.qfedu.proxy.JDKDynamicProxy;
import com.qfedu.dao.StudentImpl;

public class TestMyStaticProxy {
    public static void main(String[] args) {
        //创建被代理对象
        BookDAOImpl bookDAO = new BookDAOImpl();
        StudentImpl studentDAO = new StudentImpl();

        //创建动态代理类对象，并将被代理对象传递到代理类中赋值给obj
        JDKDynamicProxy jdkDynamicProxy = new JDKDynamicProxy(bookDAO);

        //proxy就是产生的代理对象：产生的代理对象可以强转成被代理对象实现的接口类型
        GenaralDAO proxy = (GenaralDAO) jdkDynamicProxy.getProxy();

        //使用代理对象调用方法，并不会执行调用的方法，而且进入到创建代理对象时指定的InvocationHandle类中的invoke方法
        //调用的方法作为一个Method参数，传递给了invoke方法
        proxy.insert();
    }
}
