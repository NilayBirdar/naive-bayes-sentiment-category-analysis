package com.naive.bayes.app.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import twitter4j.TweetEntity;
import twitter4j.Twitter;

@Entity
@Table(name="tweetler")
public class Tweet {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="tweet_id")
	private Integer tweetId;
	@Column(name="keyword_id")
	public Integer keywordId;
	@Column(name="userName",nullable=false)
	private String userName;
	@Column(name="tweetText",nullable=false)
	private String tweetText;
	@Column
	private Long twitterId;
	
	private Integer duyguId;	
	private Integer sentimentProgrammatic;
	private Integer categoryProgrammatic;
	
	public Integer getCategoryProgrammatic() {
		return categoryProgrammatic;
	}
	public void setCategoryProgrammatic(int categoryProgrammatic) {
		this.categoryProgrammatic = categoryProgrammatic;
	}
	@Column(name="kategori_id")
	public Integer kategoriId;
	
	public Integer getKategoriId() {
		return kategoriId;
	}
	public void setKategoriId(Integer kategoriId) {
		this.kategoriId = kategoriId;
	}
	public Integer getTweetId() {
		return tweetId;
	}
	public void setTweetId(Integer tweetId) {
		this.tweetId = tweetId;
	}
	public Integer getDuyguId() {
		return duyguId;
	}
	public Integer getSentimentProgrammatic() {
		return sentimentProgrammatic;
	}
	public void setSentimentProgrammatic(int programmatic) {
		this.sentimentProgrammatic = programmatic;
	}
	public Tweet() {
		super();
	}
	public Tweet(String userName, String tweetText) {
		super();
		this.userName = userName;
		this.tweetText = tweetText;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getTweetText() {
		return tweetText;
	}
	public void setTweetText(String tweetText) {
		this.tweetText = tweetText;
	}
	public void setDuyguId(Integer duyguId) {
		this.duyguId = duyguId;
	}
	
	
	
	public Long getTwitterId() {
		return twitterId;
	}
	public void setTwitterId(Long twitterId) {
		this.twitterId = twitterId;
	}
	@Override
	public String toString() {
		return "Tweet [tweetId=" + tweetId + ", userName=" + userName + ", tweetText=" + tweetText + ", duyguId=" + duyguId
				+ ", sentimentProgrammatic=" + sentimentProgrammatic + "]";
	}

}
