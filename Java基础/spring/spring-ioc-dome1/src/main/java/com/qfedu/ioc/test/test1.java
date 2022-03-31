package com.qfedu.ioc.test;

import com.qfedu.ioc.bean.Student;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class test1 {

    public static void main(String[] args) {
        // 通过Spring容器创建Student对象
        // 1.初始化Spring容器，加载Spring配置文件
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        // 2.通过Spring容器获取Student对象
        Student student2 = (Student) context.getBean("student");

        System.out.println(student2);
    }
}
