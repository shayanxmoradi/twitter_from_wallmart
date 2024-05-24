package org.example;

import org.example.repository.tweet.JdbcTweetRepository;
import org.example.repository.tweet.TweetRepository;
import org.example.repository.tweet.TweetRepositoryImp;
import org.example.repository.user.JdbcUserRepository;
import org.example.repository.user.UserRepository;
import org.example.repository.user.UserRepositoryImpl;
import org.example.service.auth.AuthServiceImp;
import org.example.service.tweet.TweetServiceImp;
import org.example.util.Menu;

import java.sql.SQLException;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws SQLException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("enter your action");


        String repoMode = scanner.nextLine();
        UserRepository userRepository;
        TweetRepository tweetRepository;
        if (repoMode.equals("Database")) {
            userRepository = new JdbcUserRepository();
            tweetRepository = new JdbcTweetRepository();
        } else {
            userRepository = new UserRepositoryImpl();
            tweetRepository = new TweetRepositoryImp();
        }

        AuthServiceImp authServiceImp = new AuthServiceImp(userRepository);
        TweetServiceImp tweetServiceImp = new TweetServiceImp(tweetRepository, userRepository);


        Menu menu = new Menu(authServiceImp, tweetServiceImp);
        menu.showMenu();

    }
}