package com.lgcns.example.stream;

public class Contact {
	
	private String state;
	private Gender gender;
	private int age;

	public Contact(String state, Gender gender, int age) {
		super();
		this.state = state;
		this.gender = gender;
		this.age = age;
	}

	public void call() {
		System.out.printf("%s Yrs Old Called...\n", this.age);
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public Gender getGender() {
		return this.gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("[");
		sb.append(getState());
		sb.append(", ");
		sb.append(getAge());
		sb.append(", ");
		sb.append(getGender() == Gender.Male ? "Male" : "Female");
		sb.append("]");
		return sb.toString();
	}
	
	
}
