package com.lgcns.example.stream;

import java.util.ArrayList;
import java.util.List;

public class GroupbyWithProperty {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	}
}

class Contract {

	String region;
	Gender gender;
	int age;

	public Contract(String region, Gender gender, int age) {
		this.region = region;
		this.gender = gender;
		this.age = age;
	}

	public static List<Contract> findAll() {
		List<Contract> listContract = new ArrayList<Contract>();
		listContract.add(new Contract("Florida", Gender.Male, 44));
		listContract.add(new Contract("Florida", Gender.Male, 32));
		listContract.add(new Contract("California", Gender.Female, 45));
		listContract.add(new Contract("California", Gender.Male, 39));
		listContract.add(new Contract("NewYork", Gender.Male, 30));

		listContract.add(new Contract("NewYork", Gender.Male, 22));
		listContract.add(new Contract("Florida", Gender.Male, 27));
		listContract.add(new Contract("Florida", Gender.Male, 51));
		listContract.add(new Contract("California", Gender.Female, 33));
		listContract.add(new Contract("California", Gender.Male, 35));

		return listContract;
	}
}
