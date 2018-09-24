package com.tsguild.dvdlibrary.controller;

import com.tsguild.dvdlibrary.dao.*;
import com.tsguild.dvdlibrary.ui.*;

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
        while (true) {
            int selection = mainMenuSelect();

            switch (selection) {
                case 1:
                    addDVD();
                case 2:
                    removeDVD();
                case 3:
                    editDVD();
                case 4:
                    listDVDs();
                case 5:
                    searchDVD();
            }
        }
    }

    private int mainMenuSelect() {
        myView.displayBanners("Main Menu");
        //Create Array to set choices into in ViewImpl
        String[] selections = {"1. Add DVD", "2. Remove DVD", "3. Edit DVD",
            "4. List all DVDs", "5. Search DVD"};

        return myView.menus(selections);
    }

    private void addDVD() {
        
    }

    private void removeDVD() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void editDVD() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void listDVDs() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void searchDVD() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
