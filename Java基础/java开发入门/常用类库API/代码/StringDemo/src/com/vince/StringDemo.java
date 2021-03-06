package com.vince;

/**
 * 
 * @author HP
 * String 表示一个字符串，内部使用字符数组实现，不能被继承(最终类)，不可变
 */

public class StringDemo {

	public static void main(String[] args) {
		// String 的两种赋值方式，JAVA推荐使用第一种方式
		
		// 1 直接赋值
		String s1 = "粪粪";
		// 2 使用new关键字创建对象，new:表示申请内存空间
		//问以下代码创建了几个对象？2个
		String s2 = new String("粪粪");
		
		String s3 = "粪粪";
		
		System.out.println(s1==s2);//false
		System.out.println(s1==s3);//true
		
		// 代码实例:4种情况分析：直接赋值字符串连接时，考虑编译期和运行期
		// 如果在编译器值可以被确定，那么就使用已有的对象，否则会创建新的对象
		String a = "a";
		String a1 = a+1;
		String a2 = "a1";
		System.out.println(a1==a2); // false
		// 原因。因为代码在编译器到28行的时候a不能被确定，到运行期才可以确定，所以不相等
		
		final String b = "b";
		String b1 = b+1;
		String b2 = "b1";
		System.out.println(b1==b2); // true
		// 原因，因为b是存放在静态池里面，b1可以在编译器获取到b，所以b2会从常量池里面获取值
		
		String c = getC();
		String c1 = c+1;
		String c2 = "c1";
		System.out.println(c1==c2); // false
		// 原因，因为c是从方法里面获取到值，方法在编译器不会被执行，所以c1无法获取到c，所以不想等
		
		final String d = getD();
		String d1 = d+1;
		String d2 = "d1";
		System.out.println(d1==d2); // false
		// 原因，虽然d加了final，但是方法在编译器不会被执行，运行期才执行，所以亦然不相等
	}
	
	private static String getC() {
		return "c";
	}
	
	private static String getD() {
		return "d";
	}

}
