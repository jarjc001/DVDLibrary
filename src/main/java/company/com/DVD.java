package company.com;

public class DVD {
    private String title;
    private int releaseDate;
    private int ratingMPAA;;
    private String director;
    private String studio;
    private String userNotes;

    //Constructors

    public DVD() {
    }

    public DVD(String title, int releaseDate, int ratingMPAA, String director, String studio, String userNotes){
        this.title = title;
        this.releaseDate = releaseDate;
        this.ratingMPAA =  ratingMPAA;
        this.director = director;
        this.studio = studio;
        this.userNotes = userNotes;
    }

    //Getters
    public String getTitle() {
        return title;
    }

    public int getReleaseDate() {
        return releaseDate;
    }

    public int getRatingMPAA() {
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
    public void setTitle(String title) {
        this.title = title;
    }

    public void setReleaseDate(int releaseDate) {
        this.releaseDate = releaseDate;
    }

    public void setRatingMPAA(int ratingMPAA) {
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

    //ToString
    @Override
    public String toString() {
        return "DVD{" +
                "title='" + title + '\'' +
                ", releaseDate=" + releaseDate +
                ", ratingMPAA=" + ratingMPAA +
                ", director='" + director + '\'' +
                ", studio='" + studio + '\'' +
                ", userNotes='" + userNotes + '\'' +
                '}';
    }
}
