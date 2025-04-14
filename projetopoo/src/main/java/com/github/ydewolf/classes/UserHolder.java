package com.github.ydewolf.classes;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class UserHolder {
    private ArrayList<User> users = new ArrayList<>();
    private ArrayList<String[]> pontos = new ArrayList<>();
    
    public UserHolder() {

    }

    public UserSession logIn(String username, String password) {
        UserSession session = new UserSession(this.getUser(username));
        if (!session.isLogged()) {
            return null;
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
    }

    public void removeUser(UserSession session, String username) {
        if (!session.isLogged()) {
            System.err.println("ERROR: You can't remove a user if you aren't logged");
            return;
        }

        int user_idx = this.users.indexOf(getUser(username));
        // Usuário se demitindo
        if (session.getUser().username.equals(username)) {
            this.users.remove(user_idx);
            return;
        }

        // Usuário é demitido
        this.users.remove(user_idx);
    }

    public User getUser(String username) {
        for (User user : this.users) {
            if (user.username.equals(username)) {
                return user;
            }
        }

        return null;
    }

    public void baterPonto(UserSession session) {
        String[] ponto_data = {LocalDateTime.now().toString(), session.user.username};
        this.pontos.add(ponto_data);
    }
}
