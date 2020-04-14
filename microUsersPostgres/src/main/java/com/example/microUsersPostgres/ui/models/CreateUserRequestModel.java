package com.example.microUsersPostgres.ui.models;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class CreateUserRequestModel {

	@NotNull(message = "First name cannot be null")
	@Size(min = 2, message = "first name must be more than 2 characters")
	private String firstName;
	
	@NotNull(message = "Last name cannot be null")
	@Size(min = 2, message = "Last name must be more than 2 characters")
	private String lastName;
	
	@NotNull(message = "Password cannot be null")
	@Size(min = 8, max = 16, message = "Pasword must be between 8 and 16 characters")
	private String password;
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
