package com.chirp.Chirp.entity;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import com.chirp.Chirp.dto.UserDto;

@Entity
public class Chirp {
	
	@Id
	@GeneratedValue
	private Integer id;
	
	private UserDto author;
	private String content;
	private Long posted;
	private Boolean visible;
	
	@OneToOne
	private Likes likes;
	
	@ManyToOne
	private Hashtag tag;
	
	@ManyToOne
	private RepostOf repostOf;
	
	@OneToOne
	private InReplyTo reply;

	public Chirp() {
		// TODO Auto-generated constructor stub
	}
	
	public Chirp(UserDto author, String content, Long posted, Boolean visible, Likes likes, Hashtag tag, RepostOf repostOf, InReplyTo reply) {
		super();
		this.author = author;
		this.content = content;
		this.posted = posted;
		this.visible = visible;
		this.likes = likes;
		this.tag = tag;
		this.repostOf = repostOf;
		this.reply = reply;
	}

	public Long getPosted() {
		return posted;
	}

	public void setPosted(Long posted) {
		this.posted = posted;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public Boolean getVisible() {
		return visible;
	}

	public void setVisible(Boolean visible) {
		this.visible = visible;
	}

	public Likes getLikes() {
		return likes;
	}

	public void setLikes(Likes likes) {
		this.likes = likes;
	}

	public Hashtag getTag() {
		return tag;
	}

	public void setTag(Hashtag tag) {
		this.tag = tag;
	}
	
	public RepostOf getRepostOf() {
		return repostOf;
	}

	public void setRepostOf(RepostOf repostOf) {
		this.repostOf = repostOf;
	}

	public InReplyTo getReply() {
		return reply;
	}

	public void setReply(InReplyTo reply) {
		this.reply = reply;
	}
	
}
