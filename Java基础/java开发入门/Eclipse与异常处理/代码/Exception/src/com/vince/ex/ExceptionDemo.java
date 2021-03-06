package com.vince.ex;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * 
 * @company
 * @author Journey
 * @description 1、Throwable是异常的基类，分为Error和Exception,在编程中我们关注Exception
 *              2.Exception分为编译器异常(受检)和运行期异常(非异常) 3.异常回导致程序中断，无法继续执行
 *              4、在开发中，我们需要把可能出现异常的代码使用try语句块包裹起来 5.处理异常可以让程序保持运行状态
 *              6.catch可以有多个，顺序为从子类到父类，大的放后面，小的放前面
 *              
 *              ArithmeticException
 *              ArrayIndexOutOfBoundsException
 *              NullPointerException
 *              InputMismatchException
 *              Exception
 *              RuntimeException
 *              ClassNotFoundException
 *              DataFormatException
 *              ClassCastException
 */

public class ExceptionDemo {

	public static void main(String[] args) {
		// div(10,0);
		// method();
//		try {
//			div2(20,0);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		System.out.println("over");
		input();
	}

	/**
	 * 除法运算
	 */
	private static void div(int num1, int num2) {
		int[] arr = { 1, 2, 3, 4, 5 };
		try {
			System.out.println(arr[4]);
			arr = null;
			System.out.println(arr.length);
			int result = num1 / num2;
			// alt+/
			System.out.println("result" + result);
		} catch (ArithmeticException e) { // 数学异常
			System.out.println("除数不能为0");
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("数组下标越界了");
		} catch (NullPointerException e) {
			System.out.println("空指针异常");
		} catch (Exction e) {
			System.out.println("出错啦");
		} finally { // 最终
			System.out.println("程序执行完毕");
		}
		System.out.println("程序结束");
	}

	private static int method() {
		int a = 10;
		int b = 5;
		try {
			System.out.println("a=" + a);
			System.out.println("b=" + b);
			int c = a / b;
			System.out.println("a/b=" + c);
			return c;
		} catch (Exception e) {
			// 代码测试时使用
			e.printStackTrace();
		} finally {
			System.out.println("finally.");
		}
		return -1;
	}

	// 当代码出现异常，会产生异常对象(JDK代码或JVM)，吧异常对象传入被匹配的catch中的异常对象变量
	private static int div2(int a, int b) throws ArithmeticException {
		try {
			int c = a / b;
			return c;
		} catch (ArithmeticException e) {
			throw new ArithmeticException("除数不能为0");
		} finally {
			System.out.println("运行结束");
		}
	}

	private static void input() {
		// ctrl + shift + o 导包
		Scanner input = new Scanner(System.in);
		try {
			int num = input.nextInt();
			System.out.println(num);
		} catch (InputMismatchException e) {
			System.out.println("格式不匹配");
		}
	}

}
