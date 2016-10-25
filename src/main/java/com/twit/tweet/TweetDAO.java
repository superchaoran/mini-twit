package com.twit.tweet;

import java.util.List;

import com.twit.tweet.TweetModel;

public interface TweetDAO {

    int create(TweetModel tweet);
    List<TweetModel> searchTweets(String search);
    List<TweetModel> searchUserTweets(String username, String search);
}