package com.guava;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.junit.Test;

import com.google.common.base.Function;
import com.google.common.base.Functions;
import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.BiMap;
import com.google.common.collect.Collections2;
import com.google.common.collect.HashBasedTable;
import com.google.common.collect.HashBiMap;
import com.google.common.collect.HashMultiset;
import com.google.common.collect.Lists;
import com.google.common.collect.Multimap;
import com.google.common.collect.Sets;
import com.google.common.collect.Sets.SetView;
import com.google.common.collect.Table;
import com.google.common.collect.Table.Cell;

public class GuavaDemo {
	
	/**
    双键的Map：Table类型->rowKey+columnkey+value
    */
    @Test
    public void testGuava10() {
        Table<String,String,Integer> table = HashBasedTable.create();
        table.put("jack", "java", 80);
        table.put("tom", "php", 85);
        table.put("bin", "java", 90);
        table.put("lily", "ui", 75);
        //guava的类table的方法
        Set<Cell<String,String,Integer>> cells = table.cellSet();
        for(Cell c:cells) {
            System.out.println(c.getRowKey()+"-"+c.getColumnKey()+"-"+c.getValue());
        }
    }
	
	//BiMap:双向Map(bidirectional Map) 键与值不能重复
	@Test
	public void testGuava9() {
		BiMap<String,String> map = HashBiMap.create();
		map.put("finally_test", "1352727737");
		map.put("bin_test", "1372772337");
		String name = map.inverse().get("1352727737");
		System.out.println(name);
		
		System.out.println(map.inverse().inverse()==map);
	}
	
	// Multimap:key可重复
	@Test
	public void testGuava8() {
		Map<String,String> map = new HashMap<>();
		//普通的Map中key是不能重复的
		map.put("Java从入门到精通","bin");
        map.put("Shell从入门到精通","bin");
        map.put("PHP从入门到精通","jack");
        map.put("SQL从入门到精通","vince");
        
        Multimap<String,String> mmap = ArrayListMultimap.create();
        Iterator<Map.Entry<String,String>> iter = map.entrySet().iterator();
        while(iter.hasNext()) {
            Map.Entry<String, String> entry = iter.next(); //把原来得Map转成可迭代的
            mmap.put(entry.getValue(), entry.getKey());    //Multimap的key是可以重复的
        }
        Set<String> keyset = mmap.keySet();
        for(String key:keyset) {
            Collection<String> values = mmap.get(key); //因为key是重复的，所以由key获取的vaules是多个值，所以返回值用集合的方式存储
            System.out.println(key+"->"+values);
        }
	}

	/**
	 * Multiset：无序可重复
	 */
	@Test
	public void testGuava7() {
		String s = "good good study day day up";
		String[] ss = s.split(" ");
		// guava的HashMultiset类的方法
		HashMultiset<String> s1 = HashMultiset.create();
		for (String str : ss) {
			s1.add(str);
		}
		Set<String> s2 = s1.elementSet();
		for (String str : s2) {
			System.out.println(str + ":" + s1.count(str));
		}
	}

	// 集合操作：交集、差集、并集
	@Test
	public void testGuava6() {
		Set<Integer> set1 = Sets.newHashSet(1, 2, 3);
		Set<Integer> set2 = Sets.newHashSet(3, 4, 5);
		// 交集
		SetView<Integer> v1 = Sets.intersection(set1, set2);
		v1.forEach(System.out::println);

		// 差集
		SetView<Integer> v2 = Sets.difference(set1, set2);
		v2.forEach(System.out::println);

		// 并集
		SetView<Integer> v3 = Sets.union(set1, set2);
		v3.forEach(System.out::println);
	}

	/**
	 * 加入约束：非空，长度验证
	 */
	public void testGuava5() {
//		Set<String> set = Sets.newHashSet();
//		// 14版可用
//		Constraint<String> constraint = new Constraint<>() {
//			@Override
//			public String checkElement(String element) {
//				
//			}
//		}
//		Preconditions.checkArgument(expression);
//		Preconditions.checkNotNull(reference);
	}

	/**
	 * guava 组合式函数编程
	 */
	@Test
	public void testGuava4() {
		// guava的Lists类中的方法
		List<String> list = Lists.newArrayList("java", "php", "jack", "h5", "javascript");
		// 首先创建Function的匿名对象：即在一个方法里直接创建该对象，并实现其方法
		Function<String, String> f1 = new Function<String, String>() {
			public String apply(String t) {
				return t.length() > 4 ? t.substring(0, 5) : t; // 判断长度大于4的之后，截取前5个元素
			}
		};
		Function<String, String> f2 = new Function<String, String>() {
			public String apply(String t) {
				return t.toUpperCase(); // 对多有的元素转换成大写
			}
		};

		// guava的Functions类中的方法
		Function<String, String> f = Functions.compose(f1, f2); // 组合两个Function
		Collection<String> colle = Collections2.transform(list, f);
		colle.forEach(System.out::println);
	}

	/**
	 * guava 转换
	 */
	@Test
	public void testGuava3() {
		Set<Long> timeSet = Sets.newHashSet(20121212L, 20170520L, 20160808L);
		// guava的Collections2类中的方法
		Collection<String> timeCollect = Collections2.transform(timeSet,
				(e) -> new SimpleDateFormat("YYYY-MM-DD").format(e));
		timeCollect.forEach(System.out::println);
	}

	/**
	 * 过滤器
	 */
	@Test
	public void testGuava2() {
		List<String> list = Lists.newArrayList("java", "php", "jack", "h5", "javascript");
		// guava的Collections2类中的方法
		Collection<String> result = Collections2.filter(list, (e) -> e.startsWith("j"));
		result.forEach(System.out::println);
	}

	/**
	 * 设置 只读
	 */
	@Test
	public void testGuava1() {
		System.out.println("test guava");
//		List<String> list = Arrays.asList("jack","tom","lily","bin");
//		list.add("vince");
		List<String> list = new ArrayList<>();
		list.add("jack");
		list.add("tom");
		list.add("lily");
		list.add("bin");
//		List<String> readList = Collections.unmodifiableList(list);
//		readList.add("zizi");

//		ImmutableList<String> iList = ImmutableList.of("jack","lily","tom","bin");
//		iList.add("vince");
	}

}
