package com.lgcns.example.lambda.collection;

import java.util.Collections;
import java.util.List;
import java.util.Comparator;

/**
 * @author MikeW
 */
public class ComparatorTest {

  public static void main(String[] args) {
   
    List<Person> personList = Person.createShortList();
  
    // Sort with Inner Class
    Collections.sort(personList, new Comparator<Person>(){
      public int compare(Person p1, Person p2){
        return p1.getSurName().compareTo(p2.getSurName());
      }
    });
    
    System.out.println("=== Sorted Asc SurName ===");
    for(Person p:personList){
      p.printName();
    }
    
    // Use Lambda instead
    Comparator<Person> SortSurNameAsc = (Person p1, Person p2) -> p1.getSurName().compareTo(p2.getSurName());
    Comparator<Person> SortSurNameDesc = (p1,  p2) -> p2.getSurName().compareTo(p1.getSurName());
    
    // Print Asc
    System.out.println("=== Sorted Asc SurName ===");
    Collections.sort(personList, SortSurNameAsc);

    for(Person p:personList){
      p.printName();
    }
    
    // Print Desc
    System.out.println("=== Sorted Desc SurName ===");
    Collections.sort(personList, SortSurNameDesc);

    for(Person p:personList){
      p.printName();
    }
    
  }
}