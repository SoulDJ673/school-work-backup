package com.tsguild.dvdlibrary.ui;

import com.tsguild.dvdlibrary.dto.*;

/**
 *
 * @author souldj673
 */
public interface LibraryUI {

    /**
     * This method is used to create menus that display choices for the user.
     *
     * @param options - An array of possible choices
     * @return The option the user chose
     */
    int menus(String[] options);

    /**
     * This method simply displays a banner to let the user know where they're
     * at, and to make the program look nicer.
     *
     * @param title Let the user know where they're at
     */
    void displayBanners(String title);

    /**
     * This method is used to prompt the user to get the properties of the new
     * that's being added to the library. This returns a DVD to the controller,
     * which then sends it to the dao to be added to the library.
     *
     * @return DVD to be added
     */
    DVD addDVD();
}
