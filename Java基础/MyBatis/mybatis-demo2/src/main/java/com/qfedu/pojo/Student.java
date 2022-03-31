package com.qfedu.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Student {
    private String stuId;//学号
    private String stuName;
    private int stuAge;
//    private int stuCid;//学生所在班级的id
//    private Clazz clazz; // 学生所在的班级
//    private List<Course> course;// 学生选择的课程
}
