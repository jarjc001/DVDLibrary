package com.DVDLibrary.controller;

import com.DVDLibrary.ui.DVDLibraryView;
import com.DVDLibrary.ui.UserIO;
import com.DVDLibrary.ui.UserIOConsoleImpl;

public class DVDLibraryController {
    /**implementation  of the UserIO*/
    private UserIO io = new UserIOConsoleImpl();
    private DVDLibraryView view = new DVDLibraryView();

    /**Method to run the App, it starts the main menu*/
    public void runApp(){
        boolean keepRunning = true;     //switch for repeating main menu
        //int menuSelect = 0;

        while (keepRunning) {           //will loop until user exits

            int menuSelect = getMainMenu(); //main menu loaded

            switch (menuSelect){
                case 1:
                    io.print("Add");
                    break;
                case 2:
                    io.print("remove");
                    break;
                case 3:
                    io.print("edit");
                    break;
                case 4:
                    io.print("list");
                    break;
                case 5:
                    io.print("info");
                    break;
                case 6:
                    io.print("title");
                    break;
                case 7:
                    keepRunning=false;
                    break;
                default:
                    io.print("Unknown input");
            }

        }
        io.print("Good Bye");

    }

    /**Prints the Main menu's options on console,
     * then returns an int of the user's choice
     * @return - an int of the user's choice
     */
    private int getMainMenu(){
        return view.printMainMenu();
    }






}
