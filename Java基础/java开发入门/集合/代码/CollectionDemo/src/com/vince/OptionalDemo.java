package com.vince;

import java.util.Optional;

/**
 * Optional JDK1.8容器类
 * @author HP
 *
 */

public class OptionalDemo {

	public static void main(String[] args) {
		// 创建Optional对象的方式
		Optional<String> optional = Optional.of("bin");
//		Optional<String> optional2 = Optional.ofNullable("bin");
		Optional<String> optional3 = Optional.empty();
		
		System.out.println(optional.isPresent());
		System.out.println(optional.get());
		
		optional.ifPresent((value)->System.out.println(value));
		System.out.println(optional.orElse("无值"));
		System.out.println(optional.orElseGet(()->"default"));
		
		try {
			optional3.orElseThrow(Exception::new);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Optional<String> optional4 = optional.map((value)->value.toUpperCase());
		System.out.println(optional4.orElse("no found"));
	
		optional4 = optional.flatMap((value)->Optional.of(value.toUpperCase()+"-flatMap"));
		System.out.println(optional4.orElse("no found"));
		
		optional4 = optional.filter((value)->value.length()>3);
		System.out.println(optional4.orElse("小于3"));
	}

}
