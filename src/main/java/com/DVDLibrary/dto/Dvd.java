package com.DVDLibrary.dto;

public class Dvd {
    private String title;
    private String releaseDate;
    private String ratingMPAA;
    private String director;
    private String studio;
    private String userNotes;

    /**An Id for each DVD, as to make accessing them easier */
    private int dvdId;

    /**This variable is used to create an id for each dvd
     *Starting from 1 to the last dvd added to the library*/
    public static int overallId = 1;

    /**
     * A Constructor for the DVD object using all variables, this will hold all the info of each DVD
     * @param title
     * @param releaseDate
     * @param ratingMPAA
     * @param director
     * @param studio
     * @param userNotes
     */
        public Dvd(String title, String releaseDate, String ratingMPAA, String director, String studio, String userNotes){
        this.title = title;
        this.releaseDate = releaseDate;
        this.ratingMPAA =  ratingMPAA;
        this.director = director;
        this.studio = studio;
        this.userNotes = userNotes;
        this.dvdId= overallId++;
    }

    /**
     * A Constructor for the DVD object using only it's name
     * @param title
     */
    public Dvd(String title) {
        this.title = title;
        this.dvdId= overallId++;
    }

    //Getters
    public String getTitle() {
        return title;
    }
    public String getReleaseDate() {
        return releaseDate;
    }
    public String getRatingMPAA() {
        return ratingMPAA;
    }
    public String getDirector() {
        return director;
    }
    public String getStudio() {
        return studio;
    }
    public String getUserNotes() {
        return userNotes;
    }
    public int getDvdId(){return dvdId;}


    //Setters
    public void setTitle(String title) {
        this.title = title;
    }
    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }
    public void setRatingMPAA(String ratingMPAA) {
        this.ratingMPAA = ratingMPAA;
    }
    public void setDirector(String director) {
        this.director = director;
    }
    public void setStudio(String studio) {
        this.studio = studio;
    }
    public void setUserNotes(String userNotes) {
        this.userNotes = userNotes;
    }


    //To String for DVD Object
    @Override
    public String toString() {
        return "Dvd{" +
                "title='" + title + '\'' +
                ", releaseDate='" + releaseDate + '\'' +
                ", ratingMPAA='" + ratingMPAA + '\'' +
                ", director='" + director + '\'' +
                ", studio='" + studio + '\'' +
                ", userNotes='" + userNotes + '\'' +
                ", dvdId=" + dvdId +
                '}';
    }
}
