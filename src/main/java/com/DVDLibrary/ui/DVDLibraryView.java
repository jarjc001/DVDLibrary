package com.DVDLibrary.ui;

import com.DVDLibrary.dto.Dvd;

public class DVDLibraryView {
    /**implementation  of the UserIO*/
    private UserIO io = new UserIOConsoleImpl();

    /**
     * Prints the Main menu's options on console,
     * then returns an int of the user's choice
     * @return - an int of the user's choice
     */
    public int printMainMenu(){
        io.print("=^..^=   =^..^=   Main Menu    =^..^=    =^..^=");
        io.print("1. Add a DVD to the Library");
        io.print("2. Remove a DVD from the Library");
        io.print("3. Edit the information for an existing DVD in the Library");
        io.print("4. List the DVDs in the Library");
        io.print("5. Display the information for a particular DVD");
        io.print("6. Search for a DVD by title");
        io.print("7. Exit");

        return io.readInt("Please choose:", 1, 7);
    }


    /**
     * Prompts the user to fill in the info of the dvd they want to add to the Library,
     * Then it creates a Dvd object from the info
     * @return Dvd object the user wants to add to library
     */
    public Dvd getNewDvdInfo(){
        String title = io.readString("Please enter DVD Title:");
        String releaseDate = io.readString("Please enter Release Date:");
        String ratingMPAA = io.readString("Please enter MPAA Rating:");
        String director = io.readString("Please enter Director:");
        String studio = io.readString("Please enter Studio:");
        String userNotes = io.readString("Please enter any other user notes:");
        Dvd newDvd = new Dvd(title,releaseDate,ratingMPAA,director,studio,userNotes);
        return newDvd;
    }

    /**Simple Banner saying we're adding a Dvd*/
    public void displayAddDvdBanner(){
        io.print("=^..^=   =^..^=   Add DVD    =^..^=    =^..^=");
    }

    /**Shown after a dvd is added to the library
     * will ask if they want to add another dvd or not
     * @return Boolean of whether the user want to add another dvd*/
    public Boolean displayAddSuccess(){
        String answer = io.readString("DVD Added. Do you want to add another DVD? (y or n)");
        if(answer.contains("y") || answer.contains("Y")){       //sees if the user's answer contains y or Y
            return true;
        }
        return false;

    }
}
