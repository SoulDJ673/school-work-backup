package com.tsguild.classmodeling;

/**
 *
 * @author souldj673
 */
public class Painting {

    private String subject;
    private String name;
    private String artistName;
    private int date;
    
    //All Args
    public Painting(String subject, String name, String artistName, int date) {
        this.subject = subject;
        this.name = name;
        this.artistName = artistName;
        this.date = date;
    }

    //Getters
    public String getSubject() {
        return this.subject;
    }

    public String getName() {
        return this.name;
    }

    public String getArtistName() {
        return this.artistName;
    }

    public int getDate() {
        return this.date;
    }

}
