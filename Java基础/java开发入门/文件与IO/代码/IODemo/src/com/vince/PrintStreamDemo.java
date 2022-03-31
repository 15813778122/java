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
 * 打印流:很方便的进行输出
 * 
 * 字节打印流
 * 在字节输出时，可以增强输出功能
 * 字符打印流
 * 
 * @author HP
 *
 */

public class PrintStreamDemo {
	
	private static void charPrint() {
		File file = new File("c:\\test\\vince.txt");
		try {
			// 裸的，文件的直接写入
			Writer out = new FileWriter(file);
			// 缓存的目的，增加写入的效率
			BufferedWriter bos = new BufferedWriter(out);
			// 带上打印流的套，帮助我们提高输出的遍历性
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
			// 裸的，文件的直接写入
			OutputStream out = new FileOutputStream(file);
			// 缓存的目的，增加写入的效率
			BufferedOutputStream bos = new BufferedOutputStream(out);
			// 带上打印流的套，帮助我们提高输出的遍历性
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
