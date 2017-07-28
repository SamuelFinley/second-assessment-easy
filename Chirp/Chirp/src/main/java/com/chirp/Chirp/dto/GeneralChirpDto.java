package com.chirp.Chirp.dto;

import com.chirp.Chirp.entity.Chirp;

public class GeneralChirpDto {
	private UserDto author;
	private String content;
	private Long posted;
	private Chirp repostOf;
	private Chirp reply;

	public GeneralChirpDto() {
		// TODO Auto-generated constructor stub
	}
	
	public GeneralChirpDto( UserDto author, String content, Long posted, Chirp repostOf, Chirp reply) {
		super();
		this.author = author;
		this.content = content;
		this.posted = posted;
		this.repostOf = repostOf;
		this.reply = reply;
	}

	public UserDto getAuthor() {
		return author;
	}

	public void setAuthor(UserDto author) {
		this.author = author;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Long getPosted() {
		return posted;
	}

	public void setPosted(Long posted) {
		this.posted = posted;
	}

	public Chirp getRepostOf() {
		return repostOf;
	}

	public void setRepostOf(Chirp repostOf) {
		this.repostOf = repostOf;
	}

	public Chirp getReply() {
		return reply;
	}

	public void setReply(Chirp reply) {
		this.reply = reply;
	}
	
}
