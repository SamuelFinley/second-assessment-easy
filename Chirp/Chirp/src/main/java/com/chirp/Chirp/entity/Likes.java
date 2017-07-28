package com.chirp.Chirp.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Likes {
	@Id
	@GeneratedValue
	private Integer id;
	
	private Integer chirpId;
	private Integer userId;
	
	
	public Likes() {
		// TODO Auto-generated constructor stub
	}
	
	public Likes(Integer chirpId, Integer userId) {
		super();
		this.chirpId = chirpId;
		this.userId = userId;
	}

	public Integer getChirpId() {
		return chirpId;
	}

	public void setChirpId(Integer chirpId) {
		this.chirpId = chirpId;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	
}
