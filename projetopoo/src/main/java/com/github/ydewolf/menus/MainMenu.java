package com.github.ydewolf.menus;

import com.github.ydewolf.classes.UserSession;
import com.github.ydewolf.utils.Menu;

public class MainMenu extends Menu {
    private final MenuOption[] OPTIONS = {
        new MenuOption("Leave"),
        new MenuOption("Logar"),
        new OptionIsLogged("Criar conta")
    }; 
    private final String TITLE = "Menu principal | Selecione uma das opções abaixo";

    public int showOptions(UserSession session) {
        String[] filtered_options = new String[this.OPTIONS.length];

        int idx = 0;
        for (MenuOption option : this.OPTIONS) {
            if (!option.conditionMatches(session)) {
                continue;
            }

            filtered_options[idx] = option.option;
            idx++;
        }
        String[] resized = new String[idx];
        for (int i = 0; i < idx; i++) {
            resized[i] = filtered_options[i];
        }

        int option_idx = selectOption(resized, true, this.TITLE);
        this.parseOption(option_idx, session);

        return option_idx;
    }

    public void parseOption(int option_idx, UserSession session) {
        switch (option_idx) {
            case 0:
                break;
            
            case 1:
                System.out.println("Você está no menu de login!!!!!");
                break;

            case 2:
                System.out.println("Você está no menu de criar conta!!!!");
                break;
            default:
                break;
        }
    }
}
