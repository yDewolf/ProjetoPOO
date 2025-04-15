package com.github.ydewolf.menus;

import com.github.ydewolf.classes.UserSession;

public class MenuOption {
    public String option;

    public MenuOption(String option) {
        this.option = option;
    }

    public boolean conditionMatches(UserSession session) {
        return true;
    }
}
