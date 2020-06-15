package com.lgcns.algo.chap1;

import java.util.Scanner;

public class Recursion2 {

	public static void printCharsReverse(String str) {
		if (str.length() == 0)
			return;
		else {
			printCharsReverse(str.substring(1));
			System.out.print(str.charAt(0));
		}
	}

	public static void printInBinary(int n) {
		if (n < 2)
			System.out.print(n);
		else {
			printInBinary(n / 2);
			System.out.print(n % 2);
		}
	}
	

	/**
	 * for문을 사용하지 않고, int배열의 sum을 구한다.
	 * @param n
	 * @param data
	 * @return
	 */
	public static int sum(int n, int[] data) {
		if (n <= 0)
			return 0;
		else
			return sum(n - 1, data) + data[n - 1];
	}

	/**
	 * for loop대신 recursion을 사용한 샘플코드.
	 * @param n
	 * @param data
	 * @param in
	 */
	public void readFrom(int n, int[] data, Scanner in) {
		if(n==0)
			return;
		else {
			readFrom(n-1, data, in);
			data[n-1] = in.nextInt();
		}
	}
	
	public static void main(String[] args) {
		printCharsReverse("ABCDEFG");
		System.out.println();

		printInBinary(10);
		System.out.println();

		printInBinary(9);
		System.out.println();
		
		int [] data = new int[] {1,2,3,4,5,6,7,8,9,10};
		System.out.printf("sum(10, data) = %d\n", sum(10, data));
	}

}
