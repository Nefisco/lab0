package es.unizar.tmdad.lab0.controller;

import com.sun.xml.internal.ws.api.message.MessageHeaders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.social.twitter.api.SearchResults;
import org.springframework.social.twitter.api.Tweet;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.MimeTypeUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import es.unizar.tmdad.lab0.service.TwitterLookupService;
import org.springframework.web.bind.annotation.RestController;
import sun.net.www.MessageHeader;

import java.util.HashMap;
import java.util.Map;


//@Controller
@RestController
public class SearchController {

    @Autowired
    TwitterLookupService twitter;



    @RequestMapping("/search")
    public void search(String q) {
        twitter.search(q);
    }



    public void onTweet(Tweet tweet){

        Map<String,Object> map = new HashMap<String, Object>();
        map.put(MessageHeaders.CONTENT_TYPE, MimeTypeUtils.APPLICATION_JSON);
        ops.convertAn

    }
}