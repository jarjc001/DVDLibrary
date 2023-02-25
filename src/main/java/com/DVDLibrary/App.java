package com.DVDLibrary;

import com.DVDLibrary.controller.DVDLibraryController;
import com.DVDLibrary.dao.DVDLibraryDao;
import com.DVDLibrary.dao.DVDLibraryDaoFileImpl;
import com.DVDLibrary.ui.DVDLibraryView;
import com.DVDLibrary.ui.UserIO;
import com.DVDLibrary.ui.UserIOConsoleImpl;

public class App {
    public static void main(String[] args) {
        UserIO myIo = new UserIOConsoleImpl();
        DVDLibraryView myView = new DVDLibraryView(myIo);
        DVDLibraryDao myDao = new DVDLibraryDaoFileImpl();
        DVDLibraryController controller = new DVDLibraryController(myView,myDao);
        controller.runApp();
    }
}