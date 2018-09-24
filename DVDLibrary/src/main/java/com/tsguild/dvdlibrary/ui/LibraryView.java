package com.tsguild.dvdlibrary.ui;

import com.tsguild.dvdlibrary.dto.DVD;

/**
 *
 * @author souldj673
 */
public class LibraryView implements LibraryUI {

    private UserIO io;

    public LibraryView(UserIO myIo) {
        this.io = myIo;
    }

    @Override
    public int menus(String[] options) {
        for (String option : options) {
            io.print(option);
        }
        
        return io.readInt("Please select what you'd like to do: ");
    }

    @Override
    public void displayBanners(String title) {
        io.print("=== DVD Library - " + title + " ===");
    }

    @Override
    public DVD addDVD() {
        io.readString("What is the name of the movie? ");
        
    }

}
