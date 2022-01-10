package com.workshop.addressbook.entity;

import java.util.ArrayList;

public class AddressBookList {
	public String userInputBookName;
	public ArrayList<Contact> contacts;

	// constructor
	public AddressBookList(String userInputBookName) {
		this.userInputBookName = userInputBookName;
		this.contacts = new ArrayList<Contact>();
	}

	public String getUserInputBookName() {
		return userInputBookName;
	}

	public void setUserInputBookName(String userInputBookName) {
		this.userInputBookName = userInputBookName;
	}

	@Override
	public String toString() {
		return "Address Book name :- " + userInputBookName + "\n" + "Contacts :- " + contacts;
	}
}