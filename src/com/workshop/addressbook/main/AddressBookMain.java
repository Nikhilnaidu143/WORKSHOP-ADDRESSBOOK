package com.workshop.addressbook.main;

import java.io.IOException;
import java.util.Scanner;

import com.workshop.addressbook.service.AddressBook;
import com.workshop.addressbook.service.FileOperations;

public class AddressBookMain {

		// main method
		public static void main(String[] args) throws IOException {
			System.out.println("--------------------Welcome To Address Book Program-----------------------");
			AddressBook obj = new AddressBook();
			FileOperations fileObj = new FileOperations();
			
			Scanner input = new Scanner(System.in);
			
			System.out.print("Enter valid option to perform Address Book Application[1.Enter (or) 2.Exit] :- ");
			int enterExit = input.nextInt();
			if (enterExit == 1) {
				while (enterExit != 2) {
					System.out.println("Choose which operation you want to perform from below list :- ");
					System.out.println("1.Add Contacts.");
					System.out.println("2.Edit Contact");
					System.out.println("3.Delete Contact.");
					System.out.println("4.Add Address Book.");
					System.out.println("5.Display AddressBook.");
					System.out.println("6.Search person by city.");
					System.out.println("7.Search person by state.");
					System.out.println("8.View contacts by city.");
					System.out.println("9.View contacts by state.");
					System.out.println("10.Count persons by city.");
					System.out.println("11.Count persons by state.");
					System.out.println("12.Sort by name/city/state/zip.");
					System.out.println("13.Write into text file.");
					System.out.println("14.Read from text file.");
					System.out.println("15.Write into CSV file.");
					System.out.println("16.Read from CSV file.");
					System.out.println("17.Write into JSON file.");
					System.out.println("18.Read from JSON file.");
					System.out.println("19.Exit.");

					System.out.println("\nEnter your choice :- ");
					int userChoice = input.nextInt();

					switch (userChoice) {
					case 1:
						obj.addMultiplePersons();
						break;
					case 2:
						obj.editContact();
						break;
					case 3:
						obj.deleteContact();
						break;
					case 4:
						obj.newAddressBook();
						break;
					case 5:
						obj.displayAddressBook();
						break;
					case 6:
						obj.searchPersonByCity();
						break;
					case 7:
						obj.searchPersonByState();
						break;
					case 8:
						obj.viewPersonByCity();
						break;
					case 9:
						obj.viewPersonByState();
						break;
					case 10:
						obj.countByCity();
						break;
					case 11:
						obj.countByState();
						break;
					case 12:
						obj.sortByNameCityStateZip();
						break;
					case 13:
						fileObj.writeContactsIntoTextFile();
						break;
					case 14:
						fileObj.readContactsFromTextFile();
						break;
					case 15:
						fileObj.writeContactsIntoCSV();
						break;
					case 16:
						fileObj.readContactsFromCSV();
						break;
					case 17:
						fileObj.writeContactsIntoJSON_File();
						break;
					case 18:
						fileObj.readContactsFromJSON_File();
						break;
					default:
						System.out.println("Enter valid choice from the list...");
					}
					if (userChoice == 19) {
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
