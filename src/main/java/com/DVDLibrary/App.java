package com.DVDLibrary;

import com.DVDLibrary.controller.DVDLibraryController;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {
    public static void main(String[] args) {
        //normal DI
//        UserIO myIo = new UserIOConsoleImpl();
//        DVDLibraryView myView = new DVDLibraryView(myIo);
//        DVDLibraryDao myDao = new DVDLibraryDaoFileExtend();
//        DVDLibraryController controller = new DVDLibraryController(myView,myDao);


        //Telling compiler we are using annotations
        AnnotationConfigApplicationContext appContext = new AnnotationConfigApplicationContext();
        //Scan recurively from com.DVDLibrary for applicable annotations
        appContext.scan("com.DVDLibrary");
        //Refresh
        appContext.refresh();

        //name should normally start with lower case
        DVDLibraryController controller = appContext.getBean("DVDLibraryController", DVDLibraryController.class);


        controller.runApp();
    }
}