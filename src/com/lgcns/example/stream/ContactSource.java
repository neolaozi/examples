package com.lgcns.example.stream;

import java.util.ArrayList;
import java.util.List;

class ContactSource {
	public static List<Contact> findAll() {
		List<Contact> listContact = new ArrayList<Contact>();
		listContact.add(new Contact("Florida", Gender.Male, 44));
		listContact.add(new Contact("Florida", Gender.Male, 32));
		listContact.add(new Contact("California", Gender.Female, 45));
		listContact.add(new Contact("California", Gender.Male, 39));
		listContact.add(new Contact("NewYork", Gender.Male, 30));

		listContact.add(new Contact("NewYork", Gender.Male, 22));
		listContact.add(new Contact("Florida", Gender.Male, 27));
		listContact.add(new Contact("Florida", Gender.Male, 51));
		listContact.add(new Contact("California", Gender.Female, 33));
		listContact.add(new Contact("California", Gender.Male, 35));

		return listContact;
	}
}
