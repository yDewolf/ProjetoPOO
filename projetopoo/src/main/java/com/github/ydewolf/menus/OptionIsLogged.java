package com.github.ydewolf.menus;

import com.github.ydewolf.classes.UserSession;

public class OptionIsLogged extends MenuOption {

    public OptionIsLogged(String option) {
        super(option);
    }
    
    @Override
    public boolean conditionMatches(UserSession session) {
        return session.isLogged();
    }
}
