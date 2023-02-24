package com.DVDLibrary.controller;

import com.DVDLibrary.dao.DVDLibraryDao;
import com.DVDLibrary.dao.DVDLibraryDaoFileImpl;
import com.DVDLibrary.dto.Dvd;
import com.DVDLibrary.ui.DVDLibraryView;
import com.DVDLibrary.ui.UserIO;
import com.DVDLibrary.ui.UserIOConsoleImpl;

public class DVDLibraryController {
    /**implementation  of the UserIO*/
    private UserIO io = new UserIOConsoleImpl();
    private DVDLibraryView view = new DVDLibraryView();
    private DVDLibraryDao doa = new DVDLibraryDaoFileImpl();



    /**Method to run the App, it starts the main menu*/
    public void runApp(){
        boolean keepRunning = true;     //switch for repeating main menu
        //int menuSelect = 0;

        while (keepRunning) {           //will loop until user exits

            int menuSelect = getMainMenu(); //main menu loaded

            switch (menuSelect){
                case 1:
                    addDvdToLibrary();
                    break;
                case 2:
                    io.print("remove");
                    break;
                case 3:
                    io.print("edit");
                    break;
                case 4:
                    displayDvdLibrary();
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

    /**
     * The user is prompted to add a Dvd to the DVD Library.
     * Then after it is added, they are asked again whether they want to add another
     */
    private void addDvdToLibrary(){
        String addAnother;
        do {
            view.displayAddDvdBanner();                     //Banner saying we're adding
            Dvd newDvd = view.getNewDvdInfo();              //creates a Dvd object from prompts
            doa.addDvd(newDvd);                             //adds Dvd to Library
        }while(view.displayAddSuccess());
    }

    /**
     * Returns a list of the DVDs in the library and their IDs to the console
     */
    private void displayDvdLibrary(){
        view.displayDisplayListBanner();
        view.displayDvdList(doa.getAllDvd());
    }






}
