package com.naive.bayes.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class SentimentCategoryAnalysisApp {
		
	public static void main(String[] args) {
		 SpringApplication.run(SentimentCategoryAnalysisApp.class, args);	    
	}
	

}
