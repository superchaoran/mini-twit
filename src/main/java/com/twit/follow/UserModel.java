package com.twit.follow;

public class UserModel {
	private int id;
    private boolean isFollowed;
    UserModel(){}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public boolean getIsFollowed() {
		return isFollowed;
	}
	public void setFollowed(boolean isFollowed) {
		this.isFollowed = isFollowed;
	}
}
