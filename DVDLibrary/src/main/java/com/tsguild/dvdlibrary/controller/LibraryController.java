package com.tsguild.dvdlibrary.controller;

import com.tsguild.dvdlibrary.dao.*;
import com.tsguild.dvdlibrary.dto.*;
import com.tsguild.dvdlibrary.ui.*;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author souldj673
 */
public class LibraryController {

    LibraryDao myDao;
    LibraryUI myView;

    //Loose Coupling
    public LibraryController(LibraryDao myDao, LibraryUI myView) {
        this.myDao = myDao;
        this.myView = myView;
    }

    public void run() {
        try {
            while (true) {
                int selection = mainMenuSelect();

                switch (selection) {
                    case 1:
                        addDVD();
                        break;
                    case 2:
                        removeDVD();
                        break;
                    case 3:
                        editDVD();
                        break;
                    case 4:
                        listDVDs();
                        break;
                    case 5:
                        searchDVD();
                        break;
                    case 6:
                        return;
                }
            }
        } catch (FileNotFoundException e) {
            error();
        }
    }

    private int mainMenuSelect() {
        myView.displayBanners("Main Menu");
        //Create Array to set choices into in ViewImpl
        String[] selections = {"1. Add DVD", "2. Remove DVD", "3. Edit DVD",
            "4. List all DVDs", "5. Search DVD", "6. Exit"};

        return myView.menus(selections);
    }

    private void addDVD() throws FileNotFoundException {
        myView.displayBanners("Add DVD");

        DVD newDVD = myView.addDVD();
        myDao.addDVD(newDVD, getLatestID());
    }

    private void removeDVD() throws FileNotFoundException {
        myView.displayBanners("Remove DVD");

        String[] options = {"1. I know the ID of the DVD I'd like to remove",
            "2. I don't know the ID of the DVD I want to remove", "3. Never "
            + "mind, I don't want to remove anything"};
        int selection = myView.menus(options);

        switch (selection) {
            case 1:
                break;
            case 2:
                searchDVD();
                break;
            default:
                return;
        }
        //For Recovery
        DVD tmpDVD = myDao.removeDVD(myView.removeDVD());
        boolean verify = myView.removalVerify(tmpDVD);

        if (!verify) {
            myDao.addDVD(tmpDVD, getLatestID());
            return;
        }

        myView.displayBanners("Successful Removal");

    }

    /**
     * This method runs through all of the DVDs and returns the next available
     * id
     *
     * @return Next Available ID
     * @throws FileNotFoundException
     */
    private int getLatestID() throws FileNotFoundException {
        List<DVD> dvdLibrary = myDao.getAllDVDs();

        for (int i = 0; i < dvdLibrary.size(); i++) {
            if (dvdLibrary.isEmpty()) {
                return i;
            }
        }

        //No empty spaces between ids
        return (dvdLibrary.size() + 1);

    }

    private void editDVD() throws FileNotFoundException {
        myView.displayBanners("Edit DVD");

        //Prompt user to enter DVD ID or search for DVD
        int entrySelect = Integer.parseInt(myView.editDVD(0));
        switch (entrySelect) {
            case 1:
                break;
            case 2:
                searchDVD();
                break;
            case 3:
                return;
        }

        //Prompt user to enter DVD ID
        DVD tmpDVD = new DVD(Integer.parseInt(myView.editDVD(1)));
        tmpDVD = myDao.getDVD(tmpDVD.getId());

        menuRepeat:
        while (true) {
            //Prompt user to Select Property to edit
            entrySelect = Integer.parseInt(myView.editDVD(2));

            switch (entrySelect) {
                case 1:
                    tmpDVD.setTitle(myView.editDVD(3));
                    break;
                case 2:
                    tmpDVD.setReleaseDate(myView.editDVD(3));
                    break;
                case 3:
                    tmpDVD.setRating(myView.editDVD(3));
                    break;
                case 4:
                    tmpDVD.setDirector(myView.editDVD(3));
                    break;
                case 5:
                    tmpDVD.setStudio(myView.editDVD(3));
                    break;
                case 6:
                    tmpDVD.setNotes(myView.editDVD(3));
                    break;
                case 7:
                    break menuRepeat;
            }
        }
        myDao.editDVD(tmpDVD);

    }

    private void listDVDs() throws FileNotFoundException {
        myView.displayAllDVDs(myDao.getAllDVDs());
    }

    private List<DVD> searchingDVD(String titleQuery) throws FileNotFoundException {

        List<DVD> library = myDao.getAllDVDs();
        List<DVD> results = new ArrayList<>();

        titleQuery = titleQuery.toLowerCase();

        for (DVD dvd : library) {
            String title = dvd.getTitle();
            title = title.toLowerCase();
            if (title.contains(titleQuery)) {
                results.add(dvd);
            } else {
                title = null;
            }
        }
        return results;
    }

    private void searchDVD() throws FileNotFoundException {

        myView.displayBanners("Search for DVD");

        String[] selections = {"1. By ID", "2. By Title", "3. Return to Main"};
        int selection = myView.menus(selections);

        List<DVD> results = new ArrayList<>();

        repeatIfError:
        while (true) {
            try {
                switch (selection) {
                    case 1:
                        results.add(myDao.getDVD(Integer.parseInt(myView.searchDVD("ID"))));
                        break repeatIfError;
                    case 2:
                        results.clear();
                        results = searchingDVD(myView.searchDVD("title"));
                        break repeatIfError;
                    case 3:
                        return;
                }
            } catch (Exception e) {
                myView.displayBanners("Error - Wrong Input Type");
            }
        }
        //Validity Check
        if (results.isEmpty()) {
            myView.errors(2);
        } else {
            DVD check = results.get(0);
            if (check.getId() == -2) {
                myView.errors(2);
            } else {
                myView.displayBanners("Search Complete: " + results.size()
                        + " matching results.");
                myView.displayAllDVDs(results);
            }
        }
    }

    private void error() {
        myView.displayBanners("ERROR");
        myView.errors(1);
    }
}
