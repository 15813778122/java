package com.vince;

/**
 * 
 * 
 * @author HP
 * StringBuffer���ֵ�StringBuilder��
 * һ���ɱ���ַ����У������ṩһ����StringBuffer���ݵ�API��������֤ͬ�������౻�������StringBuffer��
 * �����滻�������ַ����������������߳�ʹ�õ�ʱ��(����������ձ�)��������ԣ��������Ȳ��ø��࣬��Ϊ�ڴ����
 * ʵ���У�����StringBufferҪ��
 */

public class StringBuilderDemo {

	public static void main(String[] args) {
		// StringBuffer��StringBuilder������
		// StringBuffer���̰߳�ȫ�ģ����ܵͣ��ʺ��ڶ��̵߳�ʹ�ã�JDK1.0
		// StringBuilder���̲߳���ȫ�ģ����ܸߣ��ʺ��ڵ��߳���ʹ�ã��������ռ���������jdk1.5�����
		StringBuilder sb = new StringBuilder();
		
		// �ַ�����Ӳ���
		// 1.����������û���������⣬�ڱ������Ż�
		// 2.�����������ӣ�����������������
		
		// String a = 'a'+1;
		// String b = a+'b';
		
		String c = null;
		for(int i = 0;i<5;i++) {
			c+=i; // ÿ��ѭ�������һ��StringBuilder����ʵ��ƴ�ӣ�������ֶ�����StringBuilder��ƴ��
		}
		// 1���ַ�����ӣ��ڱ���󣬻�ʹ��StringBuilder���Ż����룬ʵ��ƴ��
	}

}
