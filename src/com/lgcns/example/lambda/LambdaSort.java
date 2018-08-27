package com.lgcns.example.lambda;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.lgcns.example.sort.Person;

public class LambdaSort {

	public static void main(String[] args) {
		List<Person> listPerson = Arrays.asList(new Person("A", 30), new Person("c", 27), new Person("C", 28), new Person("D", 24),
				new Person("B", 25), new Person("b", 26), new Person("F", 21), new Person("G", 21), new Person("E", 34));

		Collections.sort(listPerson, (g1, g2) -> g1.getName().compareTo(g2.getName()));
		System.out.printf("sorted by Name : %s\n", listPerson.toString());

		Collections.sort(listPerson, (g1, g2) -> g1.getName().compareToIgnoreCase(g2.getName()));
		System.out.printf("sorted by Name IgnoreCase : %s\n", listPerson.toString());

		Collections.sort(listPerson, (g1, g2) -> g2.getName().compareTo(g1.getName()));
		System.out.printf("sorted reverse by Name : %s\n", listPerson.toString());

		Collections.sort(listPerson, (g1, g2) -> (g1.getAge() - g2.getAge()));
		System.out.printf("sorted by Age : %s\n", listPerson.toString());

		Collections.sort(listPerson, (g1, g2) -> (g2.getAge() - g1.getAge()));
		System.out.printf("sorted reverse by Age : %s\n", listPerson.toString());
		
		Collections.sort(listPerson, Comparator.comparing(Person::getName));
		System.out.printf("sorted by Name : %s\n", listPerson.toString());

		Collections.sort(listPerson, Comparator.comparing(Person::getName).reversed());
		System.out.printf("sorted reverse by Name : %s\n", listPerson.toString());

		// Collections.sort(listPerson, Comparator.comparing(Person::getName));
		// System.out.printf("sorted by Name : %s\n", listPerson.toString());
	}

}
