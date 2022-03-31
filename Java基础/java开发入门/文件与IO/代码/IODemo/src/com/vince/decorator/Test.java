package com.vince.decorator;

public class Test {

	public static void main(String[] args) {
		SoyaBeanMilk milk = new SoyaBeanMilk();
		SugarDecorator sugar = new SugarDecorator(milk);
		EggDecorator egg = new EggDecorator(sugar);
		BlackBeanDecorator blackBean = new BlackBeanDecorator(egg);
		
		System.out.println("��Ķ���ʺ"+blackBean.description());
		System.out.println("�㻨����"+blackBean.cost());
	}

}
