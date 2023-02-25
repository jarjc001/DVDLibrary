package com.DVDLibrary;

import com.DVDLibrary.controller.DVDLibraryController;
import com.DVDLibrary.dao.DVDLibraryDao;
import com.DVDLibrary.dao.DVDLibraryDaoFileExtend;
import com.DVDLibrary.ui.DVDLibraryViewConsoleImpl;
import com.DVDLibrary.ui.UserIO;
import com.DVDLibrary.ui.UserIOConsoleImpl;

public class App {
    public static void main(String[] args) {
        UserIO myIo = new UserIOConsoleImpl();
        DVDLibraryViewConsoleImpl myView = new DVDLibraryViewConsoleImpl(myIo);
        DVDLibraryDao myDao = new DVDLibraryDaoFileExtend();
        DVDLibraryController controller = new DVDLibraryController(myView,myDao);
        controller.runApp();
    }
}