package org.example;

import java.util.ArrayList;

public class RepositoryImpl  implements UserRepository {
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
}
