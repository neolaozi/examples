package com.lgcns.example.fragment;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

public class ListDistinct {

	// list==> [1, 2, 3, 4, 5, 5, 2, 1, 5]
	private static List<Integer> intList = Arrays.asList(1,2,3,4,5,5,2,1,5);
	
	// list==> [abc, 222, 123, 222, 123, abc]
	private static List<String> strList = Arrays.asList("abc", "222", "123", "222", "123", "abc");
	
	public static void printList(List list) {
		System.out.printf("list==> %s\n", list.toString());
	}
	
	// util
	public static List distinctWithHashset(List list) {
		return new ArrayList(new HashSet(list));
	}

	// util
	public static List distinctWithStream(List list) {
		return intList.stream().distinct().collect(Collectors.toList());
	}
	
	// example 
	public void examDistinctWithHashset() {
		System.out.println("##### distinctWithHashset intList #####");
		ListDistinct.printList(distinctWithHashset(intList));

		System.out.println("##### distinctWithHashset strList #####");
		ListDistinct.printList(distinctWithHashset(strList));
	}
	
	// example 
	public void examDistinctWithStream() {
		System.out.println("##### distinctWithStream intList #####");
		ListDistinct.printList(distinctWithStream(intList));

		System.out.println("##### distinctWithStream strList #####");
		ListDistinct.printList(distinctWithStream(strList));
	}

	
	
	public static void main(String[] args) {
		System.out.println("##### org intList #####");
		ListDistinct.printList(intList);
		System.out.println("##### org strList #####");
		ListDistinct.printList(strList);
		
		new ListDistinct().examDistinctWithHashset();

	}

}
