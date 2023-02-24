package com.DVDLibrary.dao;

import com.DVDLibrary.dto.Dvd;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DVDLibraryDaoFileImpl extends DVDLibraryDao{

    /**Map will act as the library of dvds held in the memory.
     *The key is the DVD's Id as an int
     *.The Value is the DVD itself as a DVD object*/
    private Map<Integer, Dvd> dvdLibrary = new HashMap<>();


    @Override
    public Dvd addDvd(Dvd dvd) {
        return dvdLibrary.put(dvd.getDvdId(),dvd);
    }

    @Override
    public List<Dvd> getAllDvd() {
        return new ArrayList<Dvd>(dvdLibrary.values());
    }

    @Override
    public Dvd getDvdFromId(int dvdId) {
        return dvdLibrary.get(dvdId);
    }

    @Override
    public Dvd getDvdFromTitle(String dvdTitle){
        return null;
    }

    @Override
    public Dvd removeDvd(int dvdId) {    //id needs to be int
        return dvdLibrary.remove(dvdId);
    }


}
