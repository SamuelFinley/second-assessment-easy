package com.chirp.Chirp.dto;

public class ReplyDto {
	private UserDto author;
	private Long posted;
	private String content;
	private GeneralChirpDto replyTo;
	
	public ReplyDto() {
		// TODO Auto-generated constructor stub
	}
	
	public ReplyDto(UserDto author, Long posted, String content, GeneralChirpDto replyTo) {
		super();
		this.author = author;
		this.posted = posted;
		this.replyTo = replyTo;
	}

	public UserDto getAuthor() {
		return author;
	}

	public void setAuthor(UserDto author) {
		this.author = author;
	}

	public Long getPosted() {
		return posted;
	}

	public void setPosted(Long posted) {
		this.posted = posted;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public GeneralChirpDto getReplyTo() {
		return replyTo;
	}

	public void setReplyTo(GeneralChirpDto replyTo) {
		this.replyTo = replyTo;
	}
	
}
