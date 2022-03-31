package com.qfedu.dao;

import com.qfedu.pojo.Student;

import java.util.List;

public interface StudentDAO {
    //public List<Student> listStudentsByCid(int cid);

    public Student queryStudent(String sid);//queryStudentBySid

    public List<Student> queryStudentByCid(int cid);//queryStudentBySid
}
