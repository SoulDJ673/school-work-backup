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
     * Adds the given dvd to the library and associates it with the given dvd
     * id. If there is already a dvd associated with the given dvd id it will
     * return that dvd object, otherwise it will return null.
     *
     * @param dvdId id with which dvd is to be associated
     * @param dvd dvd to be added to the library
     * @return the DVD object previously associated with the given dvd id if it
     * exists, null otherwise
     * @throws java.io.FileNotFoundException If loadLibrary fails
     */
    DVD addDVD(String dvdId, DVD dvd) throws FileNotFoundException;

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
    DVD getDVD(String dvdId) throws FileNotFoundException;

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
    DVD removeDVD(String dvdId) throws FileNotFoundException;

    /**
     * Edits an existing entry with the provided id.
     *
     * @param oldId id of original entry
     * @param changedDVD DVD object that is similar to the original, but with
     * changed parts
     * @throws java.io.FileNotFoundException If loadLibrary fails
     */
    void editDVD(String oldId, DVD changedDVD) throws FileNotFoundException;

    /**
     * This method uses an incoming string and the .contains operator method to
     * return any titles that contain the aforementioned string.
     *
     * @param titleQuery - The incoming string
     * @return DVD List - matching DVDs
     * @throws FileNotFoundException If loadLibrary fails
     */
    List<DVD> searchDVD(String titleQuery) throws FileNotFoundException;

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
