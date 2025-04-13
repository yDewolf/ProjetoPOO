package com.github.ydewolf.utils.abstracts;

import com.github.ydewolf.utils.UserInput;

public abstract class BaseMenu {
    private UserInput user_input;

    public BaseMenu() {
        this.user_input = new UserInput();
    }

    public int selectOption(String[] options, boolean first_goes_last, String title, String invalid_input_message) {
        String header = title + "\n" + stringifyOptions(options, first_goes_last);
        System.out.print(header + "\n> ");
        int selected_idx = this.user_input.nextInt(0, options.length, invalid_input_message);

        return selected_idx;
    }

    public String getInput(int min_length, int max_length, String title, String invalid_input_message, String[] invalid_characters) {
        String header = "\n" + title;
        if (invalid_characters.length > 0) {
            header += "\nInvalid characters: ";

            for (String c : invalid_characters) {
                header += c + ", ";
            }
        }

        System.out.print(header + "\n> ");
        String input = this.user_input.nextString(min_length, max_length, invalid_input_message, invalid_characters);
        
        return input;
    }
    
    private String stringifyOptions(String[] options, boolean first_goes_last) {
        String stringified = "";
        for (int idx = 0; idx < options.length; idx++) {
            if (idx == 0 && first_goes_last) { continue; }
            stringified += "[" + idx + "]-" + options[idx] + "\n";
        }
        if (first_goes_last) {
            stringified += "[0]-" + options[0];
        }

        return stringified;
    }
}
