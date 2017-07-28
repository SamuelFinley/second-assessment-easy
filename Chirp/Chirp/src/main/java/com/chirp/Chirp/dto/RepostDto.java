package com.chirp.Chirp.dto;


public class RepostDto {
	private UserDto author;
	private Long posted;
	private GeneralChirpDto repostOf;
	
	public RepostDto() {
		// TODO Auto-generated constructor stub
	}
	
	public RepostDto( UserDto author, Long posted, GeneralChirpDto repostOf) {
		super();
		this.author = author;
		this.posted = posted;
		this.repostOf = repostOf;
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

	public GeneralChirpDto getRepostOf() {
		return repostOf;
	}

	public void setRepostOf(GeneralChirpDto repostOf) {
		this.repostOf = repostOf;
	}
}
