package com.github.ydewolf.classes;

public class User {
    protected UserHolder user_holder;
    protected String username;
    protected String password;
    protected String email;

    public User(
        UserHolder holder,
        String username,
        String password,
        String email
    ) {
        this.user_holder = holder;
        this.username = username;
        this.password = password;
        this.email = email;
    }

    public String getPassword() {
        return this.password;
    }
}
