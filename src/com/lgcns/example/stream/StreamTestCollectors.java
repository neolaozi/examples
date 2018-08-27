package com.lgcns.example.stream;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamTestCollectors {
	
	public static void main(String[] args) throws IOException {
		readFileToStream();
		
		// collectorsGroupBy();

		// collectorsMethod();
	}
	
	// File to Stream
	private static void readFileToStream() throws IOException {
		// C:\ssp_workspace\ssp_java_test\java-utils\resource\titanic3.xls
		
		// Stream<String> lines = Files.lines(Paths.get("titanic3.xls"));
		Stream<String> lines = Files.lines(Paths.get("C:/ssp_workspace/ssp_java_test/java-utils/resource/titanic3.xls"));
		System.out.printf("lines:%s\n", lines);
	}
	
	private static void collectorsGroupBy() {
		List<Contact> contacts = ContactSource.findAll();
		
		Map<String, List<Contact>> mapByState = contacts.stream().collect(Collectors.groupingBy(Contact::getState));
		System.out.printf("mapByState:%s\n", mapByState);
	}
	
	private static void collectorsMethod() {
		List<Contact> contacts = ContactSource.findAll();

		List<Contact> contactList = contacts.stream().collect(Collectors.toList());
		System.out.printf("contactList:%s\n", contactList);

		Set<Contact> contactSet = contacts.stream().collect(Collectors.toSet());
		System.out.printf("contactSet:%s\n", contactSet);

		// Contact must implement java.lang.Comparable
		// TreeSet<Contact> treeSet = contacts.stream().collect(Collectors.toCollection(TreeSet::new));
		// System.out.printf("treeSet:%s\n", treeSet);
		
		// Map<String, Integer> contactMap = contacts.stream().collect(Collectors.toMap(Contact::getState, Contact::getAge));
		// System.out.printf("contactMap:%s\n", contactMap);
		
		String concatedState = contacts.stream().map(Contact::getState).collect(Collectors.joining());
		System.out.printf("concatedState:%s\n", concatedState);

		String concatedState2 = contacts.stream().map(Contact::getState).collect(Collectors.joining("|"));
		System.out.printf("concatedState:%s\n", concatedState2);
	}
}
