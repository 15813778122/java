package com.vince.decorator;

/**
 * װ���ߵĻ���
 * @author HP
 *
 */

public abstract class Decorator implements Drink{
	private Drink drink;//Ҫװ�εĶ���
	public Decorator(Drink drink) {
		this.drink = drink;
	}
	@Override
	public float cost() {
		return drink.cost();
	}

	@Override
	public String description() {
		return drink.description();
	}

}
