package com.chirp.Chirp.dto;

import javax.persistence.Embeddable;

import org.springframework.beans.factory.annotation.Required;
@Embeddable
public class CredentialsDto {
	private String username;
	private String password;
	
	public CredentialsDto() {
		// TODO Auto-generated constructor stub
	}
	
	public CredentialsDto(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	@Required
	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	@Required
	public void setPassword(String password) {
		this.password = password;
	}
}
