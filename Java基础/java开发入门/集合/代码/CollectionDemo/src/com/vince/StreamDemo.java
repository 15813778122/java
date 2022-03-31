package com.vince;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Stream接口：不是存储数据结构，数据源可以是一个集合，为了函数式编程创造
 * 惰性执行，数据只能被消费一次
 * 
 * 两种类型的操作方法：
 * 1.中间操作(生成一个Stream)
 * 2.结束操作(执行计算操作)
 * @author HP
 *
 */

public class StreamDemo {

	public static void main(String[] args) {
		Stream<String> stream = Stream.of("good good study day day up");
		// foreach方法
		stream.forEach((str)->System.out.println(str));
//		stream.forEach(System.out::println);
		
		// filter
		stream.filter(s->s.length()>3).forEach(System.out::println);
		
		// distinct
		stream.distinct().forEach(s->System.out.println(s));
	
		// map
		stream.map(s->s.toUpperCase()).forEach(s->System.out.println(s));
		
		//flatMap
		Stream<List<Integer>> ss = Stream.of(Arrays.asList(1,2,3),Arrays.asList(4,5));
		ss.flatMap(list->list.stream()).forEach(s->System.out.println(s));
	
		// reduce
		List<String> list = stream.collect(Collectors.toList());
		list.forEach(s->System.out.println(s));
		
		// ::方法引用
		// 引用静态方法	Integer::valueOf
		// 引用对象的方法	list:add
		// 引用构造
	}

}
