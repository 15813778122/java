package com.vince.decorator;

public class Test {

	public static void main(String[] args) {
		SoyaBeanMilk milk = new SoyaBeanMilk();
		SugarDecorator sugar = new SugarDecorator(milk);
		EggDecorator egg = new EggDecorator(sugar);
		BlackBeanDecorator blackBean = new BlackBeanDecorator(egg);
		
		System.out.println("你的豆浆屎"+blackBean.description());
		System.out.println("你花费了"+blackBean.cost());
	}

}
