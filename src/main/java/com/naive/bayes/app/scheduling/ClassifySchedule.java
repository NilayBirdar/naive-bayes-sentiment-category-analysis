package com.naive.bayes.app.scheduling;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.naive.bayes.app.clr.SentimentClassifier;
import com.naive.bayes.app.entities.Tweet;
import com.naive.bayes.app.service.TwitterService;

@Component
public class ClassifySchedule {
	
	@Autowired
	TwitterService tservice;
	
	@Autowired
	SentimentClassifier ms;

//	@Scheduled(fixedRate = 600000)  // every 600 seconds
//	public void Classify() {
//		List<Tweet> tweets = tservice.getTweetbyKararAndProgrammatic(-2, 0);
//		List<Tweet> newList = ms.classifyAll(tweets);
//		tservice.save(newList);
//	}
}
