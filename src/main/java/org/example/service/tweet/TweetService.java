package org.example.service.tweet;

import org.example.model.Tweet;

import java.util.List;

public interface TweetService {

    void addTweet(String tweetText,String token);

    List<TweetResponse> getTweets();

}
