package com.lgcns.example.sort;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LambdaSortTest {

	public static void main(String[] args) {
		

		// by name
		List<Persona> personaList;
		personaList = getList();
		personaList.sort((h1, h2) -> h1.getName().compareTo(h2.getName()));
		System.out.println("personaList.sort((h1, h2) -> h1.getName().compareTo(h2.getName()))-->");
		personaList.forEach(System.out::println);

		// by name. if equal name then age
		personaList = getList();
		personaList.sort((lhs, rhs) -> {
	        if (lhs.getName().equals(rhs.getName())) {
	            return lhs.getAge() - rhs.getAge();
	        } else {
	            return lhs.getName().compareTo(rhs.getName());
	        }
	    });
		System.out.println("personaList.sort name. if equal name then age -->");
		personaList.forEach(System.out::println);
		
		
		// with stream. 
		personaList = getList();
		List<Persona> sortedPersonaList = personaList.stream().sorted((h1, h2) -> h1.getName().compareTo(h2.getName())).collect(Collectors.toList());
		
		System.out.println("org List<Persona> -->");
		personaList.forEach(System.out::println);
		
		System.out.println("sorted List<Persona> -->");
		sortedPersonaList.forEach(System.out::println);
		
	}

	private static List<Persona> getList() {
		return Arrays.asList(
				new Persona("A", 20), 
				new Persona("D", 35), 
				new Persona("E", 32), 
				new Persona("B", 35),
				new Persona("D", 28), 
				new Persona("B", 44),
				new Persona("C", 51));
	}
}

class Persona {

	String name;
	int age;

	public Persona(String name, int age) {
		this.name = name;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "name:" + name + ", age:" + age;
	}

}