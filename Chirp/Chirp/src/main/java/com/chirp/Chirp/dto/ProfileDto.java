package com.chirp.Chirp.dto;

import javax.persistence.Embeddable;

import org.springframework.beans.factory.annotation.Required;
@Embeddable
public class ProfileDto {
	private String firstName;
	private String lastName;
	private String email;
	private String phone;
		
	public ProfileDto() {
		// TODO Auto-generated constructor stub
	}
	
	public ProfileDto(String firstName, String lastName, String email, String phone) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.phone = phone;
	}

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

	public String getEmail() {
		return email;
	}

	@Required
	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
	
}
