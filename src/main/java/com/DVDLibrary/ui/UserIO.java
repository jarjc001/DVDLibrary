package com.DVDLibrary.ui;

public interface UserIO {

    /**
     * Will print a String message onto Console
     * @param message - message to get printed
     */
    void print(String message);

    /**
     * Takes in a String prompt to display to the user on the console,
     * Will then Read a String input the user enters into the console,
     * then will return said String input
     * @param prompt - String prompt to be displayed on console
     * @return - the answer of the prompt as a String
     */
    String readString(String prompt);

    /**
     * Takes in a String prompt to display to the user on the console,
     * Will then Read an int input the user enters into the console,
     * then will return said int input
     * @param prompt - String prompt to be displayed on console
     * @return - the answer of the prompt as a int
     */
    int readInt(String prompt);


}
