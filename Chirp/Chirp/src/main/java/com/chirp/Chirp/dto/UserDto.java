package com.chirp.Chirp.dto;

import javax.persistence.Embeddable;

import org.springframework.beans.factory.annotation.Required;


@Embeddable
public class UserDto {
	
	private String username;
	private ProfileDto profile;
	private Long joined;
	
	public UserDto() {
		// TODO Auto-generated constructor stub
	}
	
	public UserDto(String username, ProfileDto profile, Long joined) {
		super();
		this.username = username;
		this.joined = joined;
		this.profile = profile;
	}

	public String getUsername() {
		return username;
	}

	@Required
	public void setUsername(String username) {
		this.username = username;
	}

	public ProfileDto getProfile() {
		return profile;
	}
	
	@Required
	public void setProfile(ProfileDto profile) {
		this.profile = profile;
	}

	public Long getJoined() {
		return joined;
	}

	@Required
	public void setJoined(Long joined) {
		this.joined = joined;
	}
	
}
