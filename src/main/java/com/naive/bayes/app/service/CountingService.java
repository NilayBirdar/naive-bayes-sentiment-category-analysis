package com.naive.bayes.app.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.naive.bayes.app.clr.SentimentClassifier;
import com.naive.bayes.app.config.TwitterConfiguration;
import com.naive.bayes.app.dao.TwitterDao;
import com.naive.bayes.app.entities.Tweet;

@Service
public class CountingService {
	@Autowired
	TwitterService twitterService;
	
	@Autowired
	TwitterDao twitterDao;

	@Autowired
	private TwitterConfiguration twitterConfiguration;
	
	@Autowired
	private SentimentClassifier sentimentClassifier;
		
	
	public void getDataForDuygu()
	{
		 List<Object[]> result = twitterDao.findTweetCountByDuyguId();
		 Map<String,Long> map = null;
	       if(result != null && !result.isEmpty()){
	          map = new HashMap<String,Long>();
	          for (Object[] object : result) {
	        	  System.out.println(" count = " + (Long)object[1] + " duygu =" + object[0].toString());
	            map.put(object[0].toString() , (Long)object[1]);
	          }
	       }
		
	}
	public void getDataForKategori()
	{
		 List<Object[]> result = twitterDao.findTweetCountByKategoriId();
	       Map<String,Long> map = null;
	       if(result != null && !result.isEmpty()){
	          map = new HashMap<String,Long>();
	          for (Object[] object : result) {
	        	  System.out.println(" count = " + (Long)object[1] + " kategori =" + object[0].toString());
	            map.put(object[0].toString() , (Long)object[1]);
	          }
	       }
		
	}
	

}
