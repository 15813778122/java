package com.qfedu.dao;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.qfedu.pojo.Student;
import com.qfedu.utils.MyBatisUtils;
import com.sun.deploy.model.Resource;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import static org.junit.Assert.*;

public class StudentDAOTest {

    @Test
    public void insertStudent() {
        //会话（连接）
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        //1.当我们获取sqlSession对象时，就默认开启了事务
        try {
            //通过会话获取DAO对象
            StudentDAO studentDAO = sqlSession.getMapper(StudentDAO.class);
            Student student = new Student(0, "10005", "姊姊", "女", 23);
            //测试StudentDAO中的方法
            int i = studentDAO.insertStudent(student);
            //2.操作完成并成功之后，需要手动提交
            //sqlSession.commit();
            System.out.println(student);
            System.out.println(i);
        } catch (Exception e){
            // 3.当操作出现异常，调用rollback进行回滚
            sqlSession.rollback();
        }
    }

    @Test
    public void testDeleteStudent(){

        try {
            InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
            // SqlSessionFactoryBuilder
            SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
            // SqlSessionFactory表示MyBatis的会话工厂
            SqlSessionFactory factory = builder.build(is);
            // SqlSession代表了MyBatis和数据库之间的连接(对话)：通过工厂方法按设计模式
            SqlSession sqlSession = factory.openSession();
            // 当我们创建了连接就可以得到我们的mapper对象，getMapper可以得到所以DAO的对象
            // 通过SqlSession对象调用getMapper方法获取DAO接口对象
            // 虚拟类只是实现了studentDAO的接口，并不是studentDAO的对象
            //其实虚拟类是一个通过代理产生的一个代理对象，是动态代理产生的，mybatis动态创建了StudentDAO的实现类叫MapperProxy
            StudentDAO studentDAO = sqlSession.getMapper(StudentDAO.class);
            // 调用被测试方法
            int i = studentDAO.deleteStudent("10001");
            // 提交事务
            sqlSession.commit();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testUpdateStudent(){
        StudentDAO studentDAO = MyBatisUtils.getMapper(StudentDAO.class);
        int i = studentDAO.updateStudent(new Student(0, "10001", "李四", "女", 18));
    }

    @Test
    public void testListStudent(){
        try {
            InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
            SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
            SqlSessionFactory factory = builder.build(is);
            SqlSession sqlSession = factory.openSession();
            StudentDAO studentDAO = sqlSession.getMapper(StudentDAO.class);
            List<Student> students = studentDAO.listStudent();
            for (Student s:students){
                System.out.println(s);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Test
    public void testQueryStudent(){
        StudentDAO studentDAO = MyBatisUtils.getMapper(StudentDAO.class);
        Student student = studentDAO.queryStudent("10002");
        System.out.println(student);
    }

//    @Test
//    public void testListStudentByPage(){
//        try {
//            InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
//            SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
//            SqlSessionFactory factory = builder.build(is);
//            SqlSession sqlSession = factory.openSession();
//            StudentDAO studentDAO = sqlSession.getMapper(StudentDAO.class);
//            List<Student> students = studentDAO.listStudentByPage(0, 2);
//            for (Student s:students){
//                System.out.println(s);
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }

    @Test
    public void testListStudentByPage1(){
        StudentDAO studentDAO = MyBatisUtils.getMapper(StudentDAO.class);
        PageHelper.startPage(1,4);
        //List<Student> students = studentDAO.listStudent();
        List<Student> students = studentDAO.listStudentByPage("女");
        PageInfo<Student> pageInfo = new PageInfo<>(students);
        // PageInfo中就包含了数据及分页信息
        List<Student> list = pageInfo.getList();
        for (Student s:list){
            System.out.println(s);
        }
    }

//    @Test
//    public void testGetCount(){
//        try {
//            InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
//            SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
//            SqlSessionFactory factory = builder.build(is);
//            SqlSession sqlSession = factory.openSession();
//            StudentDAO studentDAO = sqlSession.getMapper(StudentDAO.class);
//            int count = studentDAO.getCount();
//            System.out.println(count);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//    }
}