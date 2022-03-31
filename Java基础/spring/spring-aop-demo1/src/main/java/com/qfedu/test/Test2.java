package com.qfedu.test;

import com.qfedu.dao.BookDAOImpl;
import com.qfedu.service.BookServiceImpl;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test2 {
    public static void main(String[] args) {

        //通过Spring容器获取BookDAOImpl的对象，并调用方法
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        BookDAOImpl bookDAO = (BookDAOImpl)context.getBean("bookDAO");
        bookDAO.update();

        //如果要使用Spring aop面向切面编程，调用切入点方法的对象必须通过Spring容器获取
        //如果一个类中的方法被声明为切入点之后，通过Spring容器获取该类对象，实则获取到的是一个代理对象
        //如果一个类中的方法没有被声明为切入点，通过Spring容器获取到的就是这个类真实创建的对象
        BookServiceImpl bookService = ((BookServiceImpl) context.getBean("bookServiceImpl"));
        bookService.addBook();
    }
}
