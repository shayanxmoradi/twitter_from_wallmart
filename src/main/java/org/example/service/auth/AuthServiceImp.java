package org.example.service.auth;

import org.example.model.User;
import org.example.repository.user.UserRepository;

public class AuthServiceImp implements AuthService {
    private final UserRepository repository;

    public AuthServiceImp(UserRepository repository) {
        this.repository = repository;
    }

    @Override
    public String login(String username, String password) {
        User user = repository.findByUsernameAndPassword(username, password);

        if (user == null) {
            return null;
        } else return user.getUsername();
    }

    @Override
    public void register(String username, String password) {
        User user = new User(username, password);
        repository.save(user);
    }
}
