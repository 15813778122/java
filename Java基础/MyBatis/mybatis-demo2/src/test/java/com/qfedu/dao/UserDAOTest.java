package com.qfedu.dao;

import com.qfedu.pojo.Detail;
import com.qfedu.pojo.User;
import com.qfedu.utils.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

public class UserDAOTest {

    @Test
    public void testInsertUser() {
        //用户注册，提交了基本信息喝详情到Servlet,Servlet接受注册信息封装到User和Detail对象中
        User user = new User(0,"wangwu","123123","王五","2.jpg",null);
        Detail detail = new Detail(0,"湖北省宜宾市","1231321313","耶耶耶",0);

        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        try {
            UserDAO userDAO = sqlSession.getMapper(UserDAO.class);
            int i = userDAO.insertUser(user);
            detail.setUserId(user.getUserId());
            System.out.println(i);

            DetailDAO detailDAO = sqlSession.getMapper(DetailDAO.class);
            int j = detailDAO.insertDetail(detail);
            System.out.println(j);

            sqlSession.commit();
        } catch (Exception e){
            e.printStackTrace();
            sqlSession.rollback();
        }
    }

    @Test
    public void testQueryUser(){
        UserDAO userDAO = MyBatisUtil.getMapper(UserDAO.class);
        User lisi = userDAO.queryUser("lisi");
        System.out.println(lisi);
    }
}