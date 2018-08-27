package com.lgcns.example.stream;

import java.util.Arrays;
import java.util.List;
import java.util.OptionalDouble;
import java.util.Spliterator;

/**
 * ¾Ã°í ¶â°í ¸Àº¸°í Áñ±â´Â ½ºÆ®¸² API<BR>
 * https://www.slideshare.net/arawnkr/api-42494051<BR>
 * 
 * 
 * <code>
 * Stream Creation - Intermediate Operator - Terminal Operator
 * contacts.stream()
 * .filter(c -> "Florida".equals(c.getState()))
 * .findFirst()
 * .ifPresent(c -> c.call());
 * </code>
 * @author 72318
 *
 */
public class StreamTestBasic {

	public static void main(String args[]) {
		test_spliterator();
		
//		streamIfPresent();
//		streamAPI();
//		explicitLooping();
	}

	
	
	public static void test_spliterator() {
		List<Integer> numList = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 0);
		Spliterator<Integer> firstSplit = numList.spliterator();
		Spliterator<Integer> secondSplit = firstSplit.trySplit();

		System.out.printf("firstSplit:%s\n", firstSplit.toString());
		// firstSplit.forEachRemaining(c --> System.out.printf("print:%d\n", c));
		System.out.printf("secondSplit:%s\n", secondSplit.toString());
	}
	
	public static void streamIfPresent() {
		List<Contact> contacts = ContactSource.findAll();
		contacts.stream()
		.filter(c -> "Florida".equals(c.getState()))
		.findFirst()
		.ifPresent(c -> c.call());
	}
	
	public static void streamAPI() {
		List<Contact> contacts = ContactSource.findAll();
		OptionalDouble averageAge = contacts.stream()
				.filter(c -> "Florida".equals(c.getState()))
				.filter(c -> Gender.Male == c.getGender())
				.mapToInt(c -> c.getAge()).average();
		System.out.printf("streamAPI() - averageAge:%s\n", averageAge.getAsDouble() + "");
	}

	/**
	 * explicitLooping
	 */
	public static void explicitLooping() {
		List<Contact> contacts = ContactSource.findAll();
		int manCount = 0;
		double totalAge = 0;
		for (Contact contact : contacts) {
			if ("Florida".equals(contact.getState()) && Gender.Male == contact.getGender()) {
				manCount += 1;
				totalAge += contact.getAge();
			}
		}
		double averageAge = totalAge / manCount;
		System.out.printf("explicitLooping() - averageAge:%s\n", averageAge + "");
	}
}


