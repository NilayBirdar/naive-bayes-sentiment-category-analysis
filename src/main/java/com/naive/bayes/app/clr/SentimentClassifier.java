package com.naive.bayes.app.clr;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.naive.bayes.app.entities.Tweet;
import com.naive.bayes.app.service.TwitterService;

import de.daslaboratorium.machinelearning.classifier.Classifier;
import de.daslaboratorium.machinelearning.classifier.bayes.BayesClassifier;

@Component
public class SentimentClassifier {
	private Classifier<String, String> sentimentBayes = new BayesClassifier<String, String>();

	@Autowired
	private TwitterService twitterService;

	@PostConstruct
	public void sentimentBayes() {

		List<String> positiveWords = new ArrayList<>();
		List<Tweet> tweetListP = twitterService.getTweetbyDuyguIdAndSentimentProgrammatic(1,0);
		for (Tweet tweet : tweetListP) {
			positiveWords.addAll(Arrays.asList(tweet.getTweetText().split("\\s")));
		}
		List<String> negativeWords = new ArrayList<>();
		List<Tweet> tweetListE = twitterService.getTweetbyDuyguIdAndSentimentProgrammatic(-1,0);
		for (Tweet tweet : tweetListE) {
			negativeWords.addAll(Arrays.asList(tweet.getTweetText().split("\\s")));
		}
		List<String> notrWords = new ArrayList<>();
		List<Tweet> tweetListN = twitterService.getTweetbyDuyguIdAndSentimentProgrammatic(0,0);
		for (Tweet tweet : tweetListN) {
			notrWords.addAll(Arrays.asList(tweet.getTweetText().split("\\s")));
		}
		sentimentBayes.learn("1", positiveWords);
		sentimentBayes.learn("-1", negativeWords);
		sentimentBayes.learn("0", notrWords);
		System.err.println("sentimentBayes is DONE!!!!!!!!");
	
	}
	public List<Tweet> sentimentClassify(List<Tweet> tweetListSentimented) {
		for (Tweet tweet : tweetListSentimented) {
			String[] unknownText1 = tweet.getTweetText().split("\\s");
			String sentiment = sentimentBayes.classify(Arrays.asList(unknownText1)).getCategory();
			tweet.setSentimentProgrammatic(1);
			tweet.setDuyguId(Integer.parseInt(sentiment));
			System.err.println(tweet.toString());
			twitterService.save(tweetListSentimented);
			
		}
		
		return tweetListSentimented;

	}
	
	

}
