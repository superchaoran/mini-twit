package com.twit.tweet;

public class TweetModel {
    private int id;
    private String tweet;
    private String user_id;

    public TweetModel() {
    }

    public TweetModel(String tweet, String user_id) {
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

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
}