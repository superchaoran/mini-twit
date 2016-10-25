

package com.twit.tweet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import java.util.List;

@Controller
public class TweetController {

    @Autowired
    private TweetDAO tweetDAO;
    
    
//    @RequestMapping(value = "/tweet/create", method = RequestMethod.GET)
//    @ResponseBody
//    public ResponseEntity createTweet() {
//            return ResponseEntity.ok("{\"message\": \"Success!\"}");
//    }
    
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                            
    // NEW TWEET
    @SuppressWarnings("rawtypes")
	@RequestMapping(value = "/tweet/create", method = RequestMethod.POST, produces = {"application/json","application/xml"})
    @ResponseBody
    public ResponseEntity createTweet(@ModelAttribute("tweetForm") TweetModel tweet) {
    	System.out.println("here");
        int result = tweetDAO.create(tweet);
        if (result == 1) {
            return ResponseEntity.ok("{\"message\": \"Success!\"}");
        }
        else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"message\": \"Error!\"}");
        }
    }
        

    // GET TWEETS OF A USER
    @RequestMapping(value = "/tweets/{username}/formatted", method = RequestMethod.GET)
    @ResponseBody
    public ModelAndView tweetsUser(ModelAndView model, @PathVariable String username, @RequestParam(value = "search", defaultValue = "", required=false) String search) {
        List<TweetModel> listTweets = tweetDAO.searchUserTweets(username, search);
        model.addObject("listTweets", listTweets);
        model.addObject("username", username);
        model.addObject("search", search);
        model.setViewName("tweets/tweetsPage");
        return model;
    }

    // GET TWEETS OF A USER AS JSON AND XML
    @RequestMapping(value = "/tweets/{username}", method = RequestMethod.GET, produces = {"application/json","application/xml"})
    @ResponseBody
    public List<TweetModel> tweetsUser_XML_JSON(@PathVariable String username, @RequestParam(value = "search", defaultValue = "", required=false) String search) {
        List<TweetModel> listTweets = tweetDAO.searchUserTweets(username, search);
        return listTweets;
    }
}