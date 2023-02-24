package com.DVDLibrary.dao;

import com.DVDLibrary.dto.Dvd;

import java.util.List;

public abstract class DVDLibraryDao {
    /**
     * Adds the given DVD to the library. Not allowing for repeats
     * @return the DVD object, or null
     */
    public abstract void addDvd(Dvd dvd);

    /**
     * Returns a List of all Dvds in the library.
     * @return List containing all DVDs in the Library.
     */
    public abstract List<Dvd> getAllDvd();

    /**
     * Returns the DVD object with the DVD's Name
     * Returns null if no DVD with the name exists
     * @param dvdName ID of the DVD to get
     * @return the DVD object of the given name or null,
     */
    public abstract Dvd getDvd(String dvdName);
    //.Contain to help find the film maybe
    //will properly have to turn it into an array

    /**
     * Removes the DVD from the Library from its name.
     * Returns the DVD that is being removed or null if
     * there is no DVD of the given Name
     * @param dvdName Name of student to be removed
     * @return DVD object that was removed or null if no DVD
     * had the given name
     */
    public abstract Dvd removeDvd(String dvdName);

    //Could use id for remove dvd, maybe easiler than typing the name
}

