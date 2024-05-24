package org.example.repository.user;

import org.example.model.User;

public class MySqlRepository implements UserRepository {
    @Override
    public void save(User user) {

    }

    @Override
    public User findByUsernameAndPassword(String username, String password) {
        return null;
    }

    @Override
    public User findByUserName(String userName) {
        return null;
    }
}
