package es.unizar.tmdad.lab0.service;

import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.social.twitter.api.StreamDeleteEvent;
import org.springframework.social.twitter.api.StreamListener;
import org.springframework.social.twitter.api.StreamWarningEvent;
import org.springframework.social.twitter.api.Tweet;
import org.springframework.util.MimeTypeUtils;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Usuario on 31/03/2016.
 */
public class SimpleStreamListener implements StreamListener {
    private SimpMessageSendingOperations obj;
    private String name;

    public SimpleStreamListener(SimpMessageSendingOperations messaginTemplate, String query) {
        obj = messaginTemplate;
        name = query;
    }

    @Override
    public void onTweet(Tweet tweet) {
        Map<String,Object> map = new HashMap<String, Object>();
        map.put(MessageHeaders.CONTENT_TYPE, MimeTypeUtils.APPLICATION_JSON);
            obj.convertAndSend("queue/search/"+name,tweet,map);

        }

    @Override
    public void onDelete(StreamDeleteEvent deleteEvent) {

    }

    @Override
    public void onLimit(int numberOfLimitedTweets) {

    }

    @Override
    public void onWarning(StreamWarningEvent warningEvent) {

    }
}
