package com.workshop.addressbook.service;

import java.util.ArrayList;
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
			addressBook.stream().filter(find -> find.userInputBookName.contains(enter))
					            .forEach(addressBook -> addressBook.contacts.add(contact));
	
			System.out.println("\nContact added Successfully.");
		}
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
}
