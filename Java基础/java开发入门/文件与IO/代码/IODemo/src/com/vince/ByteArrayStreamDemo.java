package com.vince;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

/**
 * �ֽ�������:
 * �����ڴ�������ڲ�ά����һ���ֽ����飬���ǿ����������Ķ�ȡ�����������ַ���
 * ����ر�
 * @author HP
 *
 */

public class ByteArrayStreamDemo {
	
	private static void byteArray() {
		String s = "12346123987askhnda&*(&@(*&DHSJKAD";
		ByteArrayInputStream bais = new ByteArrayInputStream(s.getBytes());
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		int curr = -1;
		while((curr=bais.read())!=-1) {
			if((curr>=65 && curr<=90) || (curr>=97 && curr<=122)) {
				baos.write(curr);
			}
		}
		// ��ʱ����رգ�ԭ���ֽ��������ǻ����ڴ�Ĳ�����
		System.out.println(baos.toString());
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		byteArray();
	}

}
