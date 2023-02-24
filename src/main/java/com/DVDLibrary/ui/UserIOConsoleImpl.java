package com.DVDLibrary.ui;

import java.util.Scanner;

public class UserIOConsoleImpl implements UserIO {

    /**Scanner object to take in console inputs from user*/
    final private Scanner sc = new Scanner(System.in);

    @Override
    public void print(String message) {
        System.out.println(message);
    }

    @Override
    public String readString(String prompt) {
        //print prompt
        System.out.println(prompt);
        return sc.nextLine();
    }

    @Override
    public int readInt(String prompt) {
        // Print the Prompt
        String stringValue = this.readString(prompt);
        // Get the input line, and parse into an int
        return Integer.parseInt(stringValue);
    }

    @Override
    public int readInt(String prompt, int min, int max) {
        int result;
        //the loop will keep repeating until the input int is within range
        do {
            result = readInt(prompt);
        }while(result<min || result>max);

        return result;

    }

    @Override
    public char readChar(String prompt) {
        //print prompt
        System.out.println(prompt);
        return sc.next().charAt(0);
    }
}
