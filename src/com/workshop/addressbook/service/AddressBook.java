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
	
	// Building edit contact feature
		public void editContact() {
			System.out.println("\nEnter first name to edit :- ");
			String first_name = input.next();
			
			for (Contact person : contacts) {
				if (first_name.equalsIgnoreCase(person.getFirst_name())) {
					
					System.out.print("Enter new first name :- ");
					String newFirstName = input.next();
					person.setFirst_name(newFirstName);
					
					System.out.print("Enter new last name :- ");
					String newLastName = input.next();
					person.setLast_name(newLastName);
					
					System.out.print("Enter new Address :- ");
					String newAddress = input.next();
					person.setAddress(newAddress);
					
					System.out.print("Enter new city name :- ");
					String newCity = input.next();
					person.setCity(newCity);
					
					System.out.print("Enter new state name :- ");
					String newState = input.next();
					person.setState(newState);
					
					System.out.print("Enter new Zip code :- ");
					int newZip = input.nextInt();
					person.setZip_code(newZip);
					
					System.out.print("Enter new phonr number :- ");
					long newPhone = input.nextLong();
					person.setPhone_number(newPhone);
					
					System.out.print("Enter new email :- ");
					String newEmail = input.next();
					person.setEmail(newEmail);
					
					System.out.println("Contact edited Successfully.");
					break;
				}
				else {
					continue;
				}
			}
		}
		
		// adding deleting contact by name feature
		public void deleteContact() {
			System.out.print("Enter first name to delete contact:- ");
			String deleteByName = input.next();

			for (int i = 0; i < contacts.size(); i++) {
				String Finding_indexOfName = contacts.get(i).getFirst_name();

				if (deleteByName.equals(Finding_indexOfName)) {
					contacts.remove(i);
					System.out.println("\nSelected contact deleted successfully.");
					break;
				} else {
					continue;
				}
			}
		}
		
		// adding multiple person details feature added.
		public void addMultiplePersons() {
			System.out.println("Enter how many contacts you want to add :- ");
			int userWant = input.nextInt();
			for (int i = 1; i <= userWant; i++) {
				addContact();
			}
		}
}
