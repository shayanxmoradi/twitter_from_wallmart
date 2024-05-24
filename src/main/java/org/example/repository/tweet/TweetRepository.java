package org.example.repository.tweet;

import org.example.model.Tweet;
import org.example.service.tweet.TweetResponse;

import java.util.List;

public interface TweetRepository {
    void save(Tweet tweet);

    List<Tweet> findAll();
}
