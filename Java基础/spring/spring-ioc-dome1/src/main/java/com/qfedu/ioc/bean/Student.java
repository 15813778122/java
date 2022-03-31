package com.qfedu.ioc.bean;

import java.util.*;

public class Student {
    private String stuNum;
    private String stuName;
    private String stuGender;
    private int stuAge;
    private Date enterenceTime; // 入学日期
    private Clazz clazz;

    private List<String> hobbies;
    private Set<String> sets;
    private Map<String,Object> maps;
    private Properties properties;

    public Student(String stuNum, String stuName, String stuGender, int stuAge, Date enterenceTime, Clazz clazz) {
        this.stuNum = stuNum;
        this.stuName = stuName;
        this.stuGender = stuGender;
        this.stuAge = stuAge;
        this.enterenceTime = enterenceTime;
        this.clazz = clazz;
    }

    public Student(String stuNum) {
        this.stuNum = stuNum;
    }

    @Override
    public String toString() {
        return "Student{" +
                "stuNum='" + stuNum + '\'' +
                ", stuName='" + stuName + '\'' +
                ", stuGender='" + stuGender + '\'' +
                ", stuAge=" + stuAge +
                ", enterenceTime=" + enterenceTime +
                ", clazz=" + clazz +
                '}';
    }
}
