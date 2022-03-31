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
 * properties�������������ļ�
 * javaweb javaee������ͨ�����õ�
 * 
 * ResouceBundleֻ��
 * Properties �ɶ���д
 * @author HP
 *
 */

public class PropertiesDemo {

	public static String version = "";
	public static String username = "";
	public static String password = "";
	
	// ��̬����飬ֻ��ִ��һ��
	static {
//		readConfig();
	}
	
	/**
	 * �������ļ���д�����
	 */
	private static void writeConfig(String version, String username, String password) {
		Properties p = new Properties();
		p.put("app.version", version);
		p.put("db.username", username);
		p.put("db.password", password);
		try {
			OutputStream out = new FileOutputStream("config.properties");
			// д�ļ�
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
	 * ��ȡproperties�����ļ�
	 * @param args
	 */
	private static void readConfig() {
		Properties p = new Properties();
		try {
			// ͨ����ǰ�̵߳������������������ָ�����µ������ļ�
			InputStream inStream = Thread.currentThread().getContextClassLoader().getResourceAsStream("com/res/config.properties");
//			InputStream inStream = new FileInputStream("config.properties");
			p.load(inStream);//�����ļ�
			
			// ��properties�л�ȡ����
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
