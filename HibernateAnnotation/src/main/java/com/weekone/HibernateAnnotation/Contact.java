package com.weekone.HibernateAnnotation;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "contact")
public class Contact {

	@Id
	@GeneratedValue
	@Column(name = "id")
	private int id;

	@Column(name = "st_adr", length = 120)
	private String street_adr;

	@Column(name = "city", length = 60)
	private String city;

	@Column(name = "state", length = 50)
	private String state;

	@Column(name = "country", length = 40)
	private String country;

	@Column(name = "cell_num", length = 11)
	private String cell_num;

	@Column(name = "email_adr", length = 80)
	private String email_adr;

	public int getid() {
		return id;
	}
	
	public void setid(int id) {
		this.id=id;
	}
	
	
	public String getStreet_adr() {
		return street_adr;
	}

	public void setStreet_adr(String street_adr) {
		this.street_adr = street_adr;
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

	public String getCell_num() {
		return cell_num;
	}

	public void setCell_num(String cell_num) {
		this.cell_num = cell_num;
	}

	public String getEmail_adr() {
		return email_adr;
	}

	public void setEmail_adr(String email_adr) {
		this.email_adr = email_adr;
	}

}
