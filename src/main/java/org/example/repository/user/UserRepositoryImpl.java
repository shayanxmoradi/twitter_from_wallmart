package org.example.repository.user;

import org.example.model.User;

import java.util.ArrayList;

public class UserRepositoryImpl implements UserRepository {
    ArrayList<User> users= new ArrayList<>();

    @Override
    public void save(User user) {
        users.add(user);

    }

    @Override
    public User findByUsernameAndPassword(String username, String password) {
        for (User user : users) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                return user;
            }

        }return null;
    }

    @Override
    public User findByUserName(String username) {
        for (User user : users) {
            if (user.getUsername().equals(username) ) {
                return user;
            }

        }return null;
    }
}
