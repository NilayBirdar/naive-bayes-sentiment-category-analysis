package com.naive.bayes.app.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;

import twitter4j.Twitter;
import twitter4j.TwitterFactory;
import twitter4j.conf.ConfigurationBuilder;

@Service
public class TwitterConfiguration {
	

	
	public Twitter getTwitter() {
			ConfigurationBuilder cb = new ConfigurationBuilder();
			cb.setDebugEnabled(true)
			.setOAuthConsumerKey("4cQdmDoVxwKAuipaJ2SiKGBgx")
			.setOAuthConsumerSecret("auOy2AoGKhUt9Ff6W7h70IV2z9GQ6HN3tc6u4AepZoUqfVWMcE")
			.setOAuthAccessToken("956168550984511491-XfHY0RdgkUf7cUfX3Tgjvpu3quHT5CS")
			.setOAuthAccessTokenSecret("snvJq1zHQ5ZJsvoylPDsO0yAvDFngVTmspvOkzOKWrKq2" );
			TwitterFactory tf = new TwitterFactory(cb.build());
			Twitter twitter = tf.getInstance();
			return twitter;
	}
}
