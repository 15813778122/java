package com.vince;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Stream�ӿڣ����Ǵ洢���ݽṹ������Դ������һ�����ϣ�Ϊ�˺���ʽ��̴���
 * ����ִ�У�����ֻ�ܱ�����һ��
 * 
 * �������͵Ĳ���������
 * 1.�м����(����һ��Stream)
 * 2.��������(ִ�м������)
 * @author HP
 *
 */

public class StreamDemo {

	public static void main(String[] args) {
		Stream<String> stream = Stream.of("good good study day day up");
		// foreach����
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
		
		// ::��������
		// ���þ�̬����	Integer::valueOf
		// ���ö���ķ���	list:add
		// ���ù���
	}

}
