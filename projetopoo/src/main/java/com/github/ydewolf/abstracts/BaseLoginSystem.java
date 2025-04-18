package com.github.ydewolf.abstracts;

import java.util.ArrayList;

import com.github.ydewolf.classes.User;
import com.github.ydewolf.classes.UserSession;
import com.github.ydewolf.interfaces.LoginSystem;

public abstract class BaseLoginSystem implements LoginSystem {
    protected ArrayList<User> users;

    public UserSession logIn(String username, String password) {
        UserSession session = new UserSession(this.getUser(username));
        if (!session.isLogged()) {
            return new UserSession(null);
        }

        return session;
    }

    public void registerUser(
        String username,
        String password,
        String email
    ) {
        User user = new User(this, username, password, email);

        users.add(user);
        System.out.println("O usuário " + username + " foi registrado com sucesso");
    }

    public void removeUser(UserSession session, String username) {
        int user_idx = this.users.indexOf(this.getUser(username));

        this.users.remove(user_idx);
        System.out.println("O usuário " + username + " foi removido com sucesso");
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
