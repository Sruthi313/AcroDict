package com.Dict.demo;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table(name="Users")

public class Users 
{
	@Id
	private String emailID;
	private String password;
	
	public Users(String emailID, String password) {
		super();
		this.emailID = emailID;
		this.password = password;
	}
	
	public Users()
	{
		
	}

	public String getEmailID() {
		return emailID;
	}

	public void setEmailID(String emailID) {
		this.emailID = emailID;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "Users [emailID=" + emailID + ", password=" + password + "]";
	}
	
	
	
	
	

}
