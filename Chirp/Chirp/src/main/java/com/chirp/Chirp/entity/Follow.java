package com.chirp.Chirp.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Follow {
	@Id
	@GeneratedValue
	private Integer id;
	private Integer follows;
	private Integer followedBy;
	private Boolean isFollowing;
	private Long time;
	
	public Follow() {
		// TODO Auto-generated constructor stub
	}
	
	public Follow(Integer follows, Integer followedBy, Boolean isFollowing, Long time) {
		super();
		this.followedBy = followedBy;
		this.follows = follows;
		this.isFollowing = isFollowing;
		this.time = time;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getFollows() {
		return follows;
	}

	public void setFollows(Integer follows) {
		this.follows = follows;
	}

	public Integer getFollowedBy() {
		return followedBy;
	}

	public void setFollowedBy(Integer followedBy) {
		this.followedBy = followedBy;
	}

	public Boolean getIsFollowing() {
		return isFollowing;
	}

	public void setIsFollowing(Boolean isFollowing) {
		this.isFollowing = isFollowing;
	}

	public Long getTime() {
		return time;
	}

	public void setTime(Long time) {
		this.time = time;
	}
	
}
