package com.lgcns.example;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Skoh5 {
	// make hash string
	void sha256(String input) throws NoSuchAlgorithmException {
		MessageDigest digest = MessageDigest.getInstance("SHA-256");
		byte[] result = digest.digest(input.getBytes());
		StringBuffer strBuf = new StringBuffer();

		for (int i = 0; i < result.length; i++) {
			strBuf.append(Integer.toString((result[i] & 0xFF) + 0x100, 16).substring(1));
		}
	}

	// net - https://gist.github.com/junsuk5/f0ff2298e17853dc48e89f2dfc7bd985

	// lock -
	// https://winterbe.com/posts/2015/04/30/java8-concurrency-tutorial-synchronized-locks-examples/

	public static void main(String[] args) {
		// keyin
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while (true) {
			// String strInput = br.readLine();
		}

		// list sort -
		// Collections.sort(al, (g1, g2) ->
		// g1.getName().compareTo(g2.getName()));
	}

	// block chain
	// http://www.bitweb.co.kr/news/list.php?mcode=m659o6x
	// https://www.popit.kr/java-%EC%BD%94%EB%93%9C%EB%A1%9C-%EC%9D%B4%ED%95%B4%ED%95%98%EB%8A%94-%EB%B8%94%EB%A1%9D%EC%B2%B4%EC%9D%B8blockchain/

	// external exec
	// http://blog.daum.net/_blog/BlogTypeView.do?blogid=0Nz1O&articleno=69&categoryId=29&regdt=20090430162905

	// thread pool
	// http://hochulshin.com/java-multithreading-executor-basic/
	// https://winterbe.com/posts/2015/04/07/java8-concurrency-tutorial-thread-executor-examples/

	// 최대공약수
	private long gcd(int p, int q) {
		if (q == 0)
			return p;
		return gcd(q, p % q);
	}

	// 최소공배수
	private long lcm(int p, int q) {
		return (long) (p * q) / gcd(p, q);
	}
}
