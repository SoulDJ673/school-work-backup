package com.tsguild.dvdlibrary.dao;

import com.tsguild.dvdlibrary.dto.DVD;
import java.io.FileNotFoundException;
import java.util.List;

/**
 *
 * @author souldj673
 */
public interface LibraryDao {

    //Java Docs !!!!
    /**
     * Adds the given DVD to the library and associates it with the given DVD
     * id. If there is already a DVD associated with the given DVD id it will
     * return that DVD object, otherwise it will return null.
     * 
     * An incoming DVD with an ID of -1 is a new DVD.  No IDs can be negative, 
     * and thus anything with such an ID is changed to something else throughout
     * the program. -1 is the default. Any other incoming negative IDs will not 
     * be changed here, as they aren't set by default anywhere in the program 
     * and are only used to skip ID changes. If a DVD that is written to the 
     * library has a negative ID, this is a bug and should be fixed immediately.
     *
     * @param dvd DVD to be added to the library
     * @param latestID - For giving new DVDs an ID
     * @return the DVD object previously associated with the given DVD id if it
     * exists, null otherwise
     * @throws java.io.FileNotFoundException If loadLibrary fails
     */
    DVD addDVD(DVD dvd, int latestID) throws FileNotFoundException;

    /**
     * Returns a String array containing the dvd ids of all dvds in the library.
     *
     * @return String array containing the ids of all the dvds in the library
     * @throws java.io.FileNotFoundException If loadLibrary fails
     */
    List<DVD> getAllDVDs() throws FileNotFoundException;

    /**
     * Returns the dvd object associated with the given dvd id. Returns null if
     * no such dvd exists
     *
     * @param dvdId ID of the dvd to retrieve
     * @return the DVD object associated with the given dvd id, null if no such
     * dvd exists
     * @throws java.io.FileNotFoundException
     */
    DVD getDVD(int dvdId) throws FileNotFoundException;

    /**
     * Removes from the library the dvd associated with the given id. Returns
     * the dvd object that is being removed or null if there is no dvd
     * associated with the given id
     *
     * @param dvdId id of dvd to be removed
     * @return DVD object that was removed or null if no dvd was associated with
     * the given dvd id
     * @throws java.io.FileNotFoundException If loadLibrary fails
     */
    DVD removeDVD(int dvdId) throws FileNotFoundException;

    /**
     * Edits an existing entry.
     *
     * @param changedDVD DVD object that is similar to the original, but with
     * changed parts
     * @throws java.io.FileNotFoundException If loadLibrary fails
     * @throws java.io.NullPointerException If given oldID doesn't exist
     */
    void editDVD(DVD changedDVD) throws FileNotFoundException, NullPointerException;

    /**
     * This method is used to load all information from the library file into
     * memory. This allows for library persistence.
     *
     * @throws java.io.FileNotFoundException
     */
    void loadLibrary() throws FileNotFoundException;

    /**
     * This method is used to write all information in memory into a library
     * file. This allows for library persistence.
     *
     * @throws java.io.FileNotFoundException
     */
    void writeLibrary() throws FileNotFoundException;

}
