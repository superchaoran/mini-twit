package com.twit.follow;

import java.util.List;

public interface FollowDAO {

    int follow(FollowModel followModel);
    int unfollow(FollowModel followModel);
	List<Integer> listFollowing(int user_id);
	List<Integer> listFollowers(int user_id);
	List<UserDao> listAllUsers(int user_id);
}