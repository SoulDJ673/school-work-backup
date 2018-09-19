package com.tsguild.addressbook.ui;

import com.tsguild.addressbook.dto.Address;

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

    //Add Address
    public Address addAddress() {
        String id = io.readString("   Please give this entry an ID: ");
        Address newAddress = new Address(id);

        //Set remaining properties with getters/setters
        newAddress.setOwnerFirstName(io.readString("   Enter the first name of the current resident: "));
        newAddress.setOwnerLastName(io.readString("   Enter the last name of the current resident: "));
        newAddress.setStreetAddress(io.readString("   Enter the street address: "));
        newAddress.setCity(io.readString("   Enter the city of residence: "));
        newAddress.setState(io.readString("  Enter the state/providence/whatever of residence: "));
        newAddress.setCountry(io.readString("   Enter the country of residence: "));
        newAddress.setZipCode(io.readString("   Enter the associated zip code: "));

        return newAddress;
    }

    //Banner Template
    public void menuBanner(String text) {
        io.print("=== " + text + " ===");
    }

}
