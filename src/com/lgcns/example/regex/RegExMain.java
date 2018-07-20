package com.lgcns.example.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegExMain {

	public static void main(String[] args) {
		RegExMain.example1();
	}

	public static void example3() {

		String REGEX = "foo";
		String INPUT = "fooooooooooooooooo";
		Pattern pattern;
		Matcher matcher;

		pattern = Pattern.compile(REGEX);
		matcher = pattern.matcher(INPUT);

		System.out.println("Current REGEX is: " + REGEX);
		System.out.println("Current INPUT is: " + INPUT);

		System.out.println("lookingAt(): " + matcher.lookingAt());
		System.out.println("matches(): " + matcher.matches());
	}

	public static void example2() {
		String REGEX = "\\bcat\\b";		// 단독 단어
		String INPUT = "cat cat cat cattie cat catt ccat cat";
		// String INPUT = "cat";

		Pattern p = Pattern.compile(REGEX);
		Matcher m = p.matcher(INPUT); // get a matcher object
		int count = 0;

		while (m.find()) {
			count++;
			System.out.print("Match number " + count);
			System.out.print(", start(): " + m.start());
			System.out.println(", end(): " + m.end());
		}
		System.out.printf("Match count:%d\n", count);
		System.out.printf("lookingAt():%b\n", m.lookingAt());
		System.out.printf("matches():%b\n", m.matches());
		System.out.printf("groupCount():%d\n", m.groupCount());
	}

	public static void example1() {
		// String to be scanned to find the pattern.
		String line = "This order was placed for QT3000! OK?";
		String pattern = "(.*)(\\d+)(.*)";

		// Create a Pattern object
		Pattern r = Pattern.compile(pattern);

		// Now create matcher object.
		Matcher m = r.matcher(line);
		if (m.find()) {
			System.out.println("Found value: " + m.group(0));
			System.out.println("Found value: " + m.group(1));
			System.out.println("Found value: " + m.group(2));
		} else {
			System.out.println("NO MATCH");
		}
	}
}
