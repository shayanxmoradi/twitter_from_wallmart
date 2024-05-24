package org.example.repository.tweet;

import org.example.model.Tweet;

import java.util.ArrayList;
import java.util.List;

public class TweetRepositoryImp implements TweetRepository {
    List<Tweet> tweets = new ArrayList<>();

    @Override
    public void save(Tweet tweet) {
        tweets.add(tweet);
    }

    @Override
    public List<Tweet> findAll() {
        return tweets;
    }
}
