package com.vince;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * RandomAccessFile
 * @author HP
 *
 */

public class RandomAccessFileDemo {

	public static void main(String[] args) {
		try {
			// 读取文件
			RandomAccessFile r = new RandomAccessFile("c:\\xxx","r");
			// 写入文件
			RandomAccessFile w = new RandomAccessFile("c:\\test\\xxx","rw");
			
			byte[] bytes = new byte[1024];
			int len = -1;
			while((len=r.read(bytes))!=-1) {
				w.write(bytes,0,len);
			}
			w.close();
			r.close();
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
