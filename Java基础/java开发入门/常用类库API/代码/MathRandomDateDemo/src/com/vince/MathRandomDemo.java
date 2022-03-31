package com.vince;

import static java.lang.Math.floor;//æ≤Ã¨µº»Î

import java.util.Random;
public class MathRandomDemo {

	public static void main(String[] args) {
		System.out.println(Math.PI);
		System.out.println(Math.abs(-10));
		System.out.println(Math.round(Math.random()*1000/1000));
		System.out.println(Math.sqrt(2));
		System.out.println(floor(1.234556));
		
		Random r = new Random();
		System.out.println(r.nextLong());
		System.out.println(r.nextInt(10));
	}

}
