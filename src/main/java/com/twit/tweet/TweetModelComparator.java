package com.twit.tweet;

import java.util.Comparator;

public class TweetModelComparator implements Comparator<TweetModel>{

	@Override
	public int compare(TweetModel t1, TweetModel t0) {
		if(t0.getDate().getTime() > t1.getDate().getTime()){
				return 1;
			}else if ( t1.getDate().getTime() > t0.getDate().getTime()){
				return -1;
			}else{
				return t0.getUser_id()- t1.getUser_id();
			}
		}

}
