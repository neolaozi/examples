package com.lgcns.example.sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SortTest {

	public void arraysSort(){
		
		List<String> list= new ArrayList<String>();
		list.add("AAA");
		list.add("CCC");
		list.add("EEE");
		list.add("DDD");
		list.add("BBB");
		
		Collections.sort(list, new StringReverseComparator());
		System.out.printf("sorted list : %s\n", list);
		
	}
	
	public static void main(String[] args) {
		new SortTest().arraysSort();
	}

}

class StringComparator implements Comparator<String> {

	@Override
	public int compare(String str1, String str2) {
		int compared = str1.compareTo(str2);
		return compared > 0 ? 1 : compared < 0 ? -1 : 0;
	}
	
}

class StringReverseComparator implements Comparator<String> {

	@Override
	public int compare(String str1, String str2) {
		int compared = str1.compareTo(str2);
		return compared > 0 ? -1 : compared < 0 ? 1 : 0;
	}
	
}
