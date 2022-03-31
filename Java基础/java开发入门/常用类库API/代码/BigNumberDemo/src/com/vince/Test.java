package com.vince;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.text.DecimalFormat;
import java.util.Arrays;

public class Test {

	public static void main(String[] args) {
		String val1 = "123712045729373012";
		String val2 = "137019409182318239";
		BigInteger b1 = new BigInteger(val1);
		BigInteger b2 = new BigInteger(val2);
		
		System.out.println(b1.add(b2)); // +
		System.out.println(b1.subtract(b2)); // -
		System.out.println(b1.multiply(b2)); // *
		System.out.println(b1.divide(b2)); // /
		System.out.println(b1.remainder(b2)); // %

		System.out.println(Arrays.toString(b1.divideAndRemainder(b2))); // / and %
		
		String val3 = "122.123712372132";
		String val4 = "2";
		BigDecimal b3 = new BigDecimal(val3);
		BigDecimal b4 = new BigDecimal(val4);
		System.out.println(b3.add(b4));
		System.out.println(b3.subtract(b4));
		System.out.println(b3.multiply(b4));
		System.out.println(b3.divide(b4));
		// System.out.println(b3.scale()-b4.scale());
		
		double pi=3.1415927;//Բ����
		//ȡһλ���������:3
		System.out.println(new DecimalFormat("0").format(pi));
		//ȡһλ��������λС��,���3.14
		System. out.println(new DecimalFormat("0.00").format(pi));
		//ȡ��λ��������λС��,�������㲿����O������:03.142
		System.out.println(new DecimalFormat("00.000").format(pi));
		//ȡ������������,���:3
		System.out.println(new DecimalFormat("#").format(pi));
		//�԰ٷֱȷ�ʽ����,��ȡ��λС��,���:314.16%
		System.out.println(new DecimalFormat( "#.##%").format(pi));

		long num = 1231441344;
		System.out.println(new DecimalFormat("###,###").format(num));
	}

}
