package com.lgcns.example.sort;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ComparatorComparingTest {

	public static void main(String[] args) {
		List<Human> humanList = Arrays.asList(
			new Human("A", 20), 
			new Human("D", 35), 
			new Human("E", 32), 
			new Human("B", 35),
			new Human("D", 28), 
			new Human("B", 44),
			new Human("C", 51));
		Comparator<Human> byName = Comparator.comparing(Human::getName);
		Comparator<Human> byAge = Comparator.comparing(Human::getAge);

		// by name
		Collections.sort(humanList, byName);
		System.out.println("Collections.sort(humanList, byName)-->");
		humanList.forEach(System.out::println);

		// by age
		Collections.sort(humanList, byAge);
		System.out.println("Collections.sort(humanList, byAge)-->");
		humanList.forEach(System.out::println);

		// by name
		Collections.sort(humanList, Comparator.comparing(Human::getName));
		System.out.println("Collections.sort(humanList, Comparator.comparing(Human::getName))-->");
		humanList.forEach(System.out::println);

		// by name reverse
		// Collections.sort(humanList, Comparator.comparing(Human::getName).reversed());
		Collections.sort(humanList, Comparator.comparing(Human::getName, Comparator.reverseOrder()));
		System.out.println("Collections.sort(humanList, Comparator.comparing(Human::getName).reversed())-->");
		humanList.forEach(System.out::println);
		
		// by name, age composed
		Collections.sort(humanList, Comparator.comparing(Human::getName).thenComparing(Human::getAge));
		System.out.println("Collections.sort(humanList, Comparator.comparing(Human::getName).thenComparing(Human::getAge))-->");
		humanList.forEach(System.out::println);

		// by name, age(reverse) composed
		Collections.sort(humanList, Comparator.comparing(Human::getName).thenComparing(Human::getAge, Comparator.reverseOrder()));
		System.out.println("Collections.sort(humanList, Comparator.comparing(Human::getName).thenComparing(Human::getAge, Comparator.reverseOrder()))-->");
		humanList.forEach(System.out::println);
	}

}

class Human {

	String name;
	int age;

	public Human(String name, int age) {
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