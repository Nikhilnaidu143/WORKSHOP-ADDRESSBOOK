package com.workshop.addressbook.service;

import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

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
		
		for(int i = 0; i < stringAddressBook.length(); i++) {
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
		if(!Files.exists(path)) {
			System.out.println("OOPS! File is not there. Creating file....");
			writeContactsIntoTextFile();
		}
		
		FileInputStream fileInputStream = new FileInputStream("files/AddressBook.txt");
		int i = 0;
		while((i = fileInputStream.read()) != -1) {
			System.out.print((char)i);
		}
		fileInputStream.close();
	}
}
