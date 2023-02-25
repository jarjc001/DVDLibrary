package com.DVDLibrary.dao;

import com.DVDLibrary.dto.Dvd;
import com.DVDLibrary.dto.DvdInfo;

import java.io.*;
import java.util.*;

public class DVDLibraryDaoFileExtend extends DVDLibraryDao{

    /**File name to hold DVD Library */
    private final String FILE_NAME = "dvd.txt";
    /** Delimiter of the DVD Library file*/
    private final String DELIMITER = ",";


    /**Map will act as the library of dvds held in the memory.
     *The key is the DVD's ID as an int
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



    @Override
    public void openFile() {
        File dataIn = new File(FILE_NAME);
        FileReader fileReader;
        String[] lineArray;

        try{
            fileReader = new FileReader(dataIn);
            BufferedReader br = new BufferedReader(fileReader);
            String lineFromLine;
            do{
                lineFromLine = br.readLine();
                if(lineFromLine != null){
                    lineArray = lineFromLine.split(DELIMITER);
                    String title = lineArray[0];
                    String releaseDate = lineArray[1];
                    String ratingMPAA = lineArray[2];
                    String director = lineArray[3];
                    String studio = lineArray[4];
                    String userNotes = lineArray[5];

                    DvdInfo inputDvdInfo = new DvdInfo(releaseDate,ratingMPAA,
                                                        director,studio,userNotes);

                    Dvd inputDvd = new Dvd(title,inputDvdInfo);

                    dvdLibrary.put(inputDvd.getDvdId(),inputDvd);
                }
            }while(lineFromLine != null);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }

    @Override
    public void closeFile(){
        File dataOut = new File(FILE_NAME);
        FileWriter fileWriter;

        try{
            fileWriter = new FileWriter(dataOut);
            PrintWriter pr = new PrintWriter(fileWriter);

            for(Dvd dvd:dvdLibrary.values()){
                pr.println(dvd.getTitle()+DELIMITER
                        +dvd.getDvdInfo().getReleaseDate()+DELIMITER
                        +dvd.getDvdInfo().getRatingMPAA()+DELIMITER
                        +dvd.getDvdInfo().getDirector()+DELIMITER
                        +dvd.getDvdInfo().getStudio()+DELIMITER
                        +dvd.getDvdInfo().getUserNotes()+DELIMITER);
            }
            pr.flush();
            pr.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
