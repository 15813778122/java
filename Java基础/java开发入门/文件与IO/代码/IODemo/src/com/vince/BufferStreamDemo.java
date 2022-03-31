package com.vince;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.io.Writer;

/**
 * BufferedInputStream:为另一个输入流添加一些功能，在创建BufferedInputStream时，会创建一个内部缓冲区数组，用于缓存数据。
 * BufferedOutputStream:通过设置这种输出流，应用程序就可以将各个字节写入低层输出流中，而不必针对每次字节写入调用底层系统
 * 
 * 缓存的目的：
 * 解决在写入文件操作时，频繁的操作文件所带来的性能降低的问题，
 * BufferedOutputStream 内部默认的缓存大小是8KB，每次写入时存储到缓存中的byte数组中，当数组存满时，会把数组中的数据写入文件
 * 并且缓存下标归零
 * 
 * 字符流
 * 1.加入字符缓存流，增强读取功能(readLine)
 * 2.更高效的读取数据
 * FileReader:内部使用InputStreamReader(sun.nio.cs.StreamDecoder)，解码过程，byte->char，默认缓存大小是8K
 * BufferedReader：默认缓存大小是8K，但可以手动指定缓存大小，把数据间接读取到缓存中，减少每次转换过程，效率更高
 * BufferedWriter 同上
 * @author HP
 *
 */

public class BufferStreamDemo {
	
	private static void charWriter() {
		File file = new File("c:\\test\\vince.txt");
		try {
			Writer writer = new FileWriter(file);
			BufferedWriter bw = new BufferedWriter(writer);
			bw.write("xxxx");
			bw.flush();
			bw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private static void charReader() {
		File file = new File("c:\\test\\vince.txt");
		try {
			Reader reader = new FileReader(file);
			// 为字符流提供缓存，以达到高效读取的目的
			BufferedReader br = new BufferedReader(reader);
			char[] cs = new char[1024];
			int len = -1;
			while((len=br.read(cs))!=-1) {
				System.out.println(new String(cs,0,len));
			}
			br.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private static void byteReader2() {
		File file = new File("c:\\test\\vince.txt");
		// try的新写法，会在最后close掉BufferedInputStream，前提是此类必须继承close
		try(BufferedInputStream bis = new BufferedInputStream(new FileInputStream(file))) {
			byte[] bytes = new byte[1024];
			int len = -1;
			while((len=bis.read(bytes))!=-1) {
				System.out.println(new String(bytes,0,len));
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static void byteReader() {
		File file = new File("c:\\test\\vince.txt");
		try {
			InputStream in = new FileInputStream(file);
			// 构造一个字节缓存流
			BufferedInputStream bis = new BufferedInputStream(in);
			
			byte[] bytes = new byte[1024];
			int len = -1;
			while((len=bis.read(bytes))!=-1) {
				System.out.println(new String(bytes,0,len));
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private static void byteWriter() {
		File file = new File("c:\\test\\vince.txt");
		try {
			OutputStream out = new FileOutputStream(file);
			// 构造一个字节缓冲流
			BufferedOutputStream bos = new BufferedOutputStream(out);
			String info = "xxxx";
			bos.write(info.getBytes());
			bos.close();
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
//		byteWriter();
		byteReader();
	}

}
