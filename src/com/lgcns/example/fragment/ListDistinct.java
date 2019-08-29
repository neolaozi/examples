package com.lgcns.example.fragment;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.TreeSet;
import java.util.stream.Collectors;

import com.lgcns.example.lambda.collection.Person;

public class ListDistinct {

	// list==> [1, 2, 3, 4, 5, 5, 2, 1, 5]
	private static List<Integer> intList = Arrays.asList(1, 2, 3, 4, 5, 5, 2, 1, 5);

	// list==> [abc, 222, 123, 222, 123, abc]
	private static List<String> strList = Arrays.asList("abc", "222", "123", "222", "123", "abc");

	public static void printList(List list) {
		System.out.printf("list==> %s\n", list.toString());
	}

	// util
	public static List distinctWithLooping(List dataList) {
		ArrayList resultList = new ArrayList();
		for (int i = 0; i < dataList.size(); i++) {
			if (!resultList.contains(dataList.get(i))) {
				resultList.add(dataList.get(i));
			}
		}
		return resultList;
	}

	// util
	public static List distinctWithHashset(List list) {
		return new ArrayList(new HashSet(list));
	}

	// util
	public static List distinctWithStream(List list) {
		return intList.stream().distinct().collect(Collectors.toList());
	}

	// util : 오름차순 정렬까지 가능
	public static List distinctWithTreeSet(List list) {
		return new ArrayList(new TreeSet(list));
	}

	// util : 오름차순 정렬까지 가능
	public static List distinctWithTreeSetAndSort(Comparator comp, List list) {
		TreeSet list2 = new TreeSet(comp);
		list2.addAll(list);
		return new ArrayList(list2);
	}
	
	// example
	public void examDistinctWithLooping() {
		System.out.println("##### distinctWithLooping intList #####");
		ListDistinct.printList(distinctWithHashset(intList));

		System.out.println("##### distinctWithLooping strList #####");
		ListDistinct.printList(distinctWithHashset(strList));
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

	// example
	public void examDistinctWithTreeSet() {
		System.out.println("##### distinctWithTreeSet intList #####");
		ListDistinct.printList(distinctWithTreeSet(intList));

		System.out.println("##### distinctWithTreeSet strList #####");
		ListDistinct.printList(distinctWithTreeSet(strList));
	}

	// example
	public void examDistinctWithTreeSetAndSort() {
		System.out.println("##### examDistinctWithTreeSetAndSort intList #####");
		
	    // Lambda Comparator
	    Comparator<Integer> compIntegerAsc = (Integer p1, Integer p2) -> p1.compareTo(p2);
	    Comparator<Integer> compIntegerDsc = (Integer p1, Integer p2) -> p2.compareTo(p1);

	    Comparator<String> compStringAsc = (String p1, String p2) -> p1.compareTo(p2);
	    Comparator<String> compStringDsc = (String p1, String p2) -> p2.compareTo(p1);

		List resultList = distinctWithTreeSetAndSort(compIntegerAsc, intList);
		ListDistinct.printList(resultList);
		
		List resultStrList = distinctWithTreeSetAndSort(compStringAsc, strList);
		ListDistinct.printList(resultStrList);

		List resultStrList2 = distinctWithTreeSetAndSort(compStringDsc, strList);
		ListDistinct.printList(resultStrList2);

//		System.out.println("##### distinctWithTreeSet strList #####");
//		ListDistinct.printList(distinctWithTreeSet(strList));
	}

	public static void main(String[] args) {
		System.out.println("##### org intList #####");
		ListDistinct.printList(intList);
		System.out.println("##### org strList #####");
		ListDistinct.printList(strList);

		new ListDistinct().examDistinctWithHashset();
		
		new ListDistinct().examDistinctWithStream(); 

		new ListDistinct().examDistinctWithLooping(); 

		new ListDistinct().examDistinctWithTreeSet(); 
		
		new ListDistinct().examDistinctWithTreeSetAndSort(); 

		
	}

}
