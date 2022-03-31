package com.vince;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class SystemRuntimeDemo {

	public static void main(String[] args) {
		System.out.println("�����̨���");
		System.err.println("������");
		
		int[] num1 = {1,2,3,4,5,6,7,8};
		int[] num2 = new int[num1.length];
		// native��ʾ��c��c++�ṩ��java���ṩ
		// ����(Դ���飬Դ�������ʼλ�ã�Ŀ�����飬Ŀ���������ʼλ�ã�����)
		System.arraycopy(num1, 0, num2, 0, num1.length);
		System.out.println(Arrays.toString(num2));
		
		System.out.println(System.currentTimeMillis());
		Date nowDate = new Date(System.currentTimeMillis());
		DateFormat df = new SimpleDateFormat("HH:mm:ss");
		String now = df.format(nowDate);
		System.out.println(now);
		// �˳�JVM
		// System.exit(0);
		
		System.out.println(System.getProperty("java.version")); // java����ʱ�����汾
		System.out.println(System.getProperty("java.home")); // java��װĿ¼
		System.out.println(System.getProperty("os.name")); // ����ϵͳ������
		System.out.println(System.getProperty("os.version")); // ����ϵͳ�İ汾
		System.out.println(System.getProperty("user.name")); // �û����˻�����
		System.out.println(System.getProperty("user.home")); // �û�����Ŀ¼
		System.out.println(System.getProperty("user.dir")); // �û��ĵ�ǰ����Ŀ¼
	
		Runtime rt = Runtime.getRuntime();
		System.out.println("����������:"+rt.availableProcessors()+"��");
		System.out.println("JVM���ڴ���:"+rt.totalMemory()+"byte");
		System.out.println("JVM�����ڴ���:"+rt.freeMemory()+"byte");
		System.out.println("JVM��������ڴ���:"+rt.maxMemory()+"byte");
	
		// �ڵ����Ľ�����ִ��ָ�����ַ�������
		try {
			rt.exec("notepad"); // �򿪼��±�
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// ����C��C++��д�����
		// System.loadLibrary(libname);
	}

}
