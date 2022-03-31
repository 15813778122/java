package com.qfedu.beans;

import org.springframework.stereotype.Component;

import java.util.Date;

@Component("stu")
public class Student {
    private String stuNum;
    private String stuName;
    private String stuGender;
    private int stuAge;
    private Date entranceTime;

    public void setStuNum(String stuNum) {
        this.stuNum = stuNum;
    }

    public void setStuName(String stuName) {
        this.stuName = stuName;
    }

    public void setStuGender(String stuGender) {
        this.stuGender = stuGender;
    }

    public void setStuAge(int stuAge) {
        this.stuAge = stuAge;
    }

    public void setEntranceTime(Date entranceTime) {
        this.entranceTime = entranceTime;
    }
}
