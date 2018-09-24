package com.tsguild.dvdlibrary.dao;

import com.tsguild.dvdlibrary.dto.DVD;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author souldj673
 */
public class LibraryDaoImpl implements LibraryDao {

    private String LIBRARY_FILE;
    private String DELIMITER = " :: ";

    //Loose Coupling
    public LibraryDaoImpl(String LibFile) {
        this.LIBRARY_FILE = LibFile;
    }

    @Override
    public void loadLibrary() throws FileNotFoundException {
        //Scanner Init
        Scanner scanner;
        try {
            new Scanner(
                    new BufferedReader(new FileReader(LIBRARY_FILE)));

        } catch (Exception FileNotFoundException) {
            throw new FileNotFoundException("The library could not be found!");
        }

        String currentLine;

        scanner.nextLine()
    }

    @Override
    public void writeLibrary() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public DVD addDVD(String dvdId, DVD dvd) throws FileNotFoundException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<DVD> getAllDVDs() throws FileNotFoundException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public DVD getDVD(String dvdId) throws FileNotFoundException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public DVD removeDVD(String dvdId) throws FileNotFoundException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void editDVD(String oldId, DVD changedDVD) throws FileNotFoundException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<DVD> searchDVD(String titleQuery) throws FileNotFoundException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
