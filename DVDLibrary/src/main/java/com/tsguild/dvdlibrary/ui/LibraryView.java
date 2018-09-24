package com.tsguild.dvdlibrary.ui;

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
    public void menus(String[] options) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public void displayBanners(String title) {
        io.print("=== DVD Library - " + title + " ===");
    }
    
}
