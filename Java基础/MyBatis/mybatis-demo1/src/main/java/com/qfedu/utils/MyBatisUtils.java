package com.qfedu.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class MyBatisUtils {

    private static SqlSessionFactory factory;
    private static final ThreadLocal<SqlSession> local = new ThreadLocal<>();

    static {
        try {
            //加载mybatis配置文件，用流的方式读取
            // 加载主配置文件 mybatis-config.xml
            InputStream in = Resources.getResourceAsStream("mybatis-config.xml");
            SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
            //会话工厂
            factory = builder.build(in);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static SqlSessionFactory getFactory(){
        return factory;
    }

    private static SqlSession getSqlSession(boolean isAutoCommit){
        SqlSession sqlSession = local.get();
        if(sqlSession == null) {
            //通过SqlSessionFactory调用openSession方法获取SqlSession对象时，可以通过参数设置事务是否自动提交
            //如果参数设置为true，表示自动提交事务，factory.openSession(true);
            //如果参数设置为false，或者不设置参数，表示手动提交:factory.openSession(); || actory.openSession(false);
            sqlSession = factory.openSession(isAutoCommit);
            local.set(sqlSession);
        }
        return sqlSession;
    }

    //手动事务管理
    public static SqlSession getSqlSession(){
        return getSqlSession(false);
    }

    //自动事务提交
    public static <T extends Object>T getMapper(Class<T> c){
        SqlSession sqlSession = getSqlSession(true);
        return sqlSession.getMapper(c);
    }
}
