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

	private String ip;
	private String name;
	private int core;
	private int memory;

	public Computer(String ip, String name, int core, int memory) {
		super();
		this.ip = ip;
		this.name = name;
		this.core = core;
		this.memory = memory;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getCore() {
		return core;
	}

	public void setCore(int core) {
		this.core = core;
	}

	public int getMemory() {
		return memory;
	}

	public void setMemory(int memory) {
		this.memory = memory;
	}
	
	@Override
	public String toString() {
		return "Computer [" + (ip != null ? "ip=" + ip + ", " : "") + (name != null ? "name=" + name + ", " : "")
				+ "core=" + core + ", memory=" + memory + "]\n";
	}

	public static void main(String[] args) {
		List<Computer> listComputer = Arrays.asList(new Computer("10.64.65.11", "k8s master1", 4, 8),
				new Computer("10.64.65.13", "worker 1", 16, 64), new Computer("10.64.65.15", "k8s master2", 4, 8),
				new Computer("10.64.65.16", "worker 3", 32, 128), new Computer("10.64.65.17", "k8s master3", 4, 8),
				new Computer("10.64.65.14", "nexus", 2, 4), new Computer("10.64.65.12", "worker 2", 16, 64));
		
		Collections.sort(listComputer, (a, b) -> a.getIp().compareTo(b.getIp()));

		System.out.printf("sorted by Ip : %s\n", listComputer.toString());
		System.out.printf("sorted by Ip : %s\n", Arrays.toString(listComputer.toArray()));
		
		
	}

}
