package com.vince;

import java.util.Collection;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

/**
 * Map接口:
 * 1.键值对存储一组对象
 * 2.Key不能重复(唯一)，Value可以重复
 * 3.具体的实现类：HashMap TreeMap Hashtable LinkedHashMap
 * 4.HashMap 与 Hashtable的区别？
 * 
 * 5.如何选择使用哪个？
 * 
 * 6.数据结构：数组、链表、二叉树（红黑树）、哈希表（数组+链表）、栈、队列
 * @author HP
 *
 */

public class MapDemo {
	
	/**
	 * 基于二叉树的红黑树实现
	 */
	private static void treeMap() {
		Map<String,String> map = new TreeMap<>();
		map.put("one", "Tom");
		map.put("two", "lili");
		map.put("three", "gucci");
		map.forEach((key,value)->System.err.println(key+"->"+value));
		
		Map<Dog,String> dog = new TreeMap<>();
		dog.put(new Dog("2ha",1,3), "Tom");
		dog.put(new Dog("wangwang",1,3), "lili");
		dog.put(new Dog("hsq",1,3), "gucci");
		dog.forEach((key,value)->System.err.println(key+"->"+value));
	}
	
	/**
	 * LinkedHashMap是HashMap的子类，由于HashMap不能保证顺序恒久不变，此类使用一个双重链表来维护
	 * 元素添加的顺序
	 */
	private static void linkedHashMap() {
		Map<String,String> table = new LinkedHashMap<>();
		table.put("one", "Tom");
		table.put("two", "lili");
		table.put("three", "gucci");
		table.forEach((key,value)->System.err.println(key+"->"+value));
	}
	
	/**
	 * JDK1.0开始
	 * 基于哈希表实现(数组+链表)
	 * 默认数组大小为11，加载因子0.75
	 * 扩充方式：原数组大小<<1(*2)+1
	 * 线程安全的，用在多线程访问时
	 */
	private static void hashtable() {
		Map<String,String> table = new Hashtable<>();
		table.put("one", "Tom");
		table.put("two", "lili");
		table.put("three", "gucci");
		table.forEach((key,value)->System.err.println(key+"->"+value));
	}
	
	/**
	 * HashMap的实现原理：
	 * 1.基于哈希表(数组+链表+二叉树(红黑树)) 1.8JDK
	 * 2.默认加载因子为0.75，默认数组大小是16
	 * 3.把对象存储到哈希表中，如何存储？
	 * 把key对象通过hash()方法计算hash值，然后用这个hash值对数组长度取余数(默认16)，来决定该对KEY对象
	 * 在数组中存储的位置，当这个位置有多个对象时，以链表结构存储，JDK1.8后，当链表长度大于8时，链表将转换为
	 * 红黑树结构存储
	 * 这样的目的，是为了取值更快，存储的数据量越大，性能的表现越明显
	 * 
	 * 4.扩充原理：当数组的容量超过了75%，那么表示该数组需要扩充，如果扩充？
	 * 扩充的算法是：当前数组容量<<1（相当于是乘2），扩大一倍，扩充次数过多，会影响性能，每次扩充表示哈希表重写
	 * 散列（重写计算每个对象的存储位置），我们在开发中尽量减少扩充次数带来的性能问题
	 * 5.线程不安全，适合在单线程中使用。
	 */
	private static void hashMap() {
		Map<Integer,String> map = new HashMap<>();
		map.put(1, "Tom");
		map.put(2, "lili");
		map.put(3, "gucci");
		map.put(4, "andy");
		map.put(5, "cindy");
		
		System.out.println("size="+map.size());
		//从Map中取值
		System.out.println(map.get(1));// 通过key取value
		
		//map的遍历1 遍历Entry
		Set<Entry<Integer,String>> entrySet = map.entrySet();
		for(Entry e:entrySet) {
			System.out.println(e.getKey()+"->"+e.getValue());
		}
		
		//2遍历键
		Set<Integer> keys = map.keySet();
		for(Integer i:keys) {
			String value = map.get(i);
			System.out.println(i+"->"+value);
		}
		
		// 3遍历值
		Collection<String> values = map.values();
		for(String value:values) {
			System.out.println(value);
		}
		
		//4foreach
		map.forEach((key,value)->System.out.println(key+"->"+value));
	
		System.out.println(map.containsKey(7));
	}

	public static void main(String[] args) {
		hashMap();
	}

}
