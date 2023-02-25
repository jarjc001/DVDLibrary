package com.DVDLibrary.ui;

import com.DVDLibrary.dto.Dvd;
import com.DVDLibrary.dto.DvdInfo;

import java.util.List;

public class DVDLibraryView {
    /**Declaration of the UserIO*/
    private UserIO io;

    /**Constructor
     * @param io UserIOConsoleImpl */
    public DVDLibraryView(UserIO io) {
        this.io = io;
    }


    //main menu//


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


    //ADD DVD//


    /**
     * Prompts the user to fill in the info of the dvd they want to add to the Library,
     * Then it creates a Dvd object from the info
     * @return Dvd object the user wants to add to library
     */
    public Dvd getNewDvdInfo(){
        String title = io.readString("Please enter DVD Title:");
        String releaseDate = io.readString("Please enter Release Date (ddmmyyyy):");
        String ratingMPAA = io.readString("Please enter MPAA Rating:");
        String director = io.readString("Please enter Director:");
        String studio = io.readString("Please enter Studio:");
        String userNotes = io.readString("Please enter any other user notes:");
        DvdInfo dvdInfo = new DvdInfo(releaseDate,ratingMPAA,director,studio,userNotes);
        return new Dvd(title,dvdInfo);
    }

    /**Simple Banner saying we're adding a Dvd*/
    public void displayAddDvdBanner(){
        io.print("=^..^=   =^..^=   Add DVD    =^..^=    =^..^=");
    }

    /**Shown after a dvd is added to the library
     * will ask if they want to add another dvd or not
     * @return Boolean of whether the user want to add another dvd*/
    public boolean displayAddSuccess(Dvd dvd){
        io.print(dvd.getTitle() + " is added to Library");
        return repeatAction("add another DVD");
    }


    //Display whole list//


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


    //Remove DVD//


    /**Shows to the user if the DVD removal was a success or not.
     * Then will ask if they want to remove another dvd or not
     * @param removedDvd the DVD the user wants to be removed
     * @return Boolean of whether the user want to remove another dvd*/
    public boolean displayRemoveResult(Dvd removedDvd){
        if(removedDvd == null){
            io.print("Couldn't find DVD in Library");
        }else {
            io.print(removedDvd.getTitle() + " is removed from Library");
        }
        return repeatAction("remove another DVD");
    }
    /**Simple Banner saying we're removing a DVD*/
    public void displayRemoveDvdBanner(){
        io.print("=^..^=   =^..^=   Remove DVD    =^..^=    =^..^=");
    }


    // Display info from ID and title //


    /**Prompts user to enter the Dvd ID and returns it
     * @return DVD ID
     */
    public int getDvdIdSearch(){
        return io.readInt("Please enter DVD ID:");
    }

    /**Displays the info for a given DVD
     * @param dvd The DVD the user wants the info about
     */
    public boolean displayDvd(Dvd dvd){
        if(dvd == null){
            io.print("Couldn't find DVD in Library");
        }else {
            io.print("ID: " + dvd.getDvdId());
            io.print("Title: "+ dvd.getTitle());
            io.print("Release Date: " +dvd.getDvdInfo().getReleaseDate());
            io.print("MPAA Rating: "+dvd.getDvdInfo().getRatingMPAA());
            io.print("Director's name: "+dvd.getDvdInfo().getDirector());
            io.print("Studio: "+dvd.getDvdInfo().getStudio());
            io.print("User Notes: "+dvd.getDvdInfo().getUserNotes());
        }
        return repeatAction("search for another DVD");
    }

    /**Simple Banner saying we're displaying info of a DVD from ID*/
    public void displayDisplayDvdIdBanner(){
        io.print("=^..^=   =^..^=   Display Info of DVD    =^..^=    =^..^=");
    }

    /**Prompts user to enter the Dvd Title and returns it
     * @return DVD ID
     */
    public String getDvdTitleSearch(){
        return io.readString("Please enter DVD Title:");
    }

    /**
     * from an Array List of DVDs, will ask which one the user wants,
     * then will return that DVD or null
     * @param dvdList Array list of DVDs
     * @return  The chosen DVD from the Array List
     */
    public Dvd chooseDvdFromArrayList(List<Dvd> dvdList){
        //checks if dvdList has anything in it
        if(dvdList.size()==0){
            return null;
        }

        int counter = 1;
        for (Dvd dvd: dvdList){
            //prints every DVD title with a number
            io.print(counter + ": "+dvd.getTitle());
            counter++;
        }
        io.print(counter + ": (None of above)");
        int response = io.readInt("Did you mean any of these:",1,counter);

        //will either return the dvd chosen or null
        if(response == counter){
            return null;
        }
        return dvdList.get(response-1);
    }

    /**Simple Banner saying we're Searching for a DVD from Title*/
    public void displayDisplayDvdTitleBanner(){
        io.print("=^..^=   =^..^=   Search for DVD    =^..^=    =^..^=");
    }


    //Edit DVD//


    /**
     * Prompts the user to choose which information to edit for a given DVD
     * @return the user's choice of info to edit
     */
    public int displayChooseInfoEdit(Dvd dvdEdit){
        io.print("1. Title");
        io.print("2. Release Date");
        io.print("3. MPAA Rating");
        io.print("4. Director's name");
        io.print("5. Studio");
        io.print("6. User Notes");
        io.print("7. Exit");

        return io.readInt(("Please choose one from above to edit: " +dvdEdit.getTitle()), 1, 7);
    }

    /**Shows after the user has chosen the dvd to edit from DVD ID.
     * It wll say if the dvd exists in the library. If it doesn't,
     * it will ask the user whether they want to find another DVD or continue with the null
     * @param editDvd the DVD the user wants to edit
     * @return Boolean of whether to repeat the search*/
    public boolean displayEditDvdFoundResult(Dvd editDvd) {
        if (editDvd == null) {
            io.print("Couldn't find DVD in Library");
            return repeatAction("find another DVD");
        }else {
            return false;
        }
    }

    /**
     * Edits the info of a DVD based on the infoToEdit
     * 1. Title
     * 2. Release Date
     * 3. MPAA Rating
     * 4. Director's name
     * 5. Studio
     * 6. User Notes
     * 7. No info is edited
     * @param editDvd  DVD to be edited
     * @param infoToEdit the info which wants to be edited
     * @return  the DVD after the edit
     */
    public Dvd setNewMediaInfo(Dvd editDvd, int infoToEdit) {
        switch (infoToEdit) {
            case 1:
                editDvd.setTitle(io.readString("New Title:"));
                break;
            case 2:
                editDvd.getDvdInfo().setReleaseDate(io.readString("New Release Date:"));
                break;
            case 3:
                editDvd.getDvdInfo().setRatingMPAA(io.readString("New MPAA Rating:"));
                break;
            case 4:
                editDvd.getDvdInfo().setDirector(io.readString("New Director's name:"));
                break;
            case 5:
                editDvd.getDvdInfo().setStudio(io.readString("New User Notes:"));
                break;
            case 6:
                editDvd.getDvdInfo().setUserNotes(io.readString("New Title:"));
                break;
            default:
                io.print(editDvd.getTitle() + " was not edited");
        }
        return editDvd;
    }

    /**Shows to the user the DVD has been edited.
     * Then will ask if they want to edit the same DVD again
     * @param editDvd the DVD the user has edited
     * @return Boolean of whether the user want to edit the DVD again*/
    public boolean displayEditInfoResult(Dvd editDvd){
            io.print(editDvd.getTitle() + " has been edited in Library");
        return repeatAction(("edit " + editDvd.getTitle() + " again"));
    }

    /**
     * Ask the user if they want to edit the another DVD
     * @return Boolean of whether the user want to edit another DVD */
    public boolean displayEditDvdResult(){
        return repeatAction(("edit another DVD"));
    }

    /**Simple Banner saying we're editing a DVD from ID*/
    public void displayEditDvdBanner(){
        io.print("=^..^=   =^..^=   Edit DVD    =^..^=    =^..^=");
    }

    /**Simple Banner saying the user is exiting the App*/
    public void displayExitBanner(){
        io.print("Thank for Using DVD Library");
        io.print("=^..^=   =^..^=   GoodBye    =^..^=    =^..^=");
    }

    /**Simple Banner Unknown Input*/
    public void displayUnknownCommandBanner() {
        io.print("Unknown Input");
    }


    //repeat action//


    /**Prompts user if they want to repeat the action they have just done
     * and returns a boolean true and false
     * @param prompt what action the user wants to repeat, "Do you want to "+ prompt+ "? (y or n)"
     * @return true and false whether the user wants to repeat the action
     */
    public boolean repeatAction (String prompt){
        char answer = io.readChar("Do you want to "+ prompt + "? (y or n)");
        if(answer == 'y' || answer == 'Y'){       //sees if the user's answer contains y or Y
            return true;
        }
        return false;
    }

}
