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
                    removeDvdFromLibrary();
                    break;
                case 3:
                    io.print("edit");
                    break;
                case 4:
                    displayDvdLibrary();
                    break;
                case 5:
                    displayDvdInfoId();
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
        Dvd newDvd;
        view.displayAddDvdBanner();  //Banner saying we're adding
        do {
            newDvd = view.getNewDvdInfo();              //creates a Dvd object from prompts
            doa.addDvd(newDvd);                             //adds Dvd to Library
        }while(view.displayAddSuccess(newDvd));
    }

    /**
     * Returns a list of the DVDs in the library and their IDs to the console
     */
    private void displayDvdLibrary(){
        view.displayDisplayListBanner();
        view.displayDvdList(doa.getAllDvd());
    }

    /**
     * The user is prompted to find the info for a DVD in the library
     * using the DVD ID, it will print the DVD info on the console
     * if it is in Library
     * Then after it is shown, they are asked again whether they want to show another
     */
    private void displayDvdInfoId (){
        Dvd dvd;
        view.displayDisplayDvdIdBanner();
        do {
            int dvdId = view.getDvdIdSearch();
            dvd = doa.getDvdFromId(dvdId);
        }while(view.displayDvd(dvd));
    }


    /**
     * The user is prompted to Search for a DVD in the library
     * using the DVD Title, it will print the DVD info on the console
     * if it is in Library
     */
    private void searchDvdTitle(){

    }




    /**
     * The user is prompted to remove a Dvd from the DVD Library using the dvd ID.
     * Then after it is removed, they are asked again whether they want to remove another
     */
    private void removeDvdFromLibrary(){
        Dvd removedDvd;
        view.displayRemoveDvdBanner();
        do{
            int dvdId = view.getDvdIdSearch();
            removedDvd = doa.removeDvd(dvdId);
        }while (view.displayRemoveResult(removedDvd));
    }



//    private void editDvdInLibrary(){
//        Dvd editDvd;
//        view.displayEditDvdBanner();
//        do{
//
//
//        }while ();




    }






}
