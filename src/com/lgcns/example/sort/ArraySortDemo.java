package com.lgcns.example.sort;

import java.util.Arrays;
import java.util.Comparator;

public class ArraySortDemo {
	public static void main(String[] args) {
        Person[] persons = new Person[5];

        persons[0] = new Person("Umesh Awasthi", 35);
        persons[1] = new Person("Robert Hickle", 55);
        persons[2] = new Person("John Smith", 40);
        persons[3] = new Person("David", 23);
        persons[4] = new Person("David", 63);

        // 1. Anonymous Comparator
        Arrays.sort(persons, new Comparator<Person>() {
            public int compare(Person person1, Person person2) {
                return person1.getName().compareTo(person2.getName());
            }
        });

        for (Person person : persons) {
            System.out.printf("Person name:%s, age:%d \n", person.getName(), person.getAge());
        }

        // 2. Java8 - Comparator.comparing
        Comparator<Person> byNameThenAge = Comparator.comparing(Person::getName).thenComparing(Person::getAge);
        Arrays.sort(persons, byNameThenAge);
        
        for (Person person : persons) {
            System.out.printf("Person name:%s, age:%d \n", person.getName(), person.getAge());
        }
    }
}
