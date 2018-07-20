package com.lgcns.example.util;

import java.util.HashMap;
import java.util.Map;

public class MapCounter {

	
	public static void main(String[] args) throws Exception {
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.merge("A", 1, Integer::sum);
		map.merge("B", 1, Integer::sum);
		map.merge("C", 1, Integer::sum);
		System.out.printf("Map1:%s\n", map.toString());
		map.merge("A", 1, Integer::sum);
		System.out.printf("Map2:%s\n", map.toString());
		map.merge("A", 2, Integer::sum);
		System.out.printf("Map2:%s\n", map.toString());
	}
}
