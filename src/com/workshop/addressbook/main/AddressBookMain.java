package com.workshop.addressbook.main;

import com.workshop.addressbook.service.AddressBook;

public class AddressBookMain {

	/** Main method. **/
	public static void main(String[] args) {
		/** Displayed welcome message. **/
		System.out.println("--------WELCOME TO ADDRESS BOOK SYSTEM--------");
		
		AddressBook addressBook = new AddressBook();
		
		addressBook.addContact();
		addressBook.displayContacts();
	}
}
