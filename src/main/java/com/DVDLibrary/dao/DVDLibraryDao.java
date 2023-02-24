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


    /** Returns the DVD object using the DVD's Name as a parameter,
     * Returns null if no DVD with the name exists
     * @param dvdTitle Title of the DVD to get
     * @return the DVD object of the given name or null,
     */
    public abstract Dvd getDvdFromTitle(String dvdTitle);



    /**
     * Removes the DVD from the Library from its Id.
     * Returns the DVD that is being removed or null if
     * there is no DVD of the given Name
     * @param dvdId ID of Dvd to be removed
     * @return DVD object that was removed or null if no DVD
     * had the given name
     */
    public abstract Dvd removeDvd(int dvdId);

    //Could use id for remove dvd, maybe easiler than typing the name


}

