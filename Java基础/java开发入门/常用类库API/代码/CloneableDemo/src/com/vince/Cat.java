package com.vince;

/**
 * 对象需要具备克隆功能:
 * 1.实现Cloneable接口(标记接口)
 * 2.重写Object类中的clone方法
 * @author HP
 *
 */

public class Cat implements Cloneable{
	private String name;
	private int age;
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
	public Cat(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}
	public Cat() {
		super();
		// TODO Auto-generated constructor stub
	}
	// 重写Object中的clone方法
	@Override
	protected Object clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		return super.clone();
	}
	@Override
	public String toString() {
		return "Cat [name=" + name + ", age=" + age + "]";
	}
}
