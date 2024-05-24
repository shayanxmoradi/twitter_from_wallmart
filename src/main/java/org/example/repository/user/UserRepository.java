package org.example.repository.user;

import org.example.model.User;

public interface UserRepository {
    void save(User user);

    User findByUsernameAndPassword(String username, String password);
    User findByUserName(String userName);
}
