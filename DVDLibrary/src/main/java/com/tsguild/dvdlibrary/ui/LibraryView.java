package com.tsguild.dvdlibrary.ui;

import com.tsguild.dvdlibrary.dto.DVD;
import java.util.List;

/**
 *
 * @author souldj673
 */
public class LibraryView implements LibraryUI {

    private UserIO io;

    public LibraryView(UserIO myIo) {
        this.io = myIo;
    }

    @Override
    public int menus(String[] options) {
        for (String option : options) {
            io.print(option);
        }

        return io.readInt("Please select what you'd like to do: ");
    }

    @Override
    public void displayBanners(String title) {
        io.print("=== DVD Library - " + title + " ===");
    }

    @Override
    public DVD addDVD() {
        //Blank DVD
        DVD newDVD = new DVD(-1); //-1 used for unlabelled dvds

        //Var Declare
        String dvdName;
        String dvdDate;
        String rating;
        String director;
        String studio;
        String notes;

        //DVD Info
        dvdName = io.readString("What is the name of the movie? ");
        dvdDate = io.readString("What is the release date of the movie? ");
        rating = io.readString("What is the movie's MPAA Rating? ");
        director = io.readString("Who directed the movie? ");
        studio = io.readString("Which studio produced the movie? ");
        notes = io.readString("What else would you like to say about the movie? ");

        //Write Info to DVD
        newDVD.setTitle(dvdName);
        newDVD.setReleaseDate(dvdDate);
        newDVD.setRating(rating);
        newDVD.setDirector(director);
        newDVD.setStudio(studio);
        newDVD.setNotes(notes);

        //Return new DVD
        return newDVD;
    }

    @Override
    public void fileError() {
        io.print("There was an error reading or writing to the library file. "
                + "Please check to ensure the file is in the correct location "
                + "and isn't corrupt.  Exiting now...");
    }

    @Override
    public void displayAllDVDs(List<DVD> allDVDs) {
        int pageCount = 0;
        int pager = 0;
        for (DVD dvd : allDVDs) {
            if (pager % 10 == 0) {
                pageCount += 1;
                displayBanners("Page " + pageCount);
            }
            io.print(dvd.getId() + ": " + dvd.getTitle());
            pager++;
        }
    }

}
