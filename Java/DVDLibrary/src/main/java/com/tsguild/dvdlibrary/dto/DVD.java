package com.tsguild.dvdlibrary.dto;

/**
 *
 * @author souldj673
 */
public class DVD {

    //Properties
    private int id; //Here for possible later internal use (not user changable or visible)
    private String title;
    private String releaseDate;
    private String rating;
    private String director;
    private String studio;
    private String notes;

    //Constructor - No user defined args
    public DVD(int id) {
        this.id = id;
    }

    //Getters and Setters
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getStudio() {
        return studio;
    }

    public void setStudio(String studio) {
        this.studio = studio;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    //ID Getter & Setter - Not user editable
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

}
