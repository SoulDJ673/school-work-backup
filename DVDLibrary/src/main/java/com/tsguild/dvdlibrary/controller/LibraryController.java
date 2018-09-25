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
        myDao.addDVD(newDVD);
    }

    private void removeDVD() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void editDVD() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void listDVDs() throws FileNotFoundException {
        myView.displayAllDVDs(myDao.getAllDVDs());
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
                        results = myDao.searchDVD(myView.searchDVD("title"));
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
