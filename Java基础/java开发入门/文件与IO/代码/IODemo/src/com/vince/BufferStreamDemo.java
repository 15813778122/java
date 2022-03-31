package com.vince;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.io.Writer;

/**
 * BufferedInputStream:Ϊ��һ�����������һЩ���ܣ��ڴ���BufferedInputStreamʱ���ᴴ��һ���ڲ����������飬���ڻ������ݡ�
 * BufferedOutputStream:ͨ�����������������Ӧ�ó���Ϳ��Խ������ֽ�д��Ͳ�������У����������ÿ���ֽ�д����õײ�ϵͳ
 * 
 * �����Ŀ�ģ�
 * �����д���ļ�����ʱ��Ƶ���Ĳ����ļ������������ܽ��͵����⣬
 * BufferedOutputStream �ڲ�Ĭ�ϵĻ����С��8KB��ÿ��д��ʱ�洢�������е�byte�����У����������ʱ����������е�����д���ļ�
 * ���һ����±����
 * 
 * �ַ���
 * 1.�����ַ�����������ǿ��ȡ����(readLine)
 * 2.����Ч�Ķ�ȡ����
 * FileReader:�ڲ�ʹ��InputStreamReader(sun.nio.cs.StreamDecoder)��������̣�byte->char��Ĭ�ϻ����С��8K
 * BufferedReader��Ĭ�ϻ����С��8K���������ֶ�ָ�������С�������ݼ�Ӷ�ȡ�������У�����ÿ��ת�����̣�Ч�ʸ���
 * BufferedWriter ͬ��
 * @author HP
 *
 */

public class BufferStreamDemo {
	
	private static void charWriter() {
		File file = new File("c:\\test\\vince.txt");
		try {
			Writer writer = new FileWriter(file);
			BufferedWriter bw = new BufferedWriter(writer);
			bw.write("xxxx");
			bw.flush();
			bw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private static void charReader() {
		File file = new File("c:\\test\\vince.txt");
		try {
			Reader reader = new FileReader(file);
			// Ϊ�ַ����ṩ���棬�Դﵽ��Ч��ȡ��Ŀ��
			BufferedReader br = new BufferedReader(reader);
			char[] cs = new char[1024];
			int len = -1;
			while((len=br.read(cs))!=-1) {
				System.out.println(new String(cs,0,len));
			}
			br.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private static void byteReader2() {
		File file = new File("c:\\test\\vince.txt");
		// try����д�����������close��BufferedInputStream��ǰ���Ǵ������̳�close
		try(BufferedInputStream bis = new BufferedInputStream(new FileInputStream(file))) {
			byte[] bytes = new byte[1024];
			int len = -1;
			while((len=bis.read(bytes))!=-1) {
				System.out.println(new String(bytes,0,len));
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static void byteReader() {
		File file = new File("c:\\test\\vince.txt");
		try {
			InputStream in = new FileInputStream(file);
			// ����һ���ֽڻ�����
			BufferedInputStream bis = new BufferedInputStream(in);
			
			byte[] bytes = new byte[1024];
			int len = -1;
			while((len=bis.read(bytes))!=-1) {
				System.out.println(new String(bytes,0,len));
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private static void byteWriter() {
		File file = new File("c:\\test\\vince.txt");
		try {
			OutputStream out = new FileOutputStream(file);
			// ����һ���ֽڻ�����
			BufferedOutputStream bos = new BufferedOutputStream(out);
			String info = "xxxx";
			bos.write(info.getBytes());
			bos.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		byteWriter();
		byteReader();
	}

}
