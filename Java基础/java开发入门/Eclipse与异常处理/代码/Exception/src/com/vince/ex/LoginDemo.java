package com.vince.ex;	

import java.util.Scanner;

public class LoginDemo {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("�������û���");
		String name = input.nextLine();
		System.out.println("����������");
		String pass = input.nextLine();
		
		UserService us = new UserService();
		try {
			User user = us.login(name,pass);
			System.out.println("��¼�ɹ�");
			System.out.println(user);
		} catch (MyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
