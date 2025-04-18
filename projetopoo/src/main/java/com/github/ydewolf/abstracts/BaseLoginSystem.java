package com.github.ydewolf.abstracts;

import java.util.ArrayList;

import com.github.ydewolf.classes.User;
import com.github.ydewolf.interfaces.LoginSystem;

public abstract class BaseLoginSystem implements LoginSystem {
    protected ArrayList<User> users;

    public void registerUser(
        String username,
        String password,
        String email
    ) {
        User user = new User(this, username, password, email);

        users.add(user);
        System.out.println("O usuário " + username + " foi registrado com sucesso");
    }

    public User getUser(String username) {
        for (User user : this.users) {
            if (user.getUsername().equals(username)) {
                return user;
            }
        }

        return null;
    }
}
