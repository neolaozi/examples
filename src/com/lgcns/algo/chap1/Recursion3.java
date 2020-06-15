package com.lgcns.algo.chap1;

public class Recursion3 {

	// 순차탐색
	int search(int[] data, int n, int target) {
		for (int i = 0; i < n; i++)
			if (data[i] == target)
				return i;
		return -1;
	}

	// 시작인덱스를 매개변수로 변환
	int search(int[] data, int begin, int end, int target) {
		if (begin > end)
			return -1;
		else if (target == data[begin])
			return begin;
		else
			return search(data, begin + 1, end, target);
	}

	/*
	 * begin에서 end사이에서 최대값을 찾아서 반환
	 * begin<=end라고 가정한다.
	 * 
	 */
	int findMax(int[] data, int begin, int end) {
		if (begin == end)
			return data[begin];
		else
			return Math.max(data[begin], findMax(data, begin + 1, end));
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
