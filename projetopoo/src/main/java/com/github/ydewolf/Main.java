package com.github.ydewolf;

import com.github.ydewolf.classes.UserHolder;

public class Main {
    public static void main(String[] args) {
        UserHolder user_holder = new UserHolder();
        user_holder.registerUser("andre", "123456", "andrersng@gmail.com");

        System.out.println(user_holder.getUser("andre").getPassword());
    }
}