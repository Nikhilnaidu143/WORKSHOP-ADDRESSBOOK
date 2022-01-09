package com.workshop.addressbook.main;

import java.io.IOException;
import java.util.Scanner;

import com.workshop.addressbook.service.AddressBook;

public class AddressBookMain {

		// main method
		public static void main(String[] args) throws IOException {
			System.out.println("--------------------Welcome To Address Book Program-----------------------");
			AddressBook obj = new AddressBook();
			Scanner input = new Scanner(System.in);
			
			System.out.print("Enter valid option to perform Address Book Application[1.Enter (or) 2.Exit] :- ");
			int enterExit = input.nextInt();
			if (enterExit == 1) {
				while (enterExit != 2) {
					System.out.println("Choose which operation you want to perform from below list :- ");
					System.out.println("1.Add Contact.");
					System.out.println("2.Edit Contact");
					System.out.println("3.Delete Contact.");
					System.out.println("4.Display contact.");
					System.out.println("5.Exit.");

					System.out.println("\nEnter your choice :- ");
					int userChoice = input.nextInt();

					switch (userChoice) {
					case 1:
						obj.addContact();;
						break;
					case 2:
						obj.editContact();
						break;
					case 3:
						obj.deleteContact();
						break;
					case 4:
						obj.displayContacts();
						break;
					default:
						System.out.println("Enter valid choice from the list...");
					}
					if (userChoice == 5) {
						System.out.println("Successfully exited from the Address Book Application.");
						break;
					}
				}
			} else if (enterExit == 2) {
				System.out.println("Successfully exited from the Address Book Application.");
			} else {
				System.out.println("Choose Valid option [1.Enter (or) 2.Exit]...");
			}
			input.close();
		}
}
