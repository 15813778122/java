package com.vince;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * ���ϵ����(����)
 * @author HP
 *
 */

public class IteratorDemo {
	
	//���Խӿ�
	private static void predicateTest() {
		List<String> list = Arrays.asList("Lili","Zizi","kubi","opop");
		List<String> result = filter(list,(s)->s.contains("o"));
		result.forEach(System.out::println);
	}
	
	private static List<String> filter(List<String> list,Predicate<String> p){
		List<String> results = new ArrayList<>();
		for(String s:list) {
			if(p.test(s)) {
				results.add(s);
			}
		}
		return results;
	}
	
	//Supplier ��������Ӧ��
	private static void supplierTest() {
		List<Integer> list = getNums(10,()->(int)(Math.random() * 100));
		list.forEach(System.out::println);
	}
	
	private static List<Integer> getNums(int num,Supplier<Integer> sup){
		List<Integer> list = new ArrayList<>();
		for(int i = 0;i<num;i++) {
			list.add(sup.get());
		}
		return list;
	}
	
	// ��ʾ����һ�������������ṹ�ĺ���
	private static void functionTest() {
		String s = strToUpp("qf_vince",(str)->str.toUpperCase());
		System.out.println(s);
	}
	
	public static String strToUpp(String str,Function<String, String> f) {
		return f.apply(str);
	}
	
	/**
	 * JDK1.8�µĵ�������
	 */
	private static void foreach() {
		List<String> list = new ArrayList<>();
		list.add("tom");
		list.add("tom1");
		list.add("tom2");
		list.add("tom3");
		
		list.forEach(s->System.out.println(s));
		//list.forEach(System.out::println);
	}
	
	private static void enumeration() {
		Vector<String> vs = new Vector<>();
		vs.add("tom");
		vs.add("tom1");
		vs.add("tom2");
		vs.add("tom3");
		
		Enumeration<String> es = vs.elements();
		while(es.hasMoreElements()) {
			System.out.println(es.nextElement());
		}
	}
	
	//foreach(1.5��)
	private static void foreach(Collection<Cat> c) {
		for(Cat cat:c) {
			System.out.println(cat);
		}
	}
	
	// iterator(1.5֮ǰͳһ�ĵ������Ϸ�ʽ)
	private static void iterator(Collection<Cat> c) {
		Iterator<Cat> iter = c.iterator();
		while(iter.hasNext()) {
			System.out.println(iter.next());
		}
	}

	public static void main(String[] args) {
		List<Cat> list = new ArrayList<>();
		Cat c1 = new Cat("miaomiao",5,1);
		Cat c2 = new Cat("miaomiao1",4,1);
		Cat c3 = new Cat("miaomiao2",6,1);
		Cat c4 = new Cat("miaomiao3",5,1);
		list.add(c1);
		list.add(c2);
		list.add(c3);
		list.add(c4);
		iterator(list);
		foreach(list);
	}

}
