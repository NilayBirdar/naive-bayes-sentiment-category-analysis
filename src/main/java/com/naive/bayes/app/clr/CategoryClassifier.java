package com.naive.bayes.app.clr;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.naive.bayes.app.entities.Tweet;
import com.naive.bayes.app.service.TwitterService;

import de.daslaboratorium.machinelearning.classifier.Classifier;
import de.daslaboratorium.machinelearning.classifier.bayes.BayesClassifier;
@Component

public class CategoryClassifier {
	private Classifier<String, String> categoryBayes = new BayesClassifier<String, String>();

	@Autowired
	private TwitterService twitterService;

	@PostConstruct
	public void categoryBayes() {

		List<String> kapsamdısı = new ArrayList<>();
		List<Tweet> tweetListKapsamdısı = twitterService.getTweetbyKategoriIdAndCategoryProgrammatic(0,0);
		for (Tweet tweet : tweetListKapsamdısı) {
			kapsamdısı.addAll(Arrays.asList(tweet.getTweetText().split("\\s")));
		}
		List<String> ekonomi = new ArrayList<>();
		List<Tweet> tweetListEkonomi = twitterService.getTweetbyKategoriIdAndCategoryProgrammatic(1,0);
		for (Tweet tweet : tweetListEkonomi) {
			ekonomi.addAll(Arrays.asList(tweet.getTweetText().split("\\s")));
		}
		List<String> spor = new ArrayList<>();
		List<Tweet> tweetListSpor = twitterService.getTweetbyKategoriIdAndCategoryProgrammatic(2,0);
		for (Tweet tweet : tweetListSpor) {
			spor.addAll(Arrays.asList(tweet.getTweetText().split("\\s")));
		}
		List<String> eglence = new ArrayList<>();
		List<Tweet> tweetListEglence = twitterService.getTweetbyKategoriIdAndCategoryProgrammatic(3,0);
		for (Tweet tweet : tweetListEglence) {
			eglence.addAll(Arrays.asList(tweet.getTweetText().split("\\s")));
		}
		List<String> siyaset = new ArrayList<>();
		List<Tweet> tweetListSiyaset = twitterService.getTweetbyKategoriIdAndCategoryProgrammatic(4,0);
		for (Tweet tweet : tweetListSiyaset) {
			siyaset.addAll(Arrays.asList(tweet.getTweetText().split("\\s")));
		}
		List<String> sanat = new ArrayList<>();
		List<Tweet> tweetListSanat = twitterService.getTweetbyKategoriIdAndCategoryProgrammatic(5,0);
		for (Tweet tweet : tweetListSanat) {
			sanat.addAll(Arrays.asList(tweet.getTweetText().split("\\s")));
		}
		List<String> egitim = new ArrayList<>();
		List<Tweet> tweetListEgitim = twitterService.getTweetbyKategoriIdAndCategoryProgrammatic(6,0);
		for (Tweet tweet : tweetListEgitim) {
			egitim.addAll(Arrays.asList(tweet.getTweetText().split("\\s")));
		}
		List<String> elestiri = new ArrayList<>();
		List<Tweet> tweetListElestiri = twitterService.getTweetbyKategoriIdAndCategoryProgrammatic(7,0);
		for (Tweet tweet : tweetListElestiri) {
			elestiri.addAll(Arrays.asList(tweet.getTweetText().split("\\s")));
		}
		List<String> bilim = new ArrayList<>();
		List<Tweet> tweetListBilim = twitterService.getTweetbyKategoriIdAndCategoryProgrammatic(8,0);
		for (Tweet tweet : tweetListBilim) {
			bilim.addAll(Arrays.asList(tweet.getTweetText().split("\\s")));
		}
		categoryBayes.learn("0", kapsamdısı);
		categoryBayes.learn("1", ekonomi);
		categoryBayes.learn("2", spor);
		categoryBayes.learn("3", eglence);
		categoryBayes.learn("4", siyaset);
		categoryBayes.learn("5", sanat);
		categoryBayes.learn("6", egitim);
		categoryBayes.learn("7", elestiri);
		categoryBayes.learn("8", bilim);
		
		System.err.println("categoryBayes IS DONE !!!!!!!!");
	
	}
	public List<Tweet> categoryClassify(List<Tweet> tweetListCategorized) {
		for (Tweet tweet : tweetListCategorized) {
			String[] notCategorizedText = tweet.getTweetText().split("\\s");
			String category = categoryBayes.classify(Arrays.asList(notCategorizedText)).getCategory();
			tweet.setCategoryProgrammatic(1);
			tweet.setKategoriId(Integer.parseInt(category));
			System.err.println(tweet.toString());
			twitterService.save(tweetListCategorized);
			
		}
		
		return tweetListCategorized;
}
}
