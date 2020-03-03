package com.metacube.training.model.commands;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="user")
public class UserCommands {
	
	
	@Column(name="name")
	String username;
	
	@Id
	String email;
	
	
	String password;
	
	
	String role;
	
	
	boolean active;


	public String getuserName() {
		return username;
	}


	public void setuserName(String username) {
		this.username = username;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getRole() {
		return role;
	}


	public void setRole(String role) {
		this.role = role;
	}


	public boolean getActive() {
		return active;
	}


	public void setActive(boolean active) {
		this.active = active;
	}
	
	

}
