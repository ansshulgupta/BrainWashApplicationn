package com.BrainWash.model;

import java.util.Date;

public class SpellingBook {
	
	private Long id;	//AutoIncrement
	private String spellingName;
	private String spellingPronounce;	
	private String spellingMeaning;	
	private String createdBy;	
	private Date createdAt;	
	private String spellingStatus;
	

	//setters and getters
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getSpellingName() {
		return spellingName;
	}

	public void setSpellingName(String spellingName) {
		this.spellingName = spellingName;
	}

	public String getSpellingPronounce() {
		return spellingPronounce;
	}

	public void setSpellingPronounce(String spellingPronounce) {
		this.spellingPronounce = spellingPronounce;
	}

	public String getSpellingMeaning() {
		return spellingMeaning;
	}

	public void setSpellingMeaning(String spellingMeaning) {
		this.spellingMeaning = spellingMeaning;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public String getSpellingStatus() {
		return spellingStatus;
	}

	public void setSpellingStatus(String spellingStatus) {
		this.spellingStatus = spellingStatus;
	}
	
}
