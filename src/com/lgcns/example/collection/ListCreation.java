package com.lgcns.example.collection;

import java.util.Arrays;
import java.util.List;

public class ListCreation {
	public void givenArraysAsList_thenInitialiseList() {
	    List<String> list = Arrays.asList("foo", "bar");
	    list.forEach(System.out::println);
	}
	public static void main(String[] args) {
		new ListCreation().givenArraysAsList_thenInitialiseList();
		
	}
}
