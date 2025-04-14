package com.github.ydewolf.classes;

public class Intern extends User {
    protected String name;

    public Intern(String name, UserHolder holder, String username, String password, String email) {
        super(holder, username, password, email);
        this.name = name;
    }
}

