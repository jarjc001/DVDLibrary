package com.DVDLibrary.dao;

import com.DVDLibrary.dto.Dvd;

import java.util.List;

public abstract class DVDLibraryDao {


    /**
     * Adds the given DVD to the library. Not allowing for repeats.
     * If the DVD ID is the same as any in the Library,
     * the added DVD will replace the old one
     *
     * @return the DVD object, or null
     */
    public abstract Dvd addDvd(Dvd dvd);

    /**
     * Returns a List of all Dvds in the library.
     * @return List containing all DVDs in the Library.
     */
    public abstract List<Dvd> getAllDvd();

    /**
     * Returns the DVD object using the DVD's ID as a parameter,
     * Returns null if no DVD with the name exists
     * @param dvdId ID of the DVD to get
     * @return the DVD object of the given name or null,
     */
    public abstract Dvd getDvdFromId(int dvdId);

    /** Returns a list of DVD object whose Title contains dvdTitleTest,
     * @param dvdTitleTest Title of the DVD to test
     * @return list of DVD object whose Title contains the parameter Title,
     */
    public abstract List<Dvd> getDvdFromTitle(String dvdTitleTest);



    /**
     * Removes the DVD from the Library from its ID.
     * Returns the DVD that is being removed or null if
     * there is no DVD of the given Name
     * @param dvdId ID of Dvd to be removed
     * @return DVD object that was removed or null if no DVD
     * had the given name
     */
    public abstract Dvd removeDvd(int dvdId);

    /**
     * Tests to see if the DVD is null or not
     * @param dvd DVD to be tested
     * @return  whether the DVD is Null or not
     */
    public abstract boolean isDvdNull(Dvd dvd);

    /**Opens the txt file holding the DVD library when the program starts.
     * It transfers Library to the programs memory*/
    public abstract void openFile();

    /**When the program is exiting, it writes the DVD Library info from memory
     * to the txt file holding the data. It then closes the txt file.*/
    public abstract void closeFile();

}

