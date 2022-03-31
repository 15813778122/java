package com.qfedu.dao;

import com.qfedu.pojo.User;
import com.qfedu.service.impl.UserServiceImpl;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

import static org.junit.Assert.*;

public class UserDAOTest {

    @org.junit.Test
    public void queryUsers() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
//        UserDAO userDAO = (UserDAO) context.getBean("userDAO");
//        List<User> users = userDAO.queryUsers();
//        System.out.println(users);
        UserServiceImpl userService = (UserServiceImpl) context.getBean("userServiceImpl");
        List<User> users = userService.listUsers();
        System.out.println(users);
    }
}