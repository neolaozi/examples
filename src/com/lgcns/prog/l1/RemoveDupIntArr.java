package com.lgcns.prog.l1;

import java.util.Arrays;

public class RemoveDupIntArr {
	public int[] solution(int[] arr) {
		int[] answer = new int[arr.length];
		int prev = -1;
		int index = 0;

		for (int i = 0; i < arr.length; i++) {
			
			if (arr[i] == prev) {
				continue;
			} else {
				prev = arr[i];
				answer[index] = arr[i];
				index++;
			}
		}
		answer = Arrays.copyOf(answer, index);
		System.out.println("answer=" + Arrays.toString(answer));

		return answer;
	}

	public static void main(String[] args) {
		int[] input1 = new int[]{1, 1, 3, 3, 0, 1, 1};
		int[] input2 = new int[]{4, 4, 4, 3, 3};
		
		int[] output1 = new RemoveDupIntArr().solution(input1);
		int[] output2 = new RemoveDupIntArr().solution(input2);
	}
}
