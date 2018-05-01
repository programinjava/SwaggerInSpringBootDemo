package com.programinjava.learn.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class User {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	
	private String username;
	private String password;
	private String firstname;
	private String lastname;
	private Integer mobilenumber;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public Integer getMobilenumber() {
		return mobilenumber;
	}
	public void setMobilenumber(Integer mobilenumber) {
		this.mobilenumber = mobilenumber;
	}
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	@Override
	public String toString() {
		return "User [username=" + username + ", password=" + password + ", firstname=" + firstname + ", lastname="
				+ lastname + ", mobilenumber=" + mobilenumber + "]";
	}
	
	

}
