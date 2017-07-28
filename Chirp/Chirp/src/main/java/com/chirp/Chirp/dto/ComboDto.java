package com.chirp.Chirp.dto;

import javax.persistence.Embedded;

public class ComboDto {
	
	@Embedded
	private ProfileDto profileDto;
	@Embedded
	private CredentialsDto credentialsDto;
	
	public ComboDto() {
		// TODO Auto-generated constructor stub
	}
	
	public ComboDto(ProfileDto profileDto, CredentialsDto credentialsDto) {
		super();
		this.profileDto = profileDto;
		this.credentialsDto = credentialsDto;
	}

	public ProfileDto getProfileDto() {
		return profileDto;
	}

	public void setProfileDto(ProfileDto profileDto) {
		this.profileDto = profileDto;
	}

	public CredentialsDto getCredentialsDto() {
		return credentialsDto;
	}

	public void setCredentialsDto(CredentialsDto credentialsDto) {
		this.credentialsDto = credentialsDto;
	}
	
}
