package com.naive.bayes.app.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.naive.bayes.app.clr.SentimentClassifier;
import com.naive.bayes.app.service.TwitterService;

@Component
public class NBTester implements CommandLineRunner{

	@Autowired
	TwitterService tservice;
	
	@Autowired
	SentimentClassifier ms;
	
	@Override
	public void run(String... arg0) throws Exception {
		System.err.println("****************NB Tester has started");
		ms.sentimentClassify(tservice.getNotSentimentDesicionTweets());
		System.err.println("****************NB Tester has finished");
		
	}

}
