package com.vince.decorator;

/**
 * ����ı�װ������
 * ����
 * @author HP
 *
 */

public class SoyaBeanMilk implements Drink{

	@Override
	public float cost() {
		return 10f;
	}

	@Override
	public String description() {
		return "������";
	}


}
