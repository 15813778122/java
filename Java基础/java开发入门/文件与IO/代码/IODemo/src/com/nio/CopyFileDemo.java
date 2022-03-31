package com.nio;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class CopyFileDemo {

	/**
	 * ͨ���ļ�ͨ��ʵ���ļ��ĸ���
	 * @throws Exception
	 */
	private static void copyFile() throws Exception {
		//����һ�������ļ���ͨ��
		FileChannel fcIn = new FileInputStream("c:\\xxx.jpg").getChannel();
		// ����һ������ļ���ͨ��
		FileChannel fcOut = new FileOutputStream("c:\\test\\xxx.jpg").getChannel();
		
		ByteBuffer buf = ByteBuffer.allocate(1024);
		while(fcIn.read(buf)!=-1) {
			buf.flip();
			fcOut.write(buf);
			buf.clear();
		}
		fcIn.close();
		fcIn.close();
		System.out.println("copy success.");
	}
	
	public static void main(String[] args) {
		try {
			copyFile();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
