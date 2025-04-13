package com.github.ydewolf.utils;

import com.github.ydewolf.utils.abstracts.BaseMenu;

public class Menu extends BaseMenu {
    UserInput user_input = new UserInput();
    
    public int selectOption(String[] options, boolean first_goest_last, String title) {
        return super.selectOption(options, first_goest_last, title, "Your input is invalid");
    }

    public String getInput(int min_length, int max_length, String title, String invalid_input_message) {
        String[] invalid = new String[0];
        return super.getInput(min_length, max_length, title, invalid_input_message, invalid);
    }
}
