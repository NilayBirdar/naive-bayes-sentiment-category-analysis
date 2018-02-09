package com.naive.bayes.app.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.social.TwitterAutoConfiguration;
import org.springframework.stereotype.Service;

import com.naive.bayes.app.clr.SentimentClassifier;
import com.naive.bayes.app.config.TwitterConfiguration;
import com.naive.bayes.app.dao.TwitterDao;
import com.naive.bayes.app.entities.Tweet;

import twitter4j.Query;
import twitter4j.QueryResult;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterAPIConfiguration;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.api.HelpResources.Language;

@Service
public class TwitterService {

	@Autowired
	TwitterDao twitterDao;

	@Autowired
	private TwitterConfiguration twitterConfiguration;
	
	@Autowired
	private SentimentClassifier sentimentClassifier;

	public List<Tweet> getTweets(String searchKeyword) throws TwitterException {
		List<Tweet> tweetList = new ArrayList<>();
		Twitter twitter = twitterConfiguration.getTwitter();
		Query filteredquery = new Query(searchKeyword + " -https");
		filteredquery.setLang("tr");
		filteredquery.setCount(100);
		QueryResult result = twitter.search(filteredquery);
		List<Tweet> tweets = new ArrayList<>();
		for (Status status : result.getTweets()) {
			Tweet tweet;

			Tweet _tweet = twitterDao.findByTwitterId(status.getId());
			if (_tweet != null)
				continue;
//			System.err.println(status.getUser().getName());
			if (status.getRetweetedStatus() == null) {
				tweet = new Tweet(status.getUser().getScreenName(), status.getText());
				tweetList.add(tweet);
				System.out.println("@" + status.getUser().getScreenName() + ":" + status.getText());
			} else {
				tweet = new Tweet(status.getRetweetedStatus().getUser().getScreenName(),
						status.getRetweetedStatus().getText());
				tweetList.add(tweet);

				System.out.println("@" + status.getUser().getScreenName() + ":" + status.getText());
			}
			tweet.setTwitterId(status.getId());
			tweet.setDuyguId(-2);
			tweet.setKategoriId(-1);
			tweet.setSentimentProgrammatic(0);
			tweet.setCategoryProgrammatic(0);
			if (!tweet.getTweetText().contains("http")) {
				try {
					tweets.add(tweet);
					System.err.println("TWEET Kaydedildi");
					twitterDao.save(tweet);
				} catch (Exception e) {
					System.err.println("I dont like emoji");
				}
			}
			System.err.println(tweet.toString());
		}

		return tweetList;
	}

	public List<Tweet> getNotSentimentDesicionTweets() {
		List<Tweet> kararVerilmemisler = twitterDao.findByDuyguId(-2);
		if (kararVerilmemisler == null) {
			kararVerilmemisler = new ArrayList<>();
		}
		return kararVerilmemisler;
	}

	public Tweet getTweetbyId(Integer tweetId) {
		return twitterDao.findOne(tweetId);
	}

	public Tweet makeSentimentDecisionTweets(Integer tweetId, Integer yeniduygu) {

		Tweet tweetwilldecision = twitterDao.findOne(tweetId);
		tweetwilldecision.setDuyguId(yeniduygu);
		Tweet decisionedtweet = twitterDao.save(tweetwilldecision);
		return decisionedtweet;

	}
	
	public List<Tweet> getTweetbyDuyguId(Integer duyguId) {
		return twitterDao.findByDuyguId(duyguId);

	}

	public List<Tweet> getTweetbyDuyguIdAndSentimentProgrammatic(Integer duyguId, Integer sentimentProgrammatic) {
		return twitterDao.findByDuyguIdAndSentimentProgrammatic(duyguId, sentimentProgrammatic);
	}
	
	public void deleteTweet(Integer tweetId) {
		twitterDao.delete(tweetId);
	}

	public void save(List<Tweet> newList) {
		twitterDao.save(newList);
		
	}

	public List<Tweet> getTweetbySentimentProgrammatic(Integer programmatic) {
		return twitterDao.findBySentimentProgrammatic(programmatic);
	}

	public Tweet changeSentimentDecisionTweets(Integer tweetId, Integer yeniduygu) {
		Tweet tweetwilldecision = twitterDao.findOne(tweetId);
		tweetwilldecision.setDuyguId(yeniduygu);
		tweetwilldecision.setSentimentProgrammatic(0);
		System.err.println(tweetwilldecision.toString());
		Tweet decisionChangedtweet = twitterDao.save(tweetwilldecision);
		return decisionChangedtweet;
		
	}

	public Tweet makeCategorizedTweets(Integer tweetId, Integer kategoriId) {
		Tweet tweetwillcategorize = twitterDao.findOne(tweetId);
		tweetwillcategorize.setKategoriId(kategoriId);
		Tweet categorizedtweet = twitterDao.save(tweetwillcategorize);
		return categorizedtweet;
		
	}

	public List<Tweet> getNotSentimentAndNotCategorizedTweets() {
		List<Tweet> kararVerilmemisVeKategorilenmemis = twitterDao.findByDuyguIdOrKategoriId(-2,-1);
		if (kararVerilmemisVeKategorilenmemis == null) {
			kararVerilmemisVeKategorilenmemis = new ArrayList<>();
		}
		return kararVerilmemisVeKategorilenmemis;
	}

	public Tweet changeCategoryDecisionTweets(Integer tweetId, Integer yenikategori) {
		Tweet tweetwillCategorydecision = twitterDao.findOne(tweetId);
		tweetwillCategorydecision.setKategoriId(yenikategori);
		tweetwillCategorydecision.setCategoryProgrammatic(0);
		System.err.println(tweetwillCategorydecision.toString());
		Tweet decisionChangedtweet = twitterDao.save(tweetwillCategorydecision);
		return decisionChangedtweet;
		
	}

	public List<Tweet> getTweetbyKategoriIdAndSentimentProgrammatic(Integer kategoriId, Integer sentimentProgrammatic) {
		 return twitterDao.findByKategoriIdAndSentimentProgrammatic(kategoriId,sentimentProgrammatic);
	}

	public List<Tweet> getTweetbyKategoriIdAndCategoryProgrammatic(Integer kategoriId, Integer  categoryProgrammatic) {
		 return twitterDao.findByKategoriIdAndCategoryProgrammatic(kategoriId,categoryProgrammatic);
	}

	public List<Tweet> getTweetbySentimentProgrammaticAndCategoryProgrammatic(Integer sentimentProgrammatic, Integer categoryProgrammatic) {
		
		return twitterDao.findBySentimentProgrammaticAndCategoryProgrammatic(sentimentProgrammatic,categoryProgrammatic);
	}

	public List<Tweet> getTweetbyKategoriId(Integer kategoriId) {
		
		return twitterDao.findByKategoriId(kategoriId);
	}

	public Object getTweetbySentimentProgrammaticOrCategoryProgrammatic(Integer sentimentProgrammatic, Integer categoryProgrammatic) {
		
		return twitterDao.findBySentimentProgrammaticOrCategoryProgrammatic(sentimentProgrammatic, categoryProgrammatic);
	}
		
}
