package com.vince;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * 数据流
 * 与机器无关的操作Java的基本数据类型
 * @author HP
 *
 */

public class DateStreamDemo {

	private static void read() {
		File file = new File("c:\\test\\vince.dat");
		try {
			InputStream in = new FileInputStream(file);
			BufferedInputStream bis = new BufferedInputStream(in);
			DataInputStream dis = new DataInputStream(bis); // 用于网络传输会比较好
			int num = dis.readInt();
			byte b = dis.readByte();
			String s = dis.readUTF();
			System.out.println(num+","+b+","+s);
			dis.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	private static void write() {
		File file = new File("c:\\test\\vince.dat");
		try {
			OutputStream out = new FileOutputStream(file);
			BufferedOutputStream bos = new BufferedOutputStream(out);
			DataOutputStream dos = new DataOutputStream(bos);
			dos.writeInt(10);// 写入4个字节
			dos.writeByte(1); // 写入1个字节
			dos.writeUTF("中"); // 写入5个字节
			dos.close();
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

	}

}
