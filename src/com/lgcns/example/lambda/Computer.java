package com.lgcns.example.lambda;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import com.lgcns.example.sort.Person;

/**
 * @author 72318
 *
 */
public class Computer {

	public static void main(String[] args) {
		
		
	}

	/**
	 * non-comparable Object sorting
	 */
	public static void testSortOnNonComparable() {
		List<Computer> listComputer = Arrays.asList(new Computer("10.64.65.11", "k8s master1", 4, 8),
				new Computer("10.64.65.13", "worker 1", 16, 64), new Computer("10.64.65.15", "k8s master2", 4, 8),
				new Computer("10.64.65.16", "worker 3", 32, 128), new Computer("10.64.65.17", "k8s master3", 4, 8),
				new Computer("10.64.65.14", "nexus", 2, 4), new Computer("10.64.65.12", "worker 2", 16, 64));
		
		Collections.sort(listComputer, (a, b) -> a.getIp().compareTo(b.getIp()));

		System.out.printf("sorted by Ip : %s\n", listComputer.toString());
		System.out.printf("sorted by Ip : %s\n", Arrays.toString(listComputer.toArray()));
	}

	private int core;
	private String ip;
	private int memory;
	private String name;

	public Computer(String ip, String name, int core, int memory) {
		super();
		this.ip = ip;
		this.name = name;
		this.core = core;
		this.memory = memory;
	}

	public double compute(int core, int memory){
		return (core + (memory/2));
	}
	
	public int getCore() {
		return core;
	}

	public String getIp() {
		return ip;
	}

	public int getMemory() {
		return memory;
	}

	public String getName() {
		return name;
	}

	public void setCore(int core) {
		this.core = core;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public void setMemory(int memory) {
		this.memory = memory;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Computer [" + (ip != null ? "ip=" + ip + ", " : "") + (name != null ? "name=" + name + ", " : "")
				+ "core=" + core + ", memory=" + memory + "]\n";
	}

}
