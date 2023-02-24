package com.DVDLibrary.dao;

import com.DVDLibrary.dto.Dvd;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DVDLibraryDaoFileImpl extends DVDLibraryDao{

    /**Map will act as the library of dvds held in the memory
     *The key is the DVD's Id as an int
     *The Value is the DVD itself as a DVD object*/
    private Map<Integer, Dvd> dvdLibrary = new HashMap<>();


    @Override
    public void addDvd(Dvd dvd) {
        dvdLibrary.put(dvd.getDvdId(),dvd);
    }
    //maybe remove the return

    @Override
    public List<Dvd> getAllDvd() {
        return null;
    }

    @Override
    public Dvd getDvd(String dvdName) {
        return null;
    }

    @Override
    public Dvd removeDvd(String dvdName) {
        return null;
    }
}
