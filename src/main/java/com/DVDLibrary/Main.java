package com.DVDLibrary;

import com.DVDLibrary.controller.DVDLibraryController;
import com.DVDLibrary.ui.UserIOConsoleImpl;

public class Main {
    public static void main(String[] args) {
        DVDLibraryController controller = new DVDLibraryController();
        controller.runApp();
    }
}