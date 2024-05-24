package org.example.service.auth;

public interface AuthService {
    String login(String username, String password);
    void register(String username, String password);
}
