package com.tsguild.addressbook.ui;

/**
 *
 * @author souldj673
 */
public class AddressBookView {

    UserIO io;

    //Dependency Injection
    public AddressBookView(UserIO myIo) {
        this.io = myIo;
    }

    public int mainMenu() {
        io.print("   1. Add Address");
        io.print("   2. Edit Address Information");
        io.print("   3. Remove Address");
        io.print("   4. Find Address");
        io.print("   5. List Address Count");
        io.print("   6. List All Addresses\n");
        return io.readInt("Select the desired operation to perform: ", 1, 7);
    }

    //Banners
    public void menuBanner() {
        io.print("=== Main Menu ===");
    }
    
    public void addBanner() {
        io.print("=== Add Address ===");
    }

}
