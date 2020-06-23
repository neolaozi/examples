package com.lgcns.prog.l1;

public class CollatzPrediction {
    public int solution(int num) {
        int answer = 0;
        
		while(num != 1 && answer<=500) {
			
        	if(num%2 ==  0) {
        		num /= 2;
        	} else if(num%2 == 1) {
        		num = (num*3) + 1;
        	}
			answer++;
        }
        
        System.out.println(answer);
		if(answer>=500) {
			return -1;
		} else {
	        return answer;
		}
    }

	public static void main(String[] args) {
		new CollatzPrediction().solution(6);
		new CollatzPrediction().solution(16);
		new CollatzPrediction().solution(626331);

	}

}
