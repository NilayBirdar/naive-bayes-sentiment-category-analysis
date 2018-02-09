package com.naive.bayes.app.scheduling;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.naive.bayes.app.entities.Tweet;
import com.naive.bayes.app.entities.keywords;
import com.naive.bayes.app.service.TwitterService;

import twitter4j.TwitterException;

@Component
public class SearchSchedule {
	
	@Autowired
	TwitterService tservice;
	
//	@Scheduled(fixedRate = 30000) // every 30 seconds
//	public void Search() throws TwitterException {
//	
//		List<Tweet> scheduledTweets = tservice.getTweets("enes batur");		
//		System.err.println("scheduled task ile çekilen tweet sayısı ="+scheduledTweets.size());
//	}
}
