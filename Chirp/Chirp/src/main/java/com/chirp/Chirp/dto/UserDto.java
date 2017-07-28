package com.chirp.Chirp.dto;

import org.springframework.beans.factory.annotation.Required;

import com.chirp.Chirp.entity.Profile;

public class UserDto {
	
	private String username;
	private Profile profile;
	private Long joined;
	
	public UserDto() {
		// TODO Auto-generated constructor stub
	}
	
	public UserDto(String username, Profile profile, Long joined) {
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

	public Profile getProfile() {
		return profile;
	}
	
	@Required
	public void setProfile(Profile profile) {
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
