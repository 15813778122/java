package com.vince;

import java.text.MessageFormat;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Scanner;

/**
 * ������ʻ�
 * 1.Locale��
 * ʹ�ô����еĹ��췽��������Locale
 * Locale(String language)
 * Locale(String language, String country)
 * ͨ����̬��������Locale
 * getDefault()
 * 2.Properties�ļ�:�����ļ�(�����ļ�),�����Լ�ֵ�Ե���ʽ���(key-value)
 * 3.ResourceBundle�����࣬���������ļ�����ָ��Locale�������Զ�ѡ��ʹ���ĸ������ļ���Ĭ�Ͻ�ʹ�������ϵͳ��ͬ�����Ի���
 * 	getString()�������������ļ���ʹ��key����ȡvalue
 * ע�⣬ResourceBundle��������ֻ����
 * @author HP
 * 
 */

public class I18NDemo {

	public static void main(String[] args) {
		// ����һ���������Ի������󣬸ö������ݲ����������Զ�ѡ����֮��ص����Ի���
		// ����:���ԡ�����
		Locale locale_CN = new Locale("zh","CN");
		Locale locale_US = new Locale("en","US");
		// ��ȡ��ǰϵͳĬ�ϵ����Ի���
		Locale locale_default = Locale.getDefault();
		
		Scanner input = new Scanner(System.in);
		// ���ڰ������ļ��Ĺ�����(����:�����ļ��Ļ�����(����ǰ׺�����磬info))
		ResourceBundle r = ResourceBundle.getBundle("com.vince.info");
		System.out.println(r.getString("system.name"));
		System.out.println(r.getString("input.name"));
		String username = input.nextLine();
		System.out.println(r.getString("input.password"));
		String password = input.nextLine();
		
		if("admin".equals(username) && "123".equals(password)) {
			System.out.println(r.getString("login.success"));
			String welcome = r.getString("welcome");
			// ��̬�ı���ʽ��
			welcome = MessageFormat.format(welcome, username);
			System.out.println(welcome);
		} else {
			System.out.println(r.getString("login.error"));
		}
	}

}
