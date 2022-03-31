package com.vince;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.util.Arrays;
import java.util.Date;

/**
 * File���ʹ��
 * @author HP
 *
 */

public class FileDemo {

	public static void main(String[] args) {
		// File���ʾһ���ļ���Ŀ¼
		// "C:\\test\\vince.txt"
		// "C:/test/vince.txt"
		File f1 = new File("c:"+File.separator+"test"+File.separator+"vince.txt");
		if(!f1.exists()) {//�ж��ļ��Ƿ����
			try {
				f1.createNewFile();// �����ļ�
				System.out.println("�ļ������ɹ�");
			} catch (IOException e) {
				e.printStackTrace();
			}
			// f1.isFile() : �Ƿ�Ϊ�ļ�
			System.out.println(f1.isDirectory());
			
			File f2 = new File("c:\\test\\my");
			boolean b = f2.delete();
			System.out.println(b);
			
			String[] names = f2.list(); // �г���ǰĿ¼�µ������ļ���
			System.out.println(Arrays.toString(names));
			
			File[] fs = f2.listFiles(); // �г���ǰĿ¼�µ������ļ�����file���󷵻�
			
			for(File f: fs) {
				System.out.println("length="+f.length());
				System.out.println("name="+f.getName());
				System.out.println("���·��="+f.getPath());
				System.out.println("����·��="+f.getAbsolutePath());
				System.out.println("�Ƿ�Ϊ�����ļ�="+f.isHidden());
				System.out.println("�Ƿ�ɶ��ļ�="+f.canRead());
				Date date = new Date(f.lastModified());
				DateFormat df = new simpleDateFormat("HH:mm:ss");
				System.out.println("�ļ�����޸ĵ�ʱ��="+df.format(date));
				System.out.println("--------");
				
				// ���·�������·��������
				File f3 = new File("temp.txt");
				System.out.println(f3.getPath());
				System.out.println(f3.getAbsolutePath());
			
				// 
				File f4 = new File("c:\\test\\dabin1");
				f4.mkdirs();
				// ���������ƶ��ļ�
				// f4.renameTo(new File("c:\\test\\dabin1");
				f4.renameTo((new File("c:\\dabin1")));
				
				File f5 = new File("c:\\test\\my");
//				File [] files = f5.listFiles(new FileFilter() {
//					
//					@Override
//					public boolean accept(File pathname) {
//						return pathname.getName().endsWith(".txt");
//					}
//				});
				File[] files = f5.listFiles((pathname)->pathname.getName().endsWith(".txt"));
				System.out.println("---------");
				for(File f11: files) {
					System.out.println(f11.getName());
				}
				
			}
			
		}
	}

}
