package com.naive.bayes.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.naive.bayes.app.clr.CategoryClassifier;
import com.naive.bayes.app.clr.SentimentClassifier;
import com.naive.bayes.app.entities.Tweet;
import com.naive.bayes.app.entities.TweetSearch;
import com.naive.bayes.app.service.TwitterService;

import twitter4j.TwitterException;


@Controller
@RequestMapping(value="/twitter")

public class TwitterController {
	@Autowired
	private TwitterService twitterService;

	@Autowired
	private SentimentClassifier sentimentClassifier;
	
	@Autowired
	private CategoryClassifier categoryClassifier;
	
    @GetMapping(value= {"/search"})
	 public String getSearchPage(Model model) {
		 model.addAttribute("tweetSearch", new TweetSearch());
	    return "search";
	}

	
	@PostMapping(value="/hashTag")
    public ModelAndView getTweets(@ModelAttribute TweetSearch search) throws TwitterException {
		
		ModelAndView view = new ModelAndView("tweetList");
		view.addObject("list", twitterService.getTweets(search.getSearchKeyword()));

		return view;
		
   }
	
	@GetMapping(value="/kararver")
    public ModelAndView getNotDecidedTweets() throws TwitterException {
		
		ModelAndView view = new ModelAndView("kararver");
		view.addObject("list", twitterService.getNotSentimentAndNotCategorizedTweets());

		return view;
		
   }
	@GetMapping(value="/delete/{tweetId}")
	public ModelAndView deleteTweet(@PathVariable("tweetId")Integer tweetId) {
	    twitterService.deleteTweet(tweetId);
	    ModelAndView view = new ModelAndView("redirect:/twitter/kararver");
	    return view;
	}
	
	
	@GetMapping(value="/duygukarar/{tweetId}")
	public ModelAndView getWillSentimentDecisionTweets(@PathVariable("tweetId")Integer tweetId) throws TwitterException{
		ModelAndView view = new ModelAndView("duygukarar");
		view.addObject("tweet", twitterService.getTweetbyId(tweetId));
		
		return view;
	}
	
	@PostMapping(value="/duygukarar")
	public ModelAndView makeSentimentDecisionTweets(@ModelAttribute Tweet tweet) throws TwitterException{
		
		twitterService.makeSentimentDecisionTweets(tweet.getTweetId(), tweet.getDuyguId());
		
		System.err.println(tweet.toString());
		
		ModelAndView view = new ModelAndView("redirect:/twitter/kararver");
				
		return view;
	}
	
	@GetMapping(value="/kategorikarar/{tweetId}")
	public ModelAndView getWillCategorizeTweets(@PathVariable("tweetId")Integer tweetId) throws TwitterException{
		ModelAndView view = new ModelAndView("kategorikarar");
		view.addObject("tweet", twitterService.getTweetbyId(tweetId));
		
		return view;
	}
	
	@PostMapping(value="/kategorikarar")
	public ModelAndView makeCategorizedTweets(@ModelAttribute Tweet tweet) throws TwitterException{
		
		twitterService.makeCategorizedTweets(tweet.getTweetId(), tweet.getKategoriId());
		
		System.err.println(tweet.toString());
		
		ModelAndView view = new ModelAndView("redirect:/twitter/kararver");
				
		return view;
	}
	
	@GetMapping(value="/analiz")
    public ModelAndView getClassifiedTweets(){

		List<Tweet> tweetsSentiment = twitterService.getTweetbyDuyguId(-2);
		List<Tweet> newList = sentimentClassifier.sentimentClassify(tweetsSentiment);
		List<Tweet> tweetsCategorize = twitterService.getTweetbyKategoriId(-1);
		List<Tweet> newList2 = categoryClassifier.categoryClassify(tweetsCategorize);
		
		ModelAndView view = new ModelAndView("analiz");
		view.addObject("list", twitterService.getTweetbySentimentProgrammaticOrCategoryProgrammatic(1,1) );
		return view;
		
   }
	@GetMapping(value="/duygudegistir/{tweetId}")
	public ModelAndView getSentimentDecisionedTweet(@PathVariable("tweetId")Integer tweetId) throws TwitterException{
		ModelAndView view = new ModelAndView("yeniduygu");
		view.addObject("tweet", twitterService.getTweetbyId(tweetId));
		
		return view;
	}
	@PostMapping(value="/duygudegistir")
	public ModelAndView changeSentimentDecisionTweets(@ModelAttribute Tweet tweet) throws TwitterException{
		
		twitterService.changeSentimentDecisionTweets(tweet.getTweetId(), tweet.getDuyguId());
		
		System.err.println(tweet.toString());
		
		ModelAndView view = new ModelAndView("redirect:/twitter/analiz");
				
		return view;
	}
	@GetMapping(value="/kategoridegistir/{tweetId}")
	public ModelAndView getCategorizedTweet(@PathVariable("tweetId")Integer tweetId) throws TwitterException{
		ModelAndView view = new ModelAndView("yenikategori");
		view.addObject("tweet", twitterService.getTweetbyId(tweetId));
		
		return view;
	}
	@PostMapping(value="/kategoridegistir")
	public ModelAndView changeCategoriDecisionTweets(@ModelAttribute Tweet tweet) throws TwitterException{
		
		twitterService.changeCategoryDecisionTweets(tweet.getTweetId(), tweet.getKategoriId());
		
		System.err.println(tweet.toString());
		
		ModelAndView view = new ModelAndView("redirect:/twitter/analiz");
				
		return view;
	}
	
	@GetMapping(value="/deleteanaliz/{tweetId}")
	public ModelAndView deleteAnalizedTweet(@PathVariable("tweetId")Integer tweetId) {
	    twitterService.deleteTweet(tweetId);
	    ModelAndView view = new ModelAndView("redirect:/twitter/analiz");
	    return view;
	}
	
	@GetMapping(value="/grafikler")
	public ModelAndView getGraphics() {
		
	    ModelAndView view = new ModelAndView("grafikler");
	    return view;
	}
	
	@GetMapping(value="/hakkimda")
	public ModelAndView getAboutMe() {
		
	    ModelAndView view = new ModelAndView("hakkimda");
	    return view;
	}
	
	
	
	
}

