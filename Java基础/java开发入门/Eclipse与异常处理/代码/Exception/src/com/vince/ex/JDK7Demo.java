package com.vince.ex;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class JDK7Demo {

	public static void main(String[] args) {
		// 1.5֮��
		// Scanner input = new Scanner(System.in);
		// 1.5֮ǰ���ܿ���̨����(ֱ��ʹ��IO��)
		
		// BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// String info = br.readLine();
		// br.close();
		
		// 1.7������
		// �Զ��ر���
		try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
			System.out.println("����������:");
			String info = br.readLine();
			int num = Integer.parseInt(info);
			System.out.println(info);
			// br.close();
		} catch (IOException|NumberFormatException e) {
			e.printStackTrace();
		}
	}

}
