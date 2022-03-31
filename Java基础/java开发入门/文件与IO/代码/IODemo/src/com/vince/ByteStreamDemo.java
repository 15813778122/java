package com.vince;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * �ֽ����������
 * �����:����OutputStream,���ļ��������ʹ������FileOutputStream
 * ������:����InputStream,���ļ���������ʹ������FileInputStream
 * 
 * ��������ֽ�������ԭ��ÿ��ֻ�����һ���ֽ�(���ļ��ж�ȡ��д��)
 * @author HP
 *
 */

public class ByteStreamDemo {
	
	public static void in() {
		// 0.ȷ��Ŀ���ļ�
		File file = new File("c:\\test\\vince.txt");
		// 1.����һ���ļ�����������
		try {
			InputStream in = new FileInputStream(file);
			
			byte[] bytes = new byte[1024];
			StringBuilder buf = new StringBuilder();
			int len = -1; // ��ʾÿ�ζ�ȡ���ֽڳ���
			// �����ݶ��뵽�����У������ص��ֽ�������������-1ʱ����ʾ��ȡ�����ݣ�����-1��ʾ�ļ��Ѿ�����
			while((len = in.read(bytes))!=-1) {
				// ���ݶ�ȡ�����ֽ����飬��ת��Ϊ�ַ������ݣ���ӵ�StringBuilder��
				// 0������ʼλ�ã�len����ǰѭ����ȡ�����ֽ���
				buf.append(new String(bytes,0,len));
			}
			System.out.println(buf);
			//�ر�������
			in.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public static void out() {
		// 0.ȷ��Ŀ���ļ�
		File file = new File("c:\\test\\vince.txt");
		// 1.����һ���ļ����������
		try {
			OutputStream out = new FileOutputStream(file);
			// 2.���������
			String info = "�����ͷ\r\n"; // \r\n��ʾ����
			
			// String line = System.getProperty("line.separator"); // ��ȡ���з�
			//String info = "�����ͷ"+line; // \r\n��ʾ����
			// 3.������д�뵽�ļ�
			out.write(info.getBytes());
			// 4.�ر���
			out.close();
			System.out.println("write success");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		out();
		in();
	}

}
