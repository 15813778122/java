package com.vince.ex;

public class AssertDemo {
	public static void main(String[] args) {
		int result = add(10,19);
		assert result==20:"�������ȷ";
	}
	private static int add(int a, int b) {
		return a+b;
	}
}
