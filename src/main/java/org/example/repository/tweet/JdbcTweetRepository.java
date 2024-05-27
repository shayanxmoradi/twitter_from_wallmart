package org.example.repository.tweet;

import org.example.model.Tweet;
import org.example.model.User;
import org.example.repository.JdbcBaseRepository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JdbcTweetRepository extends JdbcBaseRepository implements TweetRepository {

    @SuppressWarnings("SqlWithoutWhere")
    public JdbcTweetRepository() throws SQLException {

    }

    @Override
    public void save(Tweet tweet) {

            String query = "INSERT INTO twitter.tweet (tweet_text, user_name) VALUES (?, ?)";
            try (PreparedStatement statement = getConnection().prepareStatement(query)) {
                statement.setString(1, tweet.getText());
                statement.setString(2, tweet.getUser().getUsername());
                statement.executeUpdate();
            }
         catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    @Override
    public List<Tweet> findAll() {

            String query = "SELECT * FROM twitter.tweet";
            List<Tweet> tweets;
            ResultSet resultSet;
            try (Statement statement = getConnection().createStatement()) {
                tweets = new ArrayList<>();

                resultSet = statement.executeQuery(query);

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
