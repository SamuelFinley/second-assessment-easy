package com.chirp.Chirp.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class RepostOf {
	@Id
	@GeneratedValue
	private Integer id;
	private Integer chirp;
	private Integer repostChirp;
	
	public RepostOf() {
		// TODO Auto-generated constructor stub
	}
	
	public RepostOf(Integer chirp, Integer repostChirp) {
		super();
		this.chirp = chirp;
		this.repostChirp = repostChirp;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getChirp() {
		return chirp;
	}

	public void setChirp(Integer chirp) {
		this.chirp = chirp;
	}

	public Integer getRepostChirp() {
		return repostChirp;
	}

	public void setRepostChirp(Integer repostChirp) {
		this.repostChirp = repostChirp;
	}
	
}
