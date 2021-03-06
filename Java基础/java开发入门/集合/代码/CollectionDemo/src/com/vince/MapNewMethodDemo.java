package com.vince;

import java.util.HashMap;
import java.util.Map;

/**
 * Map接口1.8新增方法介绍
 * @author HP
 *
 */

public class MapNewMethodDemo {

	public static void main(String[] args) {
		Map<Integer,String> map = new HashMap<>();
		map.put(1,"jack");
		map.put(2,"tom");
		map.put(3,"lily");
		String s = map.get(5);
		
		String value = map.getOrDefault(4, "null");
		System.out.println(value);
		
		if(s==null) {
			System.out.println();
		} else {
			
		}
		
		String val = map.put(3,"vince");
		System.out.println(val);
		
		// 只会添加不存在相同key的值
		String val1 = map.putIfAbsent(3,"vince");
		System.out.println(val1);
		
		map.forEach((k,v)->System.out.println(k+"->"+v));
		// 根据键和值都匹配才删除
		map.remove(1,"jack");
		
		map.replace(3,"vince");
		map.replace(3,"lily","vince");
		
		map.compute(1,(k,v1)->v1+"1");
		map.computeIfAbsent(5,(v)->v+"test");
		
		map.merge(8,"888",(oldVal,newVal)->oldVal.concat(newVal));
		
		map.forEach((k,v)->System.out.println(k+"->"+v));
	}

}
