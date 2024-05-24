package org.example.util;

import org.example.service.auth.AuthService;
import org.example.service.tweet.TweetService;

import java.util.Scanner;

public class Menu {
    private final AuthService authService;
    private final TweetService tweetService;
    private static String token;

    public Menu(AuthService authService, TweetService tweetService) {
        this.authService = authService;
        this.tweetService = tweetService;
    }

    //static blocok. runs just one time. when loader loads this class. NOT a good Idea
    static {

    }

    public void showMenu() {
        System.out.println("WELCOME TO THE MENU");

        Scanner scanner = new Scanner(System.in);
        while (token == null) {
            System.out.println("select between LOGIN = 1/ REGISTER = 2");
            String inputedValue = scanner.nextLine();
            switch (inputedValue) {
                case "1" -> {
                    System.out.println("enter your username");
                    String username = scanner.nextLine();
                    System.out.println("enter your password");
                    String password = scanner.nextLine();

                    token = authService.login(username, password);
                    if (token == null) {
                        System.out.println("Invalid username or password");
                    }

                }


                case "2" -> {
                    System.out.println("enter your username");
                    String username = scanner.nextLine();
                    System.out.println("enter your password");
                    String password = scanner.nextLine();
                    authService.register(username, password);

                }
                default -> System.out.println("roung input value");


            }
        }

        while (true) {
            System.out.println("you can now add new Tweet = 1 / or get all tweets = 2/ and 3 for exit");
            String inputedValue = scanner.nextLine();
            switch (inputedValue) {
                case "1" -> {
                    System.out.println("enter your tweet");
                    String tweet = scanner.nextLine();
                    tweetService.addTweet(tweet, token);

                }
                case "2" -> {
                    System.out.println(tweetService.getTweets());

                }
                case "3" -> { return;}
                default -> System.out.println("roung input value");
            }

        }
    }

}
