package com.twit.follow;

import java.util.List;

import com.twit.tweet.TweetModel;

public interface FollowDAO {

    int follow(FollowModel followModel);
    int unfollow(FollowModel followModel);
	List<Integer> listFollowing(int user_id);
	List<Integer> listFollowers(int user_id);
	List<UserModel> listAllUsers(int user_id);
	List<TweetModel> listAllFollowingTweets(int user_id);
}