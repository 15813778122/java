package com.vince.decorator;

/**
 * 具体的装饰者类
 * @author HP
 *
 */

public class EggDecorator extends Decorator {

	public EggDecorator(Drink drink) {
		super(drink);
	}
	@Override
	public float cost() {
		return super.cost()+3.0f;
	}
	@Override
	public String description() {
		return super.description()+"+鸡蛋";
	}

}
