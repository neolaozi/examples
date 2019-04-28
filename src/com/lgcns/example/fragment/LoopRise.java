package com.lgcns.example.fragment;

public class LoopRise {

	public static void forAddResult(int endNum) {
		int sum=0;
		
		for(int i=0 ; i<endNum ; i++) {
			// sum result
			int result = i; 	// ADD code-block result
			sum += result;
			System.out.println(String.format("idx: %s, sum: %s", i, sum));
		}
	}
	
	public static void whileAddResult(int count) {
		int sum=0;
	
		int idx=0;
		while(idx < count){
			sum += idx;	//	ADD code-block result
			System.out.println(String.format("idx: %s, sum: %s", idx, sum));
			idx++;
		}
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		LoopRise.forAddResult(3);
		System.out.println("##############");
		LoopRise.whileAddResult(3);
	}

}
