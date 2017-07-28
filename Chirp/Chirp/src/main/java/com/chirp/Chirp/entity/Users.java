package com.chirp.Chirp.entity;

import java.sql.Timestamp;
import java.util.List;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Users {
	@Id
	@GeneratedValue
	private Integer id;
	
	@Embedded
	private Profile profile;
	private Boolean active;
	private String username;
	private String password;
	private Long joined;
	
	@OneToOne
	private Follow following;
	
	
	public Users() {
		// TODO Auto-generated constructor stub
	}
	
	public Users(Integer id, String username, String password, Long joined, Profile profile, Boolean active, Follow following, List<Integer> chirps, List<Integer> liked) {
		super();
		this.id = id;
		this.active = active;
		this.username = username;
		this.password = password;
		this.joined = joined;
		this.profile = profile;
		this.following = following;
	}
	
	public Follow getFollowing() {
		return following;
	}

	public void setFollowing(Follow following) {
		this.following = following;
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

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

	public Long getJoined() {
		return joined;
	}

	public void setJoined(Long joined) {
		this.joined = joined;
	}

	public Profile getProfile() {
		return profile;
	}

	public void setProfile(Profile profile) {
		this.profile = profile;
	}
	
}
