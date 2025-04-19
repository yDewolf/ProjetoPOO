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
        this.setUsername(username);
        this.setPassword(password);;
        this.setEmail(email);
    }

    public String getPassword() {
        return this.password;
    }

    public String getUsername(){
        return this.username;
    }
    
    public String getEmail() {
        return this.email;
    }

    public void setUsername(String new_username) {
        if (new_username.length() < 4) {
            System.out.println("O nome de usuário é muito pequeno | Mínimo: 4");
            return;
        }

        if (new_username.length() > 32) {
            System.out.println("O nome de usuário é muito longo | Máximo: 32");
            return;
        }

        this.username = new_username;
    }

    public void setPassword(String new_password) {
        if (new_password.length() < 4) {
            System.out.println("A senha é muito curta | Mínimo: 4");
            return;
        }

        this.password = new_password;
    }

    public void setEmail(String new_email) {
        if (!new_email.contains("@")) {
            System.out.println("O email não é válido | Tente adicionar @");
            return;
        }

        this.email = new_email;
    }   
 }
