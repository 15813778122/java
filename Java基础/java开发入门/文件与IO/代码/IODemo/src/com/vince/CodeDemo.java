package com.vince;

import java.io.UnsupportedEncodingException;

public class CodeDemo {
	public static void main(String[] args) {
		//通常产生乱码的情况是，两个不兼容的编码相互转换
		String info = "小河流水回来了"; // GB2312
		try {
			String newInfo = new String(info.getBytes("gb2312"),"iso8859-1");
			System.out.println(newInfo);
			
			String newInfo2 = new String(newInfo.getBytes("iso8859-1"),"gb2312");
			System.out.println(newInfo2);
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
