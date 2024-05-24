package org.example.model;

public class Tweet {
    private String text;
    private User user;

    public Tweet(String text, User user) {
        this.text = text;
        this.user = user;
    }

    @Override
    public String toString() {
        return "Tweet{" +
                "text='" + text + '\'' +
                ", user=" + user +
                '}';
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
