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

	@Column(name = "name")
	private String name;

	@Column(name = "email_address")
	private String emailAdress;

	@Column(name = "time_zone")
	private String timeZone;
	
	@OneToMany(mappedBy="account")
	private List<Contact> contacts = new ArrayList<Contact>();

	public Account() {

	}

	public Account(String name, String emailAdress, String timeZone) {
		this.name = name;
		this.emailAdress = emailAdress;
		this.timeZone = timeZone;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmailAdress() {
		return emailAdress;
	}

	public void setEmailAdress(String emailAdress) {
		this.emailAdress = emailAdress;
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
		return "Account [id=" + id + ", name=" + name + ", emailAdress=" + emailAdress + ", timeZone=" + timeZone + "]";
	}

	
}
