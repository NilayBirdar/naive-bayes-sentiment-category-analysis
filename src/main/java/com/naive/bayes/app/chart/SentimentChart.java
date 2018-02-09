package com.naive.bayes.app.chart;

import java.util.List;

public class SentimentChart {
	
	private List<String> sentimentLabels;
	private List<Long> sentimentValues;
	private List<String> sentimentColors;
	
	public List<String> getSentimentLabels() {
		return sentimentLabels;
	}
	public void setSentimentLabels(List<String> sentimentLabels) {
		this.sentimentLabels = sentimentLabels;
	}
	public List<Long> getSentimentValues() {
		return sentimentValues;
	}
	public void setSentimentValues(List<Long> sentimentValues) {
		this.sentimentValues = sentimentValues;
	}
	public List<String> getSentimentColors() {
		return sentimentColors;
	}
	public void setSentimentColors(List<String> sentimentColors) {
		this.sentimentColors = sentimentColors;
	}
	
	

}
