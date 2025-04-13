package com.github.ydewolf;

import com.github.ydewolf.utils.Menu;

public class Main {
    public static void main(String[] args) {
        Menu general_menu = new Menu();

        String[] invalid_chars = {" "};
        String username = general_menu.getInput(
            4,
            16,
            "Type your username",
            "This username is invalid",
            invalid_chars
        );
        
        System.out.println("Welcome " + username + "\n");
        
        String[] options = {"Leave", "Repeat your phrase"};
        int selected = general_menu.selectOption(options, true, "Main Menu | Type the number of the option", "Please type a valid option");
        switch (selected) {
            case 0:
                
                break;
            
            case 1:
                String phrase = general_menu.getInput(
                    0,
                    128,
                    "Type a phrase and I will repeat it",
                    "Your phrase may be too long"
                );

                System.out.println(phrase);

            default:
                break;
        }
    }
}