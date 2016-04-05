package es.unizar.tmdad.lab0.controller;

import es.unizar.tmdad.lab0.service.TwitterLookupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class SearchController {

    @Autowired
    TwitterLookupService twitter;
    

    @RequestMapping("/search")
    public void search(String q) {
        twitter.search(q);
    }


}