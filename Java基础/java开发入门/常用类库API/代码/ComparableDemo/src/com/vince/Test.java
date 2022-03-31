package com.vince;

import java.util.Arrays;

public class Test {

	public static void main(String[] args) {
		int[] nums = {72,123,43,13,45,23,54,32};
		Arrays.sort(nums);
		System.out.println(Arrays.toString(nums));
		
		String[] names = {"javc","tom","∑∆∑∆","∑‡∑‡"};
		Arrays.sort(names);
		System.out.println(Arrays.toString(names));
		
		Cat[] cats = {new Cat("∑ﬂ∑ﬂ",1),new Cat("√¿√¿",4),new Cat("Tom",2)};
		Arrays.sort(cats);
		System.out.println(Arrays.toString(cats));
		
		Dog[] dogs = {new Dog("∑ﬂ∑ﬂ",1),new Dog("√¿√¿",4),new Dog("Tom",2)};
		Arrays.sort(dogs, new DogComparator());
		System.out.println(Arrays.toString(dogs));
	}

}
