package com.vince;

import java.util.Arrays;

public class StringDemo2 {

	public static void main(String[] args) {
		String str = "faewdwadadhaiwdhioahd1231";
		char c = str.charAt(1); // 根据下标获取
		System.out.println(c);
		
		System.out.println(str.toCharArray()); // 吧字符串变成新的字符串数组
		char[] cs = {'a','b','c'};
		String s1 = new String(cs);
		
		// value 作为字符源的数组 offset 初始偏移量 count 长度 
		String s2 = new String(cs,0,1);
		System.out.println(s2); // a
		
		System.out.println(Arrays.toString(str.getBytes()));
		
		System.out.println(str.replace('w', '*'));
		System.out.println(str.replaceAll("\\d", '*'));
		
		System.out.println(str.substring(0, 4));
		
		System.out.println(Arrays.toString(str.split("d")));
		
		System.out.println(str.contains('a')); // 查找字符串中是否存在某字符
		
		System.out.println(str.indexOf('f'));// 查找第一个字符的索引号
		System.out.println(str.lastIndexOf('f'));// 查找第一个字符的索引号
		
		System.out.println(str.isEmpty());
		
		System.out.println(str.length());
		System.out.println(str.trim());
		
		System.out.println(str.concat("xxxxx"));
		System.out.println(String.valueOf(10)); // 转成字符串
	}

}
