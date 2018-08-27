package com.lgcns.example.stream;

import java.util.List;
import java.util.stream.Stream;

public class StreamTestMap {
	
	public static void main(String[] args) {
		streamMapForeachMethod();
		
		// streamMapForeach();
		
		// streamForEach();
		
		// streamFilter();
	}
	
	private static void streamMapForeachMethod() {
		List<Contact> contacts = ContactSource.findAll();
		
		contacts.stream().map(Contact::getState).forEach(System.out::println);
	}
	
	private static void streamMapForeach() {
		List<Contact> contacts = ContactSource.findAll();
		contacts.stream().map(c -> c.getState()).forEach(state -> System.out.println(state));
		contacts.stream().map(c -> c.getAge()).forEach(state -> System.out.println(state));
		contacts.stream().map(c -> c.getGender()).forEach(state -> System.out.println(state));
	}
	
	private static void streamForEach() {
		List<Contact> contacts = ContactSource.findAll();
		
		contacts.stream()
		.filter(c -> "NewYork".equals(c.getState()))
		.forEach(c -> System.out.printf("Contact:%s\n", c.toString()));;
	
		System.out.println("########################################");
		
		contacts.stream()
		.filter(c -> "California".equals(c.getState()))
		.forEach(c -> System.out.printf("Contact:%s\n", c.toString()));;

	}
	
	public static void streamFilter(){
		List<Contact> contacts = ContactSource.findAll();
		
		Stream<Contact> filteredStream = contacts.stream()
		.filter(c -> "NewYork".equals(c.getState()));
		
		System.out.printf("filteredCount: %d\n", filteredStream.count());;

	}
	
	
}
