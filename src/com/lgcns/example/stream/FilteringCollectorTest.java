package com.lgcns.example.stream;

import java.util.Arrays;
import java.util.Collection;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class FilteringCollectorTest {

	public static Collection<Integer> findEvenNumbers(Collection<Integer> baseCollection) {
		Predicate<Integer> streamsPredicate = item -> item % 2 == 0;
		return baseCollection.stream().filter(streamsPredicate).collect(Collectors.toList());
	}

	public static void main(String[] args) {
		Collection<Integer> baseCollection = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
		Collection<Integer> findEvenNumbers = FilteringCollectorTest.findEvenNumbers(baseCollection);
		findEvenNumbers.forEach(System.out::println);
	}

}
