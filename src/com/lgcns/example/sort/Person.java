package com.lgcns.example.sort;

public class Person implements Comparable<Person> {

	private String name;
	private int age;

	public Person(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int compareTo(Person person) {
		return this.age > person.age ? 1 : this.age < person.age ? -1 : 0;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(getName());
		sb.append("(");
		sb.append(getAge());
		sb.append(")");
		
		return sb.toString();
	}
}
