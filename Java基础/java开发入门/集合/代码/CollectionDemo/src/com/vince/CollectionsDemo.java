package com.vince;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Collections??????
 * @author HP
 *
 */

public class CollectionsDemo {

	public static void main(String[] args) {
		
		List<String> list = new ArrayList<>();
		list.add("jack");
		list.add("tom");
		list.add("lily");
		
		Collections.reverse(list);
		Collections.shuffle(list);
		Collections.sort(list);
//		Collections.sort(list,c);
		
		Collections.swap(list,0,2);
		Collections.rotate(list,1);
		System.out.println(Collections.binarySearch(list, "tom"));
		System.out.println(Collections.max(list));
		System.out.println(Collections.min(list));
		
		Collections.fill(list, "bin");
		System.out.println(Collections.frequency(list, "lily"));
		Collections.replaceAll(list, "lily", "bin");
		
		List<String> syncList = (List<String>) Collections.synchronizedCollection(new ArrayList<String>());
		
		List<String> sList = Collections.emptyList();
		sList.add("bin");
		
		Collections.sort(list,Collections.reverseOrder());
		System.out.println(list);
	}
	
	public static List<String> query(){
		List<String> list = null;
		
		return Collections.emptyList();
	}

}
