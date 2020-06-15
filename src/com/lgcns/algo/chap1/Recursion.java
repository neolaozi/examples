package com.lgcns.algo.chap1;

public class Recursion {

	public static int recursionSum(int n) {
		if (n == 0)
			return 0;
		else
			return n + recursionSum(n - 1);
	}

	public static int factorial(int n) {
		if (n == 0)
			return 1;
		else
			return n * factorial(n - 1);
	}

	public static double power(double x, int n) {
		if (n == 0)
			return 1;
		else
			return x * power(x, n - 1);
	}

	public static int fibonacci(int n) {
		if (n < 2)
			return n;
		else
			return fibonacci(n - 1) + fibonacci(n - 2);
	}

	// GCD : Euclid Method
	public static double gcd(int m, int n) {
		if (m < n) {
			int tmp = m;
			m = n;
			n = tmp; // swap m and n
		}
		if (m % n == 0)
			return n;
		else
			return gcd(n, m % n);
	}

	// simple gcd
	public static int simpleGcd(int p, int q) {
		if (q == 0)
			return p;
		else
			return simpleGcd(q, p % q);
	}

	public static void main(String[] args) {

		System.out.printf("gcd(%d, %d)=%f", 30, 12, gcd(30, 12));
	}

}
