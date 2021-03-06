package com.vince;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.SequenceInputStream;
import java.util.Enumeration;
import java.util.Vector;

/**
 * 文件分割合并示例
 * @author HP
 *
 * DataInputStream:
 * 数据输入流允许应用程序以与机器无关方式从底层输入流中读取基本Java数据类型，应用程序可以使用数据输出流写入稍后与数据输入流读取的数据。
 * DataOutputStream:
 * 数据输出流允许应用程序以适当方式将基本Java数据类型写入输出流中。然后应用程序可以使用输入流将数据读入。
 */

public class FileDivisionMergeDemo {
	
	/**
	 * 文件的分割
	 * @param args
	 */
	private static void division(File targetFile, long cutSize) {
		if(targetFile == null) return;
		//计算总分割的文件数
		int num = targetFile.length()%cutSize==0?
				(int)(targetFile.length()/cutSize):(int)(targetFile.length()/cutSize+1);
		try {
			BufferedInputStream in = new BufferedInputStream(new FileInputStream(targetFile));
			BufferedOutputStream out = null;
			
			byte[] bytes = null;// 每次要读取的字节数
			int len = -1; // 每次实际读取的长度
			int count = 0;// 每一个文件要读取的次数
			
			// 循环次数为生成文件的个数
			for(int i = 0;i<num;i++) {
				out = new BufferedOutputStream(
						new FileOutputStream(new File("c:\\test"+(i-1)+"-temp-"+targetFile.getName())));
				if(cutSize<=1024) {
					bytes = new byte[(int)cutSize];
					count = 1;
				} else {
					bytes = new byte[1024];
					count = (int)cutSize/1024;
				}
				while(count > 0 && (len=in.read(bytes))!=-1) {
					out.write(bytes,0,len);
					out.flush();
					count--;
				}
				// 计算每个文件大小除于1024的余数，决定是否要再读取一次
				if(cutSize%1024!=0) {
					bytes = new byte[(int)cutSize%1024];
					len = in.read(bytes);
					out.write(bytes,0,len);
					out.flush();
					out.close();
				}
			}
			in.close();
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	/**
	 * 文件合并
	 * @param args
	 */
	private static void merge(Enumeration<InputStream> es) {
		// 构造一个合并流
		SequenceInputStream sis = new SequenceInputStream(es);
		try {
			BufferedOutputStream bos = new BufferedOutputStream(
					new FileOutputStream("c:\\test\\xxx"));
			byte[] bytes = new byte[1024];
			int len = -1;
			while((len=sis.read(bytes))!=-1) {
				bos.write(bytes,0,len);
				bos.flush();
			}
			bos.close();
			sis.close();
			System.out.println("合并完成");
 		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
//		File file = new File("c:\\text\\vince.txt");
//		division(file, 1024*1024*20);
		
		try {
			InputStream in1 = new FileInputStream(new File("c:\\test\\1\\xxx"));
			InputStream in2 = new FileInputStream(new File("c:\\test\\2\\xxx"));
			InputStream in3 = new FileInputStream(new File("c:\\test\\3\\xxx"));
			InputStream in4 = new FileInputStream(new File("c:\\test\\4\\xxx"));
			InputStream in5 = new FileInputStream(new File("c:\\test\\5\\xxx"));
			
			// 集合工具类，内部实现了数组
			Vector<InputStream> v = new Vector<InputStream>();
			v.add(in1);
			v.add(in2);
			v.add(in3);
			v.add(in4);
			v.add(in5);
			
			Enumeration<InputStream> es = v.elements();
			merge(es);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
