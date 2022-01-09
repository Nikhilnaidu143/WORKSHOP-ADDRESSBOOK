package com.workshop.addressbook.service;

import java.util.ArrayList;
import java.util.Scanner;

import com.workshop.addressbook.entity.Contact;

public class AddressBook {
	static Scanner input = new Scanner(System.in);
	static ArrayList<Contact> contacts = new ArrayList<Contact>();

	/** Adding contacts **/
	public void addContact() {
		System.out.print("Enter First Name:- ");
		String first_name = input.next();

		System.out.print("Enter Last Name:- ");
		String last_name = input.next();

		System.out.print("Enter Address:- ");
		String address = input.next();

		System.out.print("Enter City:- ");
		String city = input.next();

		System.out.print("Enter State:- ");
		String state = input.next();

		System.out.print("Enter Zip Code:- ");
		int zip_code = input.nextInt();

		System.out.print("Enter Phone Number:- ");
		long phone_number = input.nextLong();

		System.out.print("Enter E-mail:- ");
		String email = input.next();

		Contact contact = new Contact(first_name, last_name, address, city, state, zip_code, phone_number, email);
		contacts.add(contact);

		System.out.println("\nContact added Successfully.");
	}

	/** Displaying added contacts **/
	public void displayContacts() {
		System.out.println("\n---------------Contacts in Address Book----------------");
		for (Contact person : contacts) {
			System.out.println(person.toString());
		}
	}
}
