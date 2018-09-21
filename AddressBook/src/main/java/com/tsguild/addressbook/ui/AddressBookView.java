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
        io.print("   6. List All Addresses");
        io.print("   7. Exit\n");
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

    //Address Editing
    public String editAddressSelect() {
        String changingAddressId;
        changingAddressId = io.readString("Please enter the ID of the entry you wish to edit: ");
        return changingAddressId;
    }

    public int editAddressMenu() {
        io.print("   1. Change ID");
        io.print("   2. Change Owner Name");
        io.print("   3. Change Address");
        io.print("   4. Change City");
        io.print("   5. Change State/Providence");
        io.print("   6. Change Country");
        io.print("   7. Change Zip Code");
        io.print("   8. Return to main menu");
        return io.readInt("Select the desired operation to perform: ", 1, 8);
    }

    public Address editAddressId(Address wipAddress) {

    }

    public Address editAddressOwner(Address wipAddress) {

    }

    public Address editAddressStreet(Address wipAddress) {

    }

    public Address editAddressCity(Address wipAddress) {

    }

    public Address editAddressState(Address wipAddress) {

    }

    public Address editAddressCountry(Address wipAddress) {

    }

    public Address editAddressZip(Address wipAddress) {

    }

    //Banner Template
    public void menuBanner(String text) {
        io.print("=== " + text + " ===");
    }

}
