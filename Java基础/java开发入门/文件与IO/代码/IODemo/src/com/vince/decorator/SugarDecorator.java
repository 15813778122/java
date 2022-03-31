package com.vince.decorator;

/**
 * �����װ������
 * @author HP
 *
 */

public class SugarDecorator extends Decorator {

	public SugarDecorator(Drink drink) {
		super(drink);
	}
	@Override
	public float cost() {
		return super.cost()+1.0f;
	}
	@Override
	public String description() {
		return super.description()+"+��";
	}

}
