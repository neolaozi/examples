package com.lgcns.example.sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ComparatorDemo {
	public static void main(String[] args) {
        List<Person> persons = new ArrayList<Person>();

        persons.add(new Person("Umesh Awasthi", 35));
        persons.add(new Person("Robert Hickle", 55));
        persons.add(new Person("John Smith", 40));
        persons.add(new Person("David", 23));
        persons.add(new Person("David", 63));

        Collections.sort(persons, new Comparator<Person>() {
            public int compare(Person person, Person person1) {
                int name = person.getName().compareTo(person1.getName());
                if(name == 0){
                    return name;
                }
                return person.getAge() > person1.getAge() ? 1 : person.getAge() < person1.getAge() ? -1 : 0;
            }
        });


        for (Person person : persons) {
            System.out.println("Person is: " + person.getName());
        }
    }
}
