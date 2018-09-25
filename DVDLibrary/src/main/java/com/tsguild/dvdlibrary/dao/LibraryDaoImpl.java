package com.tsguild.dvdlibrary.dao;

import com.tsguild.dvdlibrary.dto.DVD;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author souldj673
 */
public class LibraryDaoImpl implements LibraryDao {

    private String LIBRARY_FILE;
    private String DELIMITER = " :: ";

    private Map<Integer, DVD> dvdLibrary = new HashMap<>();

    //Loose Coupling
    public LibraryDaoImpl(String LibFile) {
        this.LIBRARY_FILE = LibFile;
    }

    @Override
    public void loadLibrary() throws FileNotFoundException {
        //Scanner Init
        Scanner scanner;
        try {
            scanner = new Scanner(
                    new BufferedReader(new FileReader(LIBRARY_FILE)));

        } catch (FileNotFoundException e) {
            throw new FileNotFoundException("The library could not be found!");
        }

        String currentLine;
        DVD currentDVD;

        while (scanner.hasNextLine()) {

            currentLine = scanner.nextLine();
            currentDVD = unmarshallDVD(currentLine);

            dvdLibrary.put(currentDVD.getId(), currentDVD);
        }
        scanner.close();
    }

    /**
     * This method creates a DVD from a line in the library file or from a
     * provided line passed to the method from some other source.
     *
     * @param dvdLine
     * @return
     */
    private DVD unmarshallDVD(String dvdLine) {
        /**
         * id :: title :: releaseDate :: rating :: director :: studio :: notes
         * [0] [1] [2] [3] [4] [5] [6]
         */
        String[] dvdInfo = dvdLine.split(DELIMITER);

        DVD tempDVD = new DVD(Integer.parseInt(dvdInfo[0]));

        tempDVD.setTitle(dvdInfo[1]);
        tempDVD.setReleaseDate(dvdInfo[2]);
        tempDVD.setRating(dvdInfo[3]);
        tempDVD.setDirector(dvdInfo[4]);
        tempDVD.setStudio(dvdInfo[5]);
        tempDVD.setNotes(dvdInfo[6]);

        return tempDVD;
    }

    @Override
    public void writeLibrary() throws FileNotFoundException {
        PrintWriter dump;
        try {
            dump = new PrintWriter(new FileWriter(LIBRARY_FILE));
        } catch (IOException e) {
            throw new FileNotFoundException("Failed to write library to file.");
        }

        String textDVD;
        List<DVD> library = this.getAllDVDs();
        for (DVD dvd : library) {
            textDVD = marshallDVD(dvd);
            dump.println(textDVD);
            dump.flush();
        }
        dump.close();

    }

    private String marshallDVD(DVD dvd) {
        /**
         * id :: title :: releaseDate :: rating :: director :: studio :: notes
         * [0] [1] [2] [3] [4] [5] [6]
         */

        String dvdText;

        dvdText = dvd.getId() + DELIMITER
                + dvd.getTitle() + DELIMITER
                + dvd.getReleaseDate() + DELIMITER
                + dvd.getRating() + DELIMITER
                + dvd.getDirector() + DELIMITER
                + dvd.getStudio() + DELIMITER
                + dvd.getNotes();

        return dvdText;
    }

    @Override
    public DVD addDVD(DVD dvd) throws FileNotFoundException {
        //Always make sure map is up to date
        loadLibrary();

        //Change default id to next available id
        if (dvd.getId() == -1) {
            dvd.setId(getLatestID());
        }

        //Add to library
        dvdLibrary.put(dvd.getId(), dvd);
        writeLibrary();
        return dvd;
    }

    /**
     * This method runs through all of the DVDs and returns the next available
     * id
     *
     * @return Next Available ID
     * @throws FileNotFoundException
     */
    private int getLatestID() throws FileNotFoundException {
        loadLibrary();

        for (int i = 0; i < dvdLibrary.size(); i++) {
            if (dvdLibrary.isEmpty()) {
                return i;
            }
        }

        //No empty spaces between ids
        return (dvdLibrary.size() + 1);

    }

    @Override
    public List<DVD> getAllDVDs() throws FileNotFoundException {
        loadLibrary();
        return new ArrayList<>(dvdLibrary.values());
    }

    @Override
    public DVD getDVD(int dvdId) throws FileNotFoundException {
        boolean valid = dvdLibrary.containsKey(dvdId);

        if (valid) {
            return dvdLibrary.get(dvdId);
        } else {
            return new DVD(-2);
            /**
             * Can't return null without breaking stuff. Negative IDs are
             * reserved for special cases, such as this. -2 will be used here to
             * represent a null DVD (nothing matched the search) because a null
             * ID can not be used.
             */
        }
    }

    @Override
    public DVD removeDVD(int dvdId) throws FileNotFoundException {

        loadLibrary();
        DVD tmpDVD = dvdLibrary.remove(dvdId);
        writeLibrary();

        return tmpDVD;
    }

    @Override
    public void editDVD(DVD changedDVD) throws FileNotFoundException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
