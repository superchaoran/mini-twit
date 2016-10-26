

package com.twit.tweet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

@Controller
public class TweetController {

    @Autowired
    private TweetDAO tweetDAO;
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                            
    // CREATE TWEET
    @SuppressWarnings("rawtypes")
	@RequestMapping(value = "/tweet/create", method = RequestMethod.POST, produces = {"application/json","application/xml"})
    @ResponseBody
    public ResponseEntity createTweet(@ModelAttribute("tweetForm") TweetModel tweet, HttpServletRequest request) {
    	int userId = (int) request.getSession().getAttribute("userId");
    	tweet.setId(userId);
    	//System.out.println("here"+ userId);
        int result = tweetDAO.create(new TweetModel(tweet.getTweet(),userId));
        if (result == 1) {
            return ResponseEntity.ok("{\"message\": \"Success!\"}");
        }
        else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"message\": \"Error!\"}");
        }
    }
        

    // GET TWEETS OF A USER
    @RequestMapping(value = "/tweets/{user_id}/formatted", method = RequestMethod.GET)
    @ResponseBody
    public ModelAndView tweetsUser(ModelAndView model, @PathVariable int user_id, @RequestParam(value = "search", defaultValue = "", required=false) String search) {
        List<TweetModel> list = tweetDAO.searchUserTweets(user_id, search);
        model.addObject("listTweets", list);
        model.addObject("user_id", user_id);
        model.addObject("search", search);
        model.setViewName("tweets/tweetsPage");
        return model;
    }

    // GET TWEETS OF A USER AS JSON AND XML
    @RequestMapping(value = "/tweets/{username}", method = RequestMethod.GET, produces = {"application/json","application/xml"})
    @ResponseBody
    public List<TweetModel> tweetsUser_XML_JSON(@PathVariable int user_id, @RequestParam(value = "search", defaultValue = "", required=false) String search) {
        List<TweetModel> listTweets = tweetDAO.searchUserTweets(user_id, search);
        return listTweets;
    }
}