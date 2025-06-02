package com.lgcns.example.scanner;

import java.util.Scanner;

public class ConsoleEcho {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("한 줄 입력하세요 (종료하려면 exit 입력):");

		while (true) {
			String line = scanner.nextLine();
			if ("exit".equalsIgnoreCase(line)) {
				System.out.println("프로그램을 종료합니다.");
				break;
			}
			System.out.println("입력: " + line);
		}

		scanner.close();
	}
}
