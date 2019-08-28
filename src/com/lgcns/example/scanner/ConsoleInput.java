package com.lgcns.example.scanner;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ConsoleInput {

	public static void main(String[] args) throws Exception {

		// 사전작업
		// 1. throws Exception
		// 2. 클래스 임포트, Class Import
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		System.out.println("문자를 입력하세요."); // Label

		// reader 는 입력도구랍니다.
		String txt = reader.readLine();// == System.in.read()와 같은기능
		System.out.println(txt);
		txt = reader.readLine();
		System.out.println(txt);

		// 이름을 입력하면 인사를 해주는 프로그램..

		System.out.println("이름을 입력해주세요.");
		txt = reader.readLine();
		System.out.printf("%s님 안녕하세요\n", txt);

		// 요구사항. : 태어난 년도를 입력하여 그 사람의 나이를 구하는 프로그램!(전제조건 : 현재가 무조건 2018년이라고 가정)
		System.out.println("생년을 입력하시오");
		String data = reader.readLine();
		// Short.parseShort("100");
		// Byte.parseByte("100");
		// Long.parseLong("100");
		// Float.parseFloat("3.14");
		// Double.parseDouble("3.14");
		// Boolean.parseBoolean("true");

		// 문자형(숫자) -> 숫자형(숫자) 로 변환작업 해야함
		int year = Integer.parseInt(data);
		// System.out.println(2018-year);
		if (year > 2018) {
		} else {
			System.out.printf("태어난 년도가 %d년도이면 %d세 입니다.\n", year, 2018 - year);
		}

		// BufferedReader사용, 입력, "문자열" -> 그대로 ->"문자열"
		// 입력은 문자열이지만 숫자가 필요하면 -> Integer.parseInt()를 통해서 변환 후 int 변수에 저장!

		String data2 = reader.readLine(); // "a" <- 얘는 문자열 하지만 나는 'a'가 필요하다면
		char c = data2.charAt(0);
	}

}
