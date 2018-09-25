package com.tsguild.dvdlibrary.ui;

import com.tsguild.dvdlibrary.dto.*;
import java.util.List;

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

    /**
     * This is used to print out error messages.
     * 
     * 1. Library File error
     * 2. Null search results
     * 
     * @param type - Used to specify type of error to print
     */
    void errors(int type);

    /**
     * This method is used to print out all of the DVDs in the collection or any
     * other given List of DVDs.  It does this in pages of 10. THIS ONLY PRINTS 
     * THE TITLES AND IDs, NOTHING ELSE!!!
     * 
     * @param allDVDs 
     */
    void displayAllDVDs(List<DVD> allDVDs);
    
    /**
     * This is used to collect the user's search query and send it back through
     * the controller to the dao.
     * 
     * @param queryType -  Used for the user input prompt
     * @return Query
     */
    String searchDVD(String queryType);
    
    /**
     * This is used to collect the ID of the DVD the user would like to remove.
     * 
     * @return 
     */
    int removeDVD();
    
    /**
     * This is simply a method that prompts the user to verify their decision 
     * before a DVD is permanently removed
     * 
     * @param tmpDVD - The deleted DVD.  Passed in for title and ID use in prompt
     * @return 
     */
    boolean removalVerify(DVD tmpDVD);
}
