package com.twit.tweet;

import java.util.Comparator;
import java.util.Date;

public class TweetModel{
    private int id;
    private String tweet;
    private int user_id;
    private Date date;
    
    public TweetModel() {
    }

    public TweetModel(String tweet, int user_id) {
        this.tweet = tweet;
        this.setUser_id(user_id);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTweet() {
        return tweet;
    }

    public void setTweet(String tweet) {
        this.tweet = tweet;
    }

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
	
}