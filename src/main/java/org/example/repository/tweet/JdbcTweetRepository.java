package org.example.repository.tweet;

import org.example.model.Tweet;
import org.example.model.User;
import org.example.util.ApplicationProperties;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JdbcTweetRepository implements TweetRepository {
    private final Connection connection;

    public JdbcTweetRepository() throws SQLException {
        connection = DriverManager.getConnection(
                ApplicationProperties.DB_URL,
                ApplicationProperties.DB_USERNAME,
                ApplicationProperties.DB_PASSWORD


        );

        Statement statement = connection.createStatement();
        statement.executeUpdate(
                "DELETE FROM twitter.tweet");
    }

    @Override
    public void save(Tweet tweet) {
        try {
            String query = "INSERT INTO twitter.tweet (tweet_text, user_name) VALUES (?, ?)";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, tweet.getText());
            statement.setString(2, tweet.getUser().getUsername());
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    @Override
    public List<Tweet> findAll() {
        try {
            String query = "SELECT * FROM twitter.tweet";
            Statement statement = connection.createStatement();
            List<Tweet> tweets = new ArrayList<>();

            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                tweets.add(new Tweet(resultSet.getString(1),
                        new User(resultSet.getString(2), ""))
                );


            }
            return tweets;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
