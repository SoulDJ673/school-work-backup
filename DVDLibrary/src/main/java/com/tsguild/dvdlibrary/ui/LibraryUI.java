package com.tsguild.dvdlibrary.ui;

/**
 *
 * @author souldj673
 */
public interface LibraryUI {

    /**
     * This method is used to create menus that display choices for the user.
     *
     * @param options - An array of possible choices
     */
    void menus(String[] options);

    /**
     * This method simply displays a banner to let the user know where they're
     * at, and to make the program look nicer.
     *
     * @param title Let the user know where they're at
     */
    void displayBanners(String title);
}
