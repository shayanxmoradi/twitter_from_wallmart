package org.example.service.tweet;

import org.example.repository.tweet.TweetRepository;
import org.example.model.Tweet;
import org.example.model.User;
import org.example.repository.user.UserRepository;

import java.util.ArrayList;
import java.util.List;

public class TweetServiceImp implements TweetService {
    private final TweetRepository tweetRepository;
    private final UserRepository userRepository;

    public TweetServiceImp(TweetRepository tweetRepository, UserRepository userRepository) {
        this.tweetRepository = tweetRepository;
        this.userRepository = userRepository;
    }

    @Override
    public void addTweet(String tweetText, String userName) {
        User targetUser = userRepository.findByUserName(userName);
        Tweet tweet = new Tweet(tweetText, targetUser);
        tweetRepository.save(tweet);


    }

    @Override
    public List<TweetResponse> getTweets() {
        List<TweetResponse> tweetResponses = new ArrayList<>();
        List<Tweet> tweetList = tweetRepository.findAll();
        for (Tweet tweetRespons : tweetList) {
            tweetResponses.add(new TweetResponse(tweetRespons.getText(),
                    tweetRespons.getUser().getUsername()));
        }
        return tweetResponses;
    }
}
