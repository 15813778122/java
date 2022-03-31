package com.vince;

import java.io.BufferedOutputStream;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.Writer;

/**
 * ��ӡ��:�ܷ���Ľ������
 * 
 * �ֽڴ�ӡ��
 * ���ֽ����ʱ��������ǿ�������
 * �ַ���ӡ��
 * 
 * @author HP
 *
 */

public class PrintStreamDemo {
	
	private static void charPrint() {
		File file = new File("c:\\test\\vince.txt");
		try {
			// ��ģ��ļ���ֱ��д��
			Writer out = new FileWriter(file);
			// �����Ŀ�ģ�����д���Ч��
			BufferedWriter bos = new BufferedWriter(out);
			// ���ϴ�ӡ�����ף����������������ı�����
			PrintWriter ps = new PrintWriter(bos);
			ps.println("xxx");
			ps.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private static void bytePrint() {
		File file = new File("c:\\test\\vince.txt");
		try {
			// ��ģ��ļ���ֱ��д��
			OutputStream out = new FileOutputStream(file);
			// �����Ŀ�ģ�����д���Ч��
			BufferedOutputStream bos = new BufferedOutputStream(out);
			// ���ϴ�ӡ�����ף����������������ı�����
			PrintStream ps = new PrintStream(bos);
			ps.println("xxx");
			ps.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		bytePrint();
		charPrint();
		
	}

}
