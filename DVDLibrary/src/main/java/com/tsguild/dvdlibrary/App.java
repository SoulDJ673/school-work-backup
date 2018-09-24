package com.tsguild.dvdlibrary;

import com.tsguild.dvdlibrary.controller.*;
import com.tsguild.dvdlibrary.dao.*;
import com.tsguild.dvdlibrary.ui.*;

/**
 *
 * @author souldj673
 */
public class App {

    public static void main(String[] args) {
        //Loose Coupling
        UserIO io = new UserIOConsoleImpl();
        //Custom file extension >:)
        LibraryDao dao = new LibraryDaoImpl("DVDLibrary.dlloyd");
        LibraryUI ui = new LibraryView(io);
        LibraryController dvdControl = new LibraryController(dao, ui);

        dvdControl.run();
    }
}
