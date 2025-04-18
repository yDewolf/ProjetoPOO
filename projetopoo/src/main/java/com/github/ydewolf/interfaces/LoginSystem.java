package com.github.ydewolf.interfaces;

import com.github.ydewolf.classes.User;
import com.github.ydewolf.classes.UserSession;

public interface LoginSystem {
    public UserSession logIn(String username, String password);
    public User getUser(String username);
    public void registerUser(String username, String password, String email);
}