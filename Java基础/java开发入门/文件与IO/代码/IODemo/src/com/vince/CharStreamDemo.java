package com.vince;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;

/**
 * �ַ���
 * �ַ������: Writer,���ļ��Ĳ���ʹ������:FileWriter
 * �ַ������:Reader,���ļ��Ĳ���ʹ������:FileReader
 * ÿ�β����ĵ�λ��һ���ַ�
 * �ļ��ַ����������Դ����棬Ĭ�ϴ�СΪ1024�ַ����ڻ������󣬻��ֶ�ˢ�»��棬��ر���ʱ�������д���ļ�
 * 
 * ���ѡ��ʹ���ֽ��������ַ���
 * һ��������ı��ļ�ʱ��ʹ���ֽ����������ı��ļ�ʱ�𣬽���ʹ���ַ���
 * 
 * �ַ������ڲ�ʵ�ֻ����ֽ���
 * @author HP
 *
 */

public class CharStreamDemo {

	private static void in() {
		File file = new File("c:\\\\test\\\\vince.txt");
		try {
			Reader in = new FileReader(file);
			char[] cs = new char[1];
			int len = -1;
			StringBuilder buf = new StringBuilder();
			while((len = in.read(cs))!=-1) {
				buf.append(new String(cs,0,len));
			}
			in.close();
			System.out.println(buf);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private static void out() {
		File file = new File("c:\\test\\vince.txt");
		try {
			Writer out = new FileWriter(file,true);
			out.write("xxx");
			out.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		out();
	}

}
