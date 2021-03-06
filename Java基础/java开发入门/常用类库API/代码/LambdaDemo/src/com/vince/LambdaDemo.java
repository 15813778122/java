package com.vince;

import java.util.Arrays;
import java.util.Comparator;

public class LambdaDemo {

	public static void main(String[] args) {
//		IEat ieat1 = new IEatImpl();
//		ieat1.eat();
//		
//		IEat ieat2 = new IEat() {
//			public void eat() {
//				System.out.println("eat banana");
//			}
//		};
//		ieat2.eat();
		
		// lambda表达式:
		// 好处:1.代码更简洁 2.不会单独生成class文件
		// IEat ieat3 = ()->{System.out.println("eat apple banana");};
		
		// 没有参数的时候
//		IEat ieat3 = ()->System.out.println("eat apple banana");
//		ieat3.eat();
		
		// 带参数时，使用，参数的类型可以省略
//		IEat ieat3 = (thing,name) -> System.out.println("eat.."+thing+".."+name);
//		ieat3.eat("apple","大兵");
		
		// 带返回值的方法
//		IEat ieat3 = (thing,name) -> {
//			System.out.println(name + "eat" + thing);
//			return 10;
//		};
		
		// 带返回值的方法中只有一句实现代码
		IEat ieat3 = (final String thing, final String name) -> thing==null?1:0;
		ieat3.eat("apple","大兵");
		
		Student[] students = {
				new Student("张三",18),
				new Student("张四",28),
				new Student("张一",15),
		};
		Arrays.sort(students,new Comparator<Student>() {
			public int compare(Student o1, Student o2) {
				return o1.getAge() - o2.getAge();
			}
		});
		
//		Comparator<Student> c = (o1,o2)->o1.getAge()-o2.getAge();
		Arrays.sort(students,(o1,o2)->o1.getAge()-o2.getAge());
		System.out.println(Arrays.toString(students));
		
		IEat.method();
		
	}
}

//只有一个抽象方法的接口
// 如果接口中有默认方法或者静态方法不影响上面的写法
	interface IEat {
		public int eat(final String thing, final String name);
		public default void print() {
			System.out.println("print");
		}
		public static void method() {
			System.out.println("method...");
		}
	}
	
//	class IEatImpl implements IEat {
//		public void eat(String thing) {
//			System.out.println("eat--"+thing);
//		}
//	}

