package com.twit.follow;

public class FollowModel {
    private int user_id;
    private int follower_user_id;

    public FollowModel() {
    }

    public FollowModel(int user_id, int follower_user_id) {
        this.setUser_id(user_id);
        this.setFollower_user_id(follower_user_id);
    }

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public int getFollower_user_id() {
		return follower_user_id;
	}

	public void setFollower_user_id(int follower_user_id) {
		this.follower_user_id = follower_user_id;
	}

}