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

	/** Getter and setter methods. **/
	public String getFirst_name() {
		return first_name;
	}
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getLast_name() {
		return last_name;
	}
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}

	public int getZip_code() {
		return zip_code;
	}
	public void setZip_code(int zip_code) {
		this.zip_code = zip_code;
	}

	public long getPhone_number() {
		return phone_number;
	}
	public void setPhone_number(long phone_number) {
		this.phone_number = phone_number;
	}

	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
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
