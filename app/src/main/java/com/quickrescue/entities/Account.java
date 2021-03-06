package com.quickrescue.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "qr_account")
public class Account {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "name", length=50)
	private String name;

	@Column(name = "email_address", length=60)
	private String emailAddress;

	@Column(name = "time_zone", length=8)
	private String timeZone;
	
	@OneToMany(mappedBy="account")
	private List<Contact> contacts = new ArrayList<Contact>();

	public Account() {

	}

	public Account(String name, String emailAddress, String timeZone) {
		this.name = name;
		this.emailAddress = emailAddress;
		this.timeZone = timeZone;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public String getTimeZone() {
		return timeZone;
	}

	public void setTimeZone(String timeZone) {
		this.timeZone = timeZone;
	}

	
	public List<Contact> getContacts() {
		return contacts;
	}

	public void setContacts(List<Contact> contacts) {
		this.contacts = contacts;
	}

	@Override
	public String toString() {
		return "Account [id=" + id + ", name=" + name + ", emailAddress=" + emailAddress + ", timeZone=" + timeZone + "]";
	}

	
}
