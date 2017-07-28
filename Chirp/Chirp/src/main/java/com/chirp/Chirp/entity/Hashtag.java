package com.chirp.Chirp.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


@Entity
public class Hashtag {
	@Id
	@GeneratedValue
	private Integer id;
	private String label;
	private Long timestamp;
	private Integer tweet;
	
	public Hashtag() {
		
	}
	
	public Hashtag(String label, Long timestamp, Integer tweet) {
		super();
		this.label = label;
		this.timestamp = timestamp;
		this.tweet = tweet;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public Long getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Long timestamp) {
		this.timestamp = timestamp;
	}

	public Integer getTweet() {
		return tweet;
	}

	public void setTweet(Integer tweet) {
		this.tweet = tweet;
	}
	
}
