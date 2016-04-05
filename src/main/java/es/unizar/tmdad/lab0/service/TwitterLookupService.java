package es.unizar.tmdad.lab0.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.social.twitter.api.*;
import org.springframework.social.twitter.api.impl.TwitterTemplate;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import org.springframework.messaging.simp.SimpMessageSendingOperations;

@Service
public class TwitterLookupService {
	@Value("${twitter.consumerKey}")
	private String consumerKey;
	
	@Value("${twitter.consumerSecret}")
	private String consumerSecret;
	
	@Value("${twitter.accessToken}")
	private String accessToken;
	
	@Value("${twitter.accessTokenSecret}")
	private String accessTokenSecret;

	@Autowired
	SimpMessageSendingOperations messaginTemplate;

	public void search(String query) {
        Twitter twitter = new TwitterTemplate(consumerKey, consumerSecret, accessToken, accessTokenSecret);
		List<StreamListener> list = new ArrayList<StreamListener>();
		list.add(new SimpleStreamListener(messaginTemplate,query));
		Stream s = twitter.streamingOperations().filter(query,list);

    }


}
