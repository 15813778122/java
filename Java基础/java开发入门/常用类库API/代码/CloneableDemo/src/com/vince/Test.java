package com.vince;

public class Test {

	public static void main(String[] args) {
		Cat cat = new Cat("С��",2);
		try {
			Cat newCat = (Cat) cat.clone();
			System.out.println("cat="+cat);
			System.out.println("newCat="+newCat);
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
