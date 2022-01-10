package com.workshop.addressbook.service;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import com.opencsv.CSVWriter;

public class FileOperations {

	/***
	 * UC-13:- Ability to Read or Write the Address Book with Persons Contact into a
	 * File using File IO.
	 * 
	 * @throws IOException
	 ***/
	public void writeContactsIntoTextFile() throws IOException {
		/*** Writing into text file using FILE-IO. ***/
		FileWriter fileWriter = new FileWriter("files/AddressBook.txt");
		String stringAddressBook = AddressBook.addressBook.toString();

		for (int i = 0; i < stringAddressBook.length(); i++) {
			fileWriter.write(stringAddressBook.charAt(i));
		}
		fileWriter.close();
		System.out.println("Data Added into AddressBookIO.txt File.\n");
	}

	// reading contacts data from text file.
	public void readContactsFromTextFile() throws IOException {
		System.out.println("---------------READING FROM TEXT FILE--------------");

		/** Writing into file if file does not exist in system. **/
		Path path = Paths.get("files/AddressBook.txt");
		if (!Files.exists(path)) {
			System.out.println("OOPS! File is not there. Creating file....");
			writeContactsIntoTextFile();
		}

		FileInputStream fileInputStream = new FileInputStream("files/AddressBook.txt");
		int i = 0;
		while ((i = fileInputStream.read()) != -1) {
			System.out.print((char) i);
		}
		fileInputStream.close();
	}

	/**
	 * UC-14:- Ability to Read/Write the Address Book with Persons Contact as CSV
	 * File.
	 * 
	 * @throws IOException
	 **/
	public void writeContactsIntoCSV() throws IOException {
		List<String[]> stringAddressBook = new ArrayList<String[]>();

		PrintWriter printWriter = new PrintWriter("files/AddressBook.csv");

		CSVWriter csvWriter = new CSVWriter(printWriter);

		/*** Adding header to the csv file. ***/
		stringAddressBook.add(new String[] { "First_Name", "Last_Name", "Address", "City", "State", "Zip_Code",
				"Phone_Number", "E-Mail" });

		/*** Adding contacts into stringsAddressBook ***/
		AddressBook.addressBook.forEach(addressBook -> addressBook.contacts.stream().forEach(ad -> {
			stringAddressBook.add(
					new String[] { ad.getFirst_name(), ad.getLast_name(), ad.getAddress(), ad.getCity(), ad.getState(),
							Integer.toString(ad.getZip_code()), Long.toString(ad.getPhone_number()), ad.getEmail() });
		}));

		csvWriter.writeAll(stringAddressBook); // Writing contacts into AddressBook.csv file.
		csvWriter.close();

		System.out.println("Contacts are added to AddressBook.csv file successfully.");
	}

	// Reading from CSV.
	public void readContactsFromCSV() throws IOException {
		System.out.println("---------------READING FROM CSV FILE--------------");
		Path path = Paths.get("files/AddressBook.csv");
		if (!Files.exists(path)) {
			System.out.println("OOPS! CSV file is not there. Creating CSV file...");
			writeContactsIntoCSV();
		}

		BufferedReader bufferedReader = new BufferedReader(new FileReader("files/AddressBook.csv"));
		String line = "";
		while ((line = bufferedReader.readLine()) != null) {
			String[] contact = line.split(",");
			System.out.println("AddressBook [firstName=" + contact[0] + ", lastName=" + contact[1] + ", address="
					+ contact[2] + ", cityName=" + contact[3] + ", stateName=" + contact[4] + ", zip=" + contact[5]
					+ ", phoneNumber=" + contact[6] + "]");
		}
		bufferedReader.close();
	}
}
