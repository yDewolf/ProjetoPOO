package com.github.ydewolf.utils;
import java.util.InputMismatchException;
import java.util.Scanner;

public class UserInput {
    private Scanner input;

    public UserInput() {
        this.input = new Scanner(System.in);
    }

    public int nextInt(int min, int max, String invalid_input_message) {
        int selected = min - 1;
        int i = 0;
        do {
            if (i > 0) {
                System.out.println(invalid_input_message);
            }

            // Super secure method of not having to deal with exceptions
            if (!this.input.hasNextInt()) {
                this.input.nextLine();
                System.out.println("Invalid input format");
                continue;
            } 
            selected = this.input.nextInt();
            i++;
        } while (selected < min || selected > max);
        // Consume the leftover of input.nextInt()
        this.input.nextLine();

        return selected;
    }

    public String nextString(int min_length, int max_length, String invalid_input_message, String[] invalid_characteres) {
        String user_input = "";
        int i = 0;

        while (true) {
            do {
                if (i > 0) {
                    System.out.println("| " + invalid_input_message);
                }
    
                // System.err.println(message);

                user_input = this.input.nextLine();
                i++;
    
            } while (user_input.length() < min_length && user_input.length() > max_length);

            boolean valid = true;
            for (String character : invalid_characteres) {
                if (user_input.contains(character)) {
                    System.out.println("| Your input has invalid characters");
                    valid = false;
                    break;
                }
            }

            // Leave the loop if the user input is valid
            if (valid) {break;}
        }
        
        return user_input;
    }
}
