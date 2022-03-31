package com.vince;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * 字节输出输入流
 * 输出流:超类OutputStream,对文件的输出流使用子类FileOutputStream
 * 输入流:超类InputStream,对文件的输入流使用子类FileInputStream
 * 
 * 输入输出字节流操作原理，每次只会操作一个字节(从文件中读取或写入)
 * @author HP
 *
 */

public class ByteStreamDemo {
	
	public static void in() {
		// 0.确认目标文件
		File file = new File("c:\\test\\vince.txt");
		// 1.构建一个文件输入流对象
		try {
			InputStream in = new FileInputStream(file);
			
			byte[] bytes = new byte[1024];
			StringBuilder buf = new StringBuilder();
			int len = -1; // 表示每次读取的字节长度
			// 把数据读入到数组中，并返回的字节数，当不等于-1时，表示读取到数据，等于-1表示文件已经读完
			while((len = in.read(bytes))!=-1) {
				// 根据读取到的字节数组，再转换为字符串内容，添加到StringBuilder中
				// 0代表起始位置，len代表当前循环获取到的字节数
				buf.append(new String(bytes,0,len));
			}
			System.out.println(buf);
			//关闭输入流
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
		// 0.确认目标文件
		File file = new File("c:\\test\\vince.txt");
		// 1.构建一个文件输出流对象
		try {
			OutputStream out = new FileOutputStream(file);
			// 2.输出的内容
			String info = "顶峰寡头\r\n"; // \r\n表示换行
			
			// String line = System.getProperty("line.separator"); // 获取换行符
			//String info = "顶峰寡头"+line; // \r\n表示换行
			// 3.把内容写入到文件
			out.write(info.getBytes());
			// 4.关闭流
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
