package com.vince;

public class OneToManyDemo {

	public static void main(String[] args) {
		Teacher t1 = new Teacher("����ʦ",18,"Ů");
		Student s1 = new Student("С��",10);
		Student s2 = new Student("С��",11);
		Student s3 = new Student("С��",9);
		
		t1.getStudent().add(s1);
		t1.getStudent().add(s2);
		t1.getStudent().add(s3);
		
		s1.setTeacher(t1);
		s2.setTeacher(t1);
		s3.setTeacher(t1);
		
		print(t1);
	}

	private static void print(Teacher t1) {
		System.out.println(t1.getName());
		for(Student s: t1.getStudent()) {
			System.out.println(s);
		}
	}

}
