package com.vince;

import java.io.IOException;
import java.io.StreamTokenizer;
import java.io.StringReader;

/**
 * 
 * 字符串流：以一个字符串为数据源，来构造一个字符流
 * 作用：在WEB开发中，我们经常要从服务器上获取数据，数据的返回格式通常屎一个字符串(XML,JSON),我们需要把这个字符串构造成一个字符流
 * 然后再用第三方的数据解析器来解析数据
 * StringWriter
 * @author HP
 *
 */

public class StringStreamDemo {
	
	private static void stringReader() {
		String info = "good good study day day up";
		StringReader sr = new StringReader(info);
		//流标记器,把字符串放入流标记器为了获取单词个数
		StreamTokenizer st = new StreamTokenizer(sr);
		
		int count = 0;
		while(st.ttype != StreamTokenizer.TT_EOF) {
			try {
				if(st.nextToken()==StreamTokenizer.TT_WORD) {
					count++;
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println("count="+count);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		stringReader();
	}

}
