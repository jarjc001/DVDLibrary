package com.DVDLibrary.ui;

import com.DVDLibrary.dto.Dvd;

import java.util.List;

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

        return io.readInt("Please choose from above:", 1, 7);
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
    public boolean displayAddSuccess(){
        io.print("DVD Added");
        return repeatAction("add another DVD");
    }



    /**For an inputted list of dvds in the library,
     * it will print the name and id of each DVD
     * @param dvdList - the dvd Library as a list
     */
    public void displayDvdList(List<Dvd> dvdList){
        for (Dvd currentDvd : dvdList){                     //for every object in the list,
            io.print(currentDvd.getDvdId() + ":" +currentDvd.getTitle() +" "); // it will print id and name
        }
        io.readString("Please ENTER to continue"); //will prompt user to press enter
    }

    /**Simple Banner saying we're displaying DVD Library*/
    public void displayDisplayListBanner(){
        io.print("=^..^=   =^..^=   Display DVD Library    =^..^=    =^..^=");
    }



    /**Shows to the user if the DVD removal was a success or not.
     * Then will ask if they want to remove another dvd or not
     * @param removedDvd the DVD the user wants to be removed
     * @return Boolean of whether the user want to remove another dvd*/
    public boolean displayRemoveResult(Dvd removedDvd){
        if(removedDvd == null){
            io.print("Couldn't find DVD in Library");
        }else {
            io.print("DVD removed from Library");
        }
        return repeatAction("remove another DVD");
    }

    /**Simple Banner saying we're removing a DVD*/
    public void displayRemoveDvdBanner(){
        io.print("=^..^=   =^..^=   Remove DVD    =^..^=    =^..^=");
    }











    /**Prompts user if they want to repeat the action they have just done
     * and returns a boolean true and false
     * @param promot what action the user wants to repeat, "Do you want to "+ promot+ "? (y or n)"
     * @return true and false whether the user wants to repeat the action
     */
    public boolean repeatAction (String promot){
        String answer = io.readString("Do you want to "+ promot+ "? (y or n)");
        if(answer.contains("y") || answer.contains("Y")){       //sees if the user's answer contains y or Y
            return true;
        }
        return false;
    }

}
