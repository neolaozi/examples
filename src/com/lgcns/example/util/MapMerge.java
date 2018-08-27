package com.lgcns.example.util;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.lgcns.example.lambda.Computer;

public class MapMerge {

	public static void main(String[] args) throws Exception {
//		testMapMergeSumSimple();
		testMapMergeSumComplex();
	}
	
	public static void testMapMergeSumSimple(){
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.merge("A", 1, Integer::sum);
		map.merge("B", 1, Integer::sum);
		map.merge("C", 1, Integer::sum);
		System.out.printf("Map1:%s\n", map.toString());
		map.merge("A", 1, Integer::sum);
		System.out.printf("Map2:%s\n", map.toString());
		map.merge("A", 2, Integer::sum);
		System.out.printf("Map2:%s\n", map.toString());

		System.out.printf("A:%d, B:%d, C:%d\n", map.get("A"), map.get("B"), map.get("C"));
	}	
	
	public static void testMapMergeSumComplex(){
		List<Computer> listComputer = Arrays.asList(new Computer("127.0.0.1", "k8s master1", 4, 8),
				new Computer("192.168.1.100", "worker 1", 16, 64), new Computer("127.0.0.1", "k8s master2", 4, 8),
				new Computer("192.168.1.100", "worker 3", 32, 128), new Computer("127.0.0.1", "k8s master3", 4, 8),
				new Computer("10.64.65.14", "nexus", 2, 4), new Computer("192.168.1.100", "worker 2", 16, 64));
		
		
		Map<String, Integer> map = new HashMap<String, Integer>();
		listComputer.stream().filter(c -> c.getCore() >= 2).forEach(c -> map.merge(c.getIp(), c.getCore(), Integer::sum));
		System.out.printf("map:%s\n", map.toString());
	}
	

}
