package com.vince;

public class Dog implements Comparable<Dog>{
	private String name;
	private int age;
	private int id;
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
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	@Override
	public String toString() {
		return "Dog [name=" + name + ", age=" + age + ", id=" + id + "]";
	}
	public Dog(String name, int age, int id) {
		super();
		this.name = name;
		this.age = age;
		this.id = id;
	}
	public Dog() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public int compareTo(Dog o) {
		// TODO Auto-generated method stub
		return this.id-o.id;
	}
	
}
