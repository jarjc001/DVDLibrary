package com.DVDLibrary.dto;

public class Dvd {
    private String title;
    private DvdInfo dvdInfo;

    /**An ID for each DVD, as to make accessing them easier */
    private int dvdId;

    /**This variable is used to create an id for each dvd
     *Starting from 1 to the last dvd added to the library*/
    public static int overallId = 1;

    /**
     * A Constructor for the DVD object using all variables, this will hold all the info of each DVD
     * @param title DVD Title
     * @param dvdInfo DVD info
     */
        public Dvd(String title, DvdInfo dvdInfo){
        this.title = title;
        this.dvdInfo = dvdInfo;
        this.dvdId= overallId++;
    }


    //Getters
    public String getTitle() {
        return title;
    }
    public int getDvdId(){return dvdId;}
    public DvdInfo getDvdInfo(){return this.dvdInfo;}


    //Setters
    public void setTitle(String title) {
        this.title = title;
    }


    //To String for DVD Object

    @Override
    public String toString() {
        return "Dvd{" +
                "title='" + title + '\'' +
                ", dvdInfo=" + dvdInfo.toString() +
                ", dvdId=" + dvdId +
                '}';
    }
}
