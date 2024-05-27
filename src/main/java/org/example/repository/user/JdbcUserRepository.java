package org.example.repository.user;

import org.example.model.User;
import org.example.repository.JdbcBaseRepository;

import java.sql.*;

public class JdbcUserRepository extends JdbcBaseRepository implements UserRepository {

    public JdbcUserRepository() throws SQLException {


    }

    @Override
    public void save(User user) {
            String query = "INSERT INTO users (user_name, password) VALUES (?, ?)";
            try (PreparedStatement statement = getConnection().prepareStatement(query)) {
                statement.setString(1, user.getUsername());
                statement.setString(2, user.getPassword());
                statement.executeUpdate();
            }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public User findByUsernameAndPassword(String username, String password) {
        String sql = "SELECT * FROM users WHERE user_name = ? AND password = ?";
        User user = null;

            ResultSet resultSet;
            try (PreparedStatement statement = getConnection().prepareStatement(sql)) {
                statement.setString(1, username);
                statement.setString(2, password);

                resultSet = statement.executeQuery();

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

            ResultSet resultSet;
            try (PreparedStatement statement = getConnection().prepareStatement(sql)) {
                statement.setString(1, userName);

                resultSet = statement.executeQuery();

            if (resultSet.next()) {

                user = new User(resultSet.getString("user_name"), resultSet.getString("password"));
            }
            return user;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
