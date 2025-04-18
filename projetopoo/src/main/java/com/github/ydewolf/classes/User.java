package com.github.ydewolf.classes;

import com.github.ydewolf.abstracts.BaseLoginSystem;

public class User {
    protected BaseLoginSystem user_holder;
    protected String username;
    protected String password;
    protected String email;

    public User(
        BaseLoginSystem holder,
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

    public String getUsername(){
        return this.username;
    }
}
