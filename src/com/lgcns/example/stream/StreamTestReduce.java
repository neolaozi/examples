package com.lgcns.example.stream;

import java.util.ArrayList;
import java.util.Collections;
import java.util.IntSummaryStatistics;
import java.util.Iterator;
import java.util.List;
import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class StreamTestReduce {

	public static void main(String[] args) {
		streamReduceToList();

		// streamReduceCreateAddMerge_methodRef();
		// streamReduceCreateAddMerge();
		// streamReduceSummaryStatistics();
		// streamReduceSumMinMaxAvg();
		// streamReduceSum();
		// simpleSum();
	}

	// simply Collect Variable State.
	private static void streamReduceToList() {
		List<Contact> contacts = ContactSource.findAll();

		List<String> states = contacts.stream().map(contact -> contact.getState()).collect(Collectors.toList());
		System.out.printf("states:%s\n", states);
		
		List<String> distinctStates = contacts.stream().map(contact -> contact.getState()).distinct().collect(Collectors.toList());
		System.out.printf("distinctStates:%s\n", distinctStates);
	}

	// 공급자, 누산자, 결합자 - Method Reference
	private static void streamReduceCreateAddMerge_methodRef() {
		List<Contact> contacts = ContactSource.findAll();

		// method-ref
		ArrayList<Object> states = contacts.stream().map(contact -> contact.getState()).collect(ArrayList::new,
				ArrayList::add, ArrayList::addAll);

		System.out.printf("states:%s", states);

	}

	// 공급자, 누산자, 결합자.
	private static void streamReduceCreateAddMerge() {
		List<Contact> contacts = ContactSource.findAll();

		// rambda
		ArrayList<Object> states = contacts.stream().map(contact -> contact.getState()).collect(() -> new ArrayList<>(),
				(list, state) -> list.add(state), (left, right) -> left.addAll(right));
	}

	private static void streamReduceToArray() {
		List<Contact> contacts = ContactSource.findAll();

		Iterator<Contact> iterator = contacts.stream().iterator();

		Object[] array = contacts.stream().toArray();
		Contact[] array2 = contacts.stream().toArray(Contact[]::new);

	}

	private static void streamReduceSummaryStatistics() {
		List<Contact> contacts = ContactSource.findAll();
		IntSummaryStatistics stats = contacts.stream().mapToInt(Contact::getAge).summaryStatistics();

		System.out.printf("sum:%s, avg:%s, min:%s, max:%s, count:%s\n", stats.getSum(), stats.getAverage(),
				stats.getMin(), stats.getMax(), stats.getCount());
	}

	private static void streamReduceSumMinMaxAvg() {
		List<Contact> contacts = ContactSource.findAll();

		int sum = contacts.stream().mapToInt(Contact::getAge).sum();
		OptionalDouble avg = contacts.stream().mapToInt(Contact::getAge).average();
		OptionalInt min = contacts.stream().mapToInt(Contact::getAge).min();
		OptionalInt max = contacts.stream().mapToInt(Contact::getAge).max();

		System.out.printf("sum:%s, avg:%s, min:%s, max:%s\n", sum, avg, min, max);

	}

	private static void streamReduceSum() {
		// int sum = IntStream.rangeClosed(1, 100).reduce(0, (left, right) ->
		// left + right);
		// int sum = IntStream.rangeClosed(1, 100).parallel().reduce(0, (left,
		// right) -> left + right);
		// int sum = IntStream.rangeClosed(1, 100).reduce(0, Integer::sum);
		int sum = IntStream.rangeClosed(1, 100).parallel().reduce(0, Integer::sum);

		System.out.printf("sum:%d\n", sum);
	}

	private static void simpleSum() {
		int sum = 0;
		for (int i = 1; i <= 100; i++) {
			sum += i;
		}
		System.out.printf("sum:%d\n", sum);
	}
}
