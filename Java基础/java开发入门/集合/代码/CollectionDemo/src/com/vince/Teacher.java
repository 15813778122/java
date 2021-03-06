package com.vince;

import java.util.HashSet;

// 一个老师对应多个学生
public class Teacher {
	private String name;
	private int age;
	private String sex;
	private HashSet<Student> student = new HashSet<>();
	
	public HashSet<Student> getStudent() {
		return student;
	}
	public void setStudent(HashSet<Student> student) {
		this.student = student;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	@Override
	public String toString() {
		return "Teacher [name=" + name + ", age=" + age + ", sex=" + sex + "]";
	}
	public Teacher(String name, int age, String sex) {
		super();
		this.name = name;
		this.age = age;
		this.sex = sex;
	}
	public Teacher() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
