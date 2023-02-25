package com.DVDLibrary.dao;

import com.DVDLibrary.dto.Dvd;

import java.util.*;

public class DVDLibraryDaoFileExtend extends DVDLibraryDao{

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
    public List<Dvd> getDvdFromTitle(String dvdTitleTest){
        Set<Integer> IdSet = dvdLibrary.keySet();
        List<Dvd> dvdList = new ArrayList<>();
        for (int id: IdSet){
            if(dvdLibrary.get(id).getTitle().contains(dvdTitleTest)){    //
                //adds the DVD to dvdList if it's title contains dvdTitleTest
                dvdList.add(dvdLibrary.get(id));
            }
        }
        return dvdList;
    }

    @Override
    public Dvd removeDvd(int dvdId) {    //id needs to be int
        return dvdLibrary.remove(dvdId);
    }

    @Override
    public boolean isDvdNull(Dvd dvd) {
        if (dvd == null){
            return true;
        }
        return false;
    }




    //add file look up


}
