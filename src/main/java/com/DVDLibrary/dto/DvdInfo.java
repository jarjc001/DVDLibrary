package com.DVDLibrary.dto;

public class DvdInfo {
    //use as an object to hold dvd info
    //show composition

    private String  releaseDate;
    private String ratingMPAA;
    private String director;
    private String studio;
    private String userNotes;

    /**
     * A Constructor for the DVD Info object. It holds the DVD's info that isn't its title or name
     * @param releaseDate DVD release Date
     * @param ratingMPAA  DVD MPPA rating
     * @param director  DVD Director
     * @param studio    DVD Studio
     * @param userNotes DVD User's Notes
     */
    public DvdInfo(String releaseDate, String ratingMPAA, String director, String studio, String userNotes) {
        this.releaseDate = convertDateSlash(releaseDate);
        this.ratingMPAA = ratingMPAA;
        this.director = director;
        this.studio = studio;
        this.userNotes = userNotes;
    }

    //Getters
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

    //Setters
    public void setReleaseDate(String releaseDate) {
        this.releaseDate = convertDateSlash(releaseDate);
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

    /**takes in the release date in either / , or none and returns it as / format
     * / -> dd/mm/yyyy1
     * , -> dd,mm,yyyy
     *   -> ddmmyyyy
     * @return date as dd/mm/yyyy
     **/
    private String convertDateSlash(String dateFormat){
        //checks if the input date at least has a day, month and year
        if(dateFormat.length()<5){
            return ("dd/mm/yyyy Invalid Release Date Given");
        }

        String[] dateArray = new String[3];
        if (dateFormat.contains("/")){
            dateArray = dateFormat.split("/");
        }else if (dateFormat.contains(",")){
            dateArray = dateFormat.split(",");
        }else {
            dateArray[0] = dateFormat.substring(0,2);
            dateArray[1] = dateFormat.substring(2,4);
            dateArray[2] = dateFormat.substring(4);
        }
        return (dateArray[0]+ "/" + dateArray[1]+ "/" + dateArray[2]);
    }


    @Override
    public String toString() {
        return "DvdInfo{" +
                "releaseDate=" + releaseDate +
                ", ratingMPAA=" + ratingMPAA +
                ", director='" + director + '\'' +
                ", studio='" + studio + '\'' +
                ", userNotes='" + userNotes + '\'' +
                '}';
    }
}
