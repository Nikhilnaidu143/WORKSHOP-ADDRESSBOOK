package com.workshop.addressbook.entity;

public class Contact {

	/** Instance variables. **/
	String first_name;
	String last_name;
	String address;
	String city;
	String state;
	int zip_code;
	long phone_number;
	String email;
	
	/** Parameterized Constructor. **/
	public Contact(String first_name, String last_name, String address, String city, String state, int zip_code,
			long phone_number, String email) {
		
		this.first_name = first_name;
		this.last_name = last_name;
		this.address = address;
		this.city = city;
		this.state = state;
		this.zip_code = zip_code;
		this.phone_number = phone_number;
		this.email = email;
	}
	
	@Override
	public String toString() {
		return String.format("\nFirst_name :- " + first_name + "\n" + "Last_name :- " + last_name + "\n"
				+ "Address :- " + address + "\n" + "City :- " + city + "\n" + "State :- " + state + "\n"
				+ "Zip-code :- " + zip_code + "\n" + "Phone-number :- " + phone_number + "\n" + "Email :- "
				+ email + "\n\n");
	}
}
