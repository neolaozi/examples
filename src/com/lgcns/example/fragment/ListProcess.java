package com.lgcns.example.fragment;

import java.util.ArrayList;
import java.util.List;

public class ListProcess {

	/**
	 * INPUT : List<String>
	 * OUTPUT : List<String>
	 * PROCESS : for loop
	 * @param inputList
	 * @return
	 */
	public static List<String> processList(List<String> inputList) {
		List<String> outputList = new ArrayList<String>();
		
		for(int idx=0 ; idx < inputList.size() ; idx++){
			outputList.add(String.format("idx : %s", idx));
		}
		
		return outputList;
	}
	
	public static void main(String[] args) {
		
	}
}
