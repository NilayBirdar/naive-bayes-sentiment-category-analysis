package com.naive.bayes.app.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="keywords")
public class keywords {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="keyword_id")
	public Integer keywordId;
	@Column(name="keyword",nullable=false)
	private String keyword;
	
	public Integer getKeywordId() {
		return keywordId;
	}
	public void setKeywordId(Integer keywordId) {
		this.keywordId = keywordId;
	}
	public String getKeyword() {
		return keyword;
	}
	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
	@Override
	public String toString() {
		return "keywords [keywordId=" + keywordId + ", keyword=" + keyword + "]";
	}
	
}
