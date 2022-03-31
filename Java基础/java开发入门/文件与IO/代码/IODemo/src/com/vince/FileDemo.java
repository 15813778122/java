package com.vince;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.util.Arrays;
import java.util.Date;

/**
 * File类的使用
 * @author HP
 *
 */

public class FileDemo {

	public static void main(String[] args) {
		// File类表示一个文件或目录
		// "C:\\test\\vince.txt"
		// "C:/test/vince.txt"
		File f1 = new File("c:"+File.separator+"test"+File.separator+"vince.txt");
		if(!f1.exists()) {//判断文件是否存在
			try {
				f1.createNewFile();// 创建文件
				System.out.println("文件创建成功");
			} catch (IOException e) {
				e.printStackTrace();
			}
			// f1.isFile() : 是否为文件
			System.out.println(f1.isDirectory());
			
			File f2 = new File("c:\\test\\my");
			boolean b = f2.delete();
			System.out.println(b);
			
			String[] names = f2.list(); // 列出当前目录下的所以文件名
			System.out.println(Arrays.toString(names));
			
			File[] fs = f2.listFiles(); // 列出当前目录下的所有文件，以file对象返回
			
			for(File f: fs) {
				System.out.println("length="+f.length());
				System.out.println("name="+f.getName());
				System.out.println("相对路径="+f.getPath());
				System.out.println("绝对路径="+f.getAbsolutePath());
				System.out.println("是否为隐藏文件="+f.isHidden());
				System.out.println("是否可读文件="+f.canRead());
				Date date = new Date(f.lastModified());
				DateFormat df = new simpleDateFormat("HH:mm:ss");
				System.out.println("文件最后修改的时间="+df.format(date));
				System.out.println("--------");
				
				// 相对路径与绝对路径的区别
				File f3 = new File("temp.txt");
				System.out.println(f3.getPath());
				System.out.println(f3.getAbsolutePath());
			
				// 
				File f4 = new File("c:\\test\\dabin1");
				f4.mkdirs();
				// 重命名与移动文件
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
