package com.vince;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;

/**
 * Properties:
 * properties可以用来配置文件
 * javaweb javaee开发中通常会用到
 * 
 * ResouceBundle只读
 * Properties 可读可写
 * @author HP
 *
 */

public class PropertiesDemo {

	public static String version = "";
	public static String username = "";
	public static String password = "";
	
	// 静态代码块，只会执行一次
	static {
//		readConfig();
	}
	
	/**
	 * 对属性文件的写入操作
	 */
	private static void writeConfig(String version, String username, String password) {
		Properties p = new Properties();
		p.put("app.version", version);
		p.put("db.username", username);
		p.put("db.password", password);
		try {
			OutputStream out = new FileOutputStream("config.properties");
			// 写文件
			p.store(out, "update config");
			out.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * 读取properties配置文件
	 * @param args
	 */
	private static void readConfig() {
		Properties p = new Properties();
		try {
			// 通过当前线程的类加载器对象，来加载指定包下的配置文件
			InputStream inStream = Thread.currentThread().getContextClassLoader().getResourceAsStream("com/res/config.properties");
//			InputStream inStream = new FileInputStream("config.properties");
			p.load(inStream);//加载文件
			
			// 从properties中获取数据
			version = p.getProperty("app.version");
			username = p.getProperty("db.username");
			password = p.getProperty("db.password");
			
			inStream.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static void main(String[] args) {
//		writeConfig("2","vince","71312");
		readConfig();
		System.out.println(PropertiesDemo.version);
		System.out.println(PropertiesDemo.username);
		System.out.println(PropertiesDemo.password);
	}

}
