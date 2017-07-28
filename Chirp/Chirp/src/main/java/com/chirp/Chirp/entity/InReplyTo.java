package com.chirp.Chirp.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class InReplyTo {
	
	@Id
	@GeneratedValue
	private Integer id;
	
	private Integer chirp;
	private Integer replyChirp;
	
	
	public InReplyTo() {
		// TODO Auto-generated constructor stub
	}
	
	public InReplyTo(Integer chirp, Integer replyChirp) {
		super();
		this.chirp = chirp;
		this.replyChirp = replyChirp;
	}

	public Integer getChirp() {
		return chirp;
	}

	public void setChirp(Integer chirp) {
		this.chirp = chirp;
	}

	public Integer getReplyChirp() {
		return replyChirp;
	}

	public void setReplyChirp(Integer replyChirp) {
		this.replyChirp = replyChirp;
	}
	
}
