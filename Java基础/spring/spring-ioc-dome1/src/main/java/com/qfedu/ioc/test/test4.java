package com.qfedu.ioc.test;

import com.qfedu.ioc.servlet.TestServlet;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class test4 {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        TestServlet testServlet = (TestServlet) context.getBean("testServlet");
        testServlet.doGet();

    }
}
