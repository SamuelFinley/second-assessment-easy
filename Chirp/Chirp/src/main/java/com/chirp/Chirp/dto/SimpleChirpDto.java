package com.chirp.Chirp.dto;




public class SimpleChirpDto {
	private UserDto author;
	private Long posted;
	private String content;
	private Boolean visible;
	
	public SimpleChirpDto() {
		// TODO Auto-generated constructor stub
	}
	
	public SimpleChirpDto(UserDto author, Long posted, String content, Boolean visible) {
		super();
		this.author = author;
		this.posted = posted;
		this.content = content;
		this.visible = visible;
	}

	public Boolean getVisible() {
		return visible;
	}

	public void setVisible(Boolean visible) {
		this.visible = visible;
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
	
}
