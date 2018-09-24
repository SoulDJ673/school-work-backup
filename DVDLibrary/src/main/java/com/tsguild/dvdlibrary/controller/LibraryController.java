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
        System.out.println("Test");
    }
}
