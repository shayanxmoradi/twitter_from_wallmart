package org.example;

import org.example.repository.tweet.JdbcTweetRepository;
import org.example.repository.tweet.TweetRepositoryImp;
import org.example.repository.user.JdbcUserRepository;
import org.example.repository.user.UserRepositoryImpl;
import org.example.service.auth.AuthServiceImp;
import org.example.service.tweet.TweetServiceImp;

import java.sql.SQLException;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws SQLException {
        //UserRepositoryImpl userRepository = new UserRepositoryImpl();
        JdbcUserRepository jdbcUserRepository = new JdbcUserRepository();
        AuthServiceImp authServiceImp = new AuthServiceImp(jdbcUserRepository);
        authServiceImp.register("soghra", "admin");

        System.out.println(authServiceImp.login("soghra", "admin"));
        String token = authServiceImp.login("soghra", "admin");
     //   TweetRepositoryImp tweetRepositoryImp = new TweetRepositoryImp();
        JdbcTweetRepository jdbcTweetRepository = new JdbcTweetRepository();
        TweetServiceImp tweetServiceImp = new TweetServiceImp(jdbcTweetRepository,jdbcUserRepository);
        tweetServiceImp.addTweet(" hi im writing tweet from maktab 115",token);

        System.out.println(  tweetServiceImp.getTweets());



    }
}