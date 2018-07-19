package com.quickrescue.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "qr_contact_address")
public class ContactAddress {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name = "street_address")
	private String streetAddress;

	@Column(name = "city")
	private String city;

	@Column(name = "state")
	private String state;

	@Column(name = "country")
	private String country;

//	If we assume each Contact has only 'one' address
	@OneToOne
	private Contact contact;

//  If we assume each Contact can have 'multiple' addresses
//	@ManyToOne
//	private List<Contact> contacts = new ArrayList<Contact>();

	public ContactAddress() {

	}

	public ContactAddress(String streetAddress, String city, String state, String country, Contact contact) {
		this.streetAddress = streetAddress;
		this.city = city;
		this.state = state;
		this.country = country;
		this.contact = contact;
	}

	public String getStreetAddress() {
		return streetAddress;
	}

	public void setStreetAddress(String streetAddress) {
		this.streetAddress = streetAddress;
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

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public Contact getContact() {
		return contact;
	}

	public void setContact(Contact contact) {
		this.contact = contact;
	}

//  For a many to one relation
//	public List<Contact> getContact() {
//		return contact;
//	}
//	
//	public void setContact(List<Contact> contact) {
//		this.contact = contact;
//	}

	@Override
	public String toString() {
		return "ContactAddress [streetAddress=" + streetAddress + ", city=" + city + ", state=" + state + ", country="
				+ country + "]";
	}

}
