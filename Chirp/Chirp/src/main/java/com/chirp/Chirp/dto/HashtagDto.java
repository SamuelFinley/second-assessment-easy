package com.chirp.Chirp.dto;

import java.sql.Timestamp;

public class HashtagDto {
	private String label;
	private Timestamp firstUsed;
	private Timestamp lastUsed;
	
	public HashtagDto() {
		// TODO Auto-generated constructor stub
	}
	
	public HashtagDto(String label, Timestamp firstUsed, Timestamp lastUsed) {
		super();
		this.label = label;
		this.firstUsed = firstUsed;
		this.lastUsed = lastUsed;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public Timestamp getFirstUsed() {
		return firstUsed;
	}

	public void setFirstUsed(Timestamp firstUsed) {
		this.firstUsed = firstUsed;
	}

	public Timestamp getLastUsed() {
		return lastUsed;
	}

	public void setLastUsed(Timestamp lastUsed) {
		this.lastUsed = lastUsed;
	}
	
}
