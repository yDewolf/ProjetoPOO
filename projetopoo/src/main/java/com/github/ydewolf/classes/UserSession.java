package com.github.ydewolf.classes;

public class UserSession {
    protected User user;

    public UserSession(User user) {
        this.user = user;
    }

    public User getUser() {
        return this.user;
    }

    public boolean isLogged() {
        return user != null;
    }
}
