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

        return io.readInt("Please select what you'd like to do: ", 1, options.length);
    }

    @Override
    public void displayBanners(String title) {
        io.print("\n=== DVD Library - " + title + " ===");
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

    /**
     * See LibraryUI for full documentation
     *
     * Possible values of "type" as used in my implementation 
     * 1. Library File error 
     * 2. Null search results
     * 
     * If the values here are changed, the values that are being sent here must 
     * also be changed accordingly.
     */
    @Override
    public void errors(int type) {
        if (type == 1) {
            /**
             * This is called when there's a FileNotFoundException.
             * You can find it in the catch of the controller's run method.
             */
            io.print("There was an error reading or writing to the library file. "
                    + "Please check to ensure the file is in the correct location "
                    + "and isn't corrupt.  Exiting now...");
        } else if (type == 2) {
            /**
             * This is called when a search query wields no results.
             * You can find it in the validity check of the controller's 
             * searchDVD method.
             */
            io.print("No DVDs in your library matched your search.\n");
        }
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

    @Override
    public String searchDVD(String queryType) {
        String query = io.readString("Please input the " + queryType + " you'd "
                + "like to search by: ");

        return query;
    }

    @Override
    public int removeDVD() {
        return io.readInt("Enter the ID of the DVD you would like to remove: ");
    }

    @Override
    public boolean removalVerify(DVD tmpDVD) {
        String choice = io.readString("Are you sure you want to permanently "
                + "remove " + tmpDVD.getTitle() + "(ID " + tmpDVD.getId() + ")? "
                + "[y/n] ");

        switch (choice.toLowerCase()) {
            case "y":
            case "yes":
                return true;
            case "n":
            case "no":
                return false;
            default:
                io.print("Invalid input. Defaulting to no...");
                return false;
        }

    }

    @Override
    public String editDVD(int step) {
        switch (step) {
            //Method to select DVD to edit
            case 0:
                String[] options = {"1. I know the ID of the DVD I want to "
                    + "edit", "2. I don't know the ID of the DVD I want to "
                    + "edit", "3. Return to Main"};

                int selection = menus(options);
                String selectionS = selection + "";
                return selectionS;

            //Get ID of changing DVD
            case 1:
                int dvdID = io.readInt("Enter the ID of the DVD you'd like to edit: ");
                String dvdIDS = dvdID + "";
                return dvdIDS;

            //DVD property to change
            case 2:
                displayBanners("Editing DVD");

                String[] options2 = {"1. Change Title",
                    "2. Change Release Date", "3. Change Rating",
                    "4. Change Director", "5. Change Studio", "6. Change Notes",
                    "7. Return to Main"};

                int selection2 = menus(options2);

                String operation = selection2 + "";
                return operation;

            //Change properties that are Strings
            case 3:
                return io.readString("Enter new value: ");

            //ID cannot be changed
        }
        return null;
    }
}
