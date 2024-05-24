package org.example.repository.user;

import org.example.model.User;
import org.example.util.ApplicationProperties;

import java.sql.*;

public class JdbcUserRepository implements UserRepository {
    private final Connection connection;

    public JdbcUserRepository() throws SQLException {
        connection = DriverManager.getConnection(
                ApplicationProperties.DB_URL,
                ApplicationProperties.DB_USERNAME,
                ApplicationProperties.DB_PASSWORD
        );
        Statement statement = connection.createStatement();
        statement.executeUpdate(
                "DELETE FROM twitter.users");
    }

    @Override
    public void save(User user) {
        try {
            String query = "INSERT INTO users (user_name, password) VALUES (?, ?)";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, user.getUsername());
            statement.setString(2, user.getPassword());
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public User findByUsernameAndPassword(String username, String password) {
        String sql = "SELECT * FROM users WHERE user_name = ? AND password = ?";
        User user = null;
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, username);
            statement.setString(2, password);

            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {

                user = new User(resultSet.getString("user_name"), resultSet.getString("password"));
            }
            return user;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public User findByUserName(String userName) {
        String sql = "SELECT * FROM users WHERE user_name = ?";
        User user = null;
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, userName);

            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {

                user = new User(resultSet.getString("user_name"), resultSet.getString("password"));
            }
            return user;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
