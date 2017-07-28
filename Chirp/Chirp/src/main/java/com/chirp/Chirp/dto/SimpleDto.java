package com.chirp.Chirp.dto;

import javax.persistence.Embedded;

public class SimpleDto {
	
	private String content;
	
	@Embedded
	private CredentialsDto credentialsDto;
	
	public SimpleDto() {
		// TODO Auto-generated constructor stub
	}
	
	public SimpleDto(String content, CredentialsDto credentialsDto) {
		super();
		this.content = content;
		this.credentialsDto = credentialsDto;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public CredentialsDto getCredentialsDto() {
		return credentialsDto;
	}

	public void setCredentialsDto(CredentialsDto credentialsDto) {
		this.credentialsDto = credentialsDto;
	}
}
