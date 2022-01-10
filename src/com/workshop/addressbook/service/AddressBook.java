package com.workshop.addressbook.service;

import java.util.ArrayList;
import java.util.Dictionary;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Scanner;

import com.workshop.addressbook.entity.AddressBookList;
import com.workshop.addressbook.entity.Contact;

public class AddressBook {
	static Scanner input = new Scanner(System.in);
	static ArrayList<AddressBookList> addressBook = new ArrayList<>();

	/** Adding contacts **/
	public void addContact() {
		
		if (addressBook.isEmpty()) {
			System.out.println("\nPlease add Address book to add contacts.");
			return;
		} else {
			System.out.println("Enter address book name in which you want to add contacts :- ");
			String enter = input.next();
			
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
			
			if (duplicateCheck(enter , first_name)) {
				addressBook.stream().filter(find -> find.userInputBookName.contains(enter))
						.forEach(addressBook -> addressBook.contacts.add(contact));
	
				System.out.println("\nContact added Successfully.\n");
			}
			else {
				System.out.println("\nYou have already this person in your contact list.\n");
				return;
			}
		}
	}
	
	/**
	 * UC-7:- Ability to ensure there is no Duplicate Entry of the same Person in a
	 * particular Address Book.
	 **/
	public boolean duplicateCheck(String enter , String first_name) {
		for (AddressBookList addressBook : addressBook) {
			if (enter.equals(addressBook.userInputBookName)) {
				for (Contact person : addressBook.contacts) {
					if (first_name.equals(person.getFirst_name())) {
						return false;
					}
					else {
						continue;
					}
				}
			}
			else {
				continue;
			}
		}
		return true;
	}
	
	// Building edit contact feature
		public void editContact() {
			System.out.println("Enter address book name in which you want to edit contacts :- ");
			String enter = input.next();
			System.out.println("\nEnter first name to edit :- ");
			String first_name = input.next();
			
			for (AddressBookList addressBook : addressBook) {
				if (enter.equals(addressBook.userInputBookName)) {
					for (Contact person : addressBook.contacts) {
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
							
							System.out.print("Enter new phone number :- ");
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
				else {
					continue;
				}
			}
		}
		
		// adding deleting contact by name feature
		public void deleteContact() {
			System.out.println("Enter address book name in which you want to delete contacts :- ");
			String enter = input.next();
			System.out.print("Enter first name to delete contact:- ");
			String deleteByName = input.next();

			for (AddressBookList addressBook : addressBook) {
				if (enter.equals(addressBook.userInputBookName)) {
					for (Contact person : addressBook.contacts) {
						if (deleteByName.equals(person.getFirst_name())) {
							addressBook.contacts.remove(person);
							System.out.println("\nSelected contact deleted successfully.");
							break;
						} else {
							continue;
						}
					}
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
		
		// UC-6:- Ability to add multiple address books to system
		public void newAddressBook() {
			
			System.out.println("Enter Address Book Name :- ");
			String userInputBookName = input.next();
			
			if(!checkUnique(userInputBookName)) {
				System.out.println("OOPS! You aleady have AddressBook with same name.\n");
				return;
			}
			
			AddressBookList addressBookObj = new AddressBookList(userInputBookName);
			addressBook.add(addressBookObj);

			System.out.println("New Address Book Name is added to list.");
		}

		/*** Checking for unique address Book ***/
		public boolean checkUnique(String userInputBookName) {
			if(addressBook.isEmpty()) {
				return true;
			}
			for(int i = 0; i < addressBook.size(); i++) {
				String getName = addressBook.get(i).userInputBookName;
				if(getName.equals(userInputBookName)) {
					return false;
				}
			}
			return true;
		}
		
		// display address book
		public void displayAddressBook() {
			for (AddressBookList addressBook : addressBook) {
				System.out.println(addressBook);
			}
		}
		
		/**
		 * UC-8:- Ability to search Person in a City or State across the multiple
		 * AddressBook.
		 **/
		public void searchPersonByCity() {
			
			System.out.print("\nEnter city to search person by city name :- ");
			String searchCity = input.next();
			
			for (AddressBookList addressBook : addressBook) {
				for (Contact person : addressBook.contacts) {
					if (searchCity.equals(person.getCity())) {
						System.out.println("Persons who are in same city " + "(" + searchCity + ") :- " + person.getFirst_name());
					} else {
						continue;
					}
				}
			}
		}
		
		public void searchPersonByState() {
			
			System.out.print("\nEnter State to search person by city name :- ");
			String searchState = input.next();
			
			for (AddressBookList addressBook : addressBook) {
				for (Contact person : addressBook.contacts) {
					if (searchState.equals(person.getState())) {
						System.out.println("Persons who are in same state " + "(" + searchState + ") :- " + person.getFirst_name());
					} else {
						continue;
					}
				}
			}
		}
		
		/**
		 * UC-9:- Ability to view Persons by City or State - Maintain Dictionary of City
		 * and Person as well as State and Person.
		 **/
		public void viewPersonByCity() {
			
			System.out.print("\nEnter city to view person by city name :- ");
			String searchCity = input.next();
			
			Dictionary cityWiseDict = new Hashtable();

			for (AddressBookList addressBook : addressBook) {
				for (Contact person : addressBook.contacts) {
					if (searchCity.equals(person.getCity())) {
						cityWiseDict.put(person , searchCity);
					} else {
						continue;
					}
				}
			}
			System.out.println("Persons who are in same city " + searchCity + " :- ");
			for(Enumeration i = cityWiseDict.keys(); i.hasMoreElements();) {
				System.out.println(i.nextElement());
			}
			System.out.println(" ");
		}
		
		public void viewPersonByState() {
			System.out.print("\nEnter state to view person by State name :- ");
			String searchState = input.next();
			
			Dictionary stateWiseDict = new Hashtable();

			for (AddressBookList addressBook : addressBook) {
				for (Contact person : addressBook.contacts) {
					if (searchState.equals(person.getState())) {
						stateWiseDict.put(person, searchState);
					} else {
						continue;
					}
				}
			}
			System.out.println("Persons who are in same state " + searchState + " :- ");
			for(Enumeration i = stateWiseDict.keys(); i.hasMoreElements();) {
				System.out.println(i.nextElement());
			}
			System.out.println(" ");
		}
}
