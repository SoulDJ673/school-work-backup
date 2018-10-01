package com.tsguild.addressbook.ui;

import com.tsguild.addressbook.dto.Address;
import java.util.List;

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
        io.print("   8. Return to main menu\n");
        return io.readInt("Select the desired operation to perform: ", 1, 8);
    }

    public Address editAddressId(Address wipAddress) {
        wipAddress.setId(io.readString("Enter the new ID: "));
        return wipAddress;
    }

    public Address editAddressOwner(Address wipAddress) {
        wipAddress.setOwnerFirstName(io.readString("Enter a new first name for the owner: "));
        wipAddress.setOwnerLastName(io.readString("Enter a new last name for the owner: "));
        return wipAddress;
    }

    public Address editAddressStreet(Address wipAddress) {
        wipAddress.setStreetAddress(io.readString("Enter the new street address: "));
        return wipAddress;
    }

    public Address editAddressCity(Address wipAddress) {
        wipAddress.setCity(io.readString("Enter the new city name: "));
        return wipAddress;
    }

    public Address editAddressState(Address wipAddress) {
        wipAddress.setState(io.readString("Enter the new state/providence name: "));
        return wipAddress;
    }

    public Address editAddressCountry(Address wipAddress) {
        wipAddress.setCountry(io.readString("Enter the new country name: "));
        return wipAddress;
    }

    public Address editAddressZip(Address wipAddress) {
        wipAddress.setZipCode(io.readString("Enter the new zip code: "));
        return wipAddress;
    }

    //Search for Address
    public int searchMenu() {
        io.print("   1. Search by Last Name");
        io.print("   2. Search by Entry ID\n");
        return io.readInt("Select the way you'd like to search: ", 1, 2);
    }

    //Differing Search Types
    public String searchName() {
        return io.readString("\nEnter the name you'd like to search for: ");
    }

    public String searchId() {
        return io.readString("\nEnter the ID you'd like to search for: ");
    }

    //Print Results of Search
    public void printSearchResults(Address address) {
        menuBanner("Displaying information for " + address.getStreetAddress());
        io.print("\nOwner: " + address.getOwnerFirstName() + " " + address.getOwnerLastName());
        io.print(address.getStreetAddress());
        io.print(address.getCity() + ", " + address.getState() + ", " + address.getCountry());
        io.print("Zip Code: " + address.getZipCode() + "\n");
    }

    //No Results
    public void noResults() {
        io.print("   There are no entries containing that query.\n");
    }

    //Remove Address
    public String deleteAddress() {
        String deleteID;
        int verify;

        deleteID = io.readString("Enter the ID of the entry you'd like to delete: ");
        verify = io.readInt("Are you sure that you want to delete entry " + deleteID + "? (Yes[1] / No[0]) ", 0, 1);

        if (verify == 0) {
            return null;
        } else {
            return deleteID;
        }
    }

    //List All Addresses
    public void displayAddressList(List<Address> addresses) {
        for (Address address : addresses) {
            io.print("\nEntry ID: " + address.getId());
            io.print("Owner: " + address.getOwnerFirstName() + " " + address.getOwnerLastName());
            io.print(address.getStreetAddress());
            io.print(address.getCity() + ", " + address.getState() + ", " + address.getCountry());
            io.print("Zip Code: " + address.getZipCode() + "\n");
        }
    }

    //Banner Template
    public void menuBanner(String text) {
        io.print("=== " + text + " ===");
    }

    //Errors
    public void errors(int error) {
        switch (error) {
            case 1:
                io.print("Unable to locate the Address Book file.  Make sure "
                        + "the file exists and isn't corrupt.\n");
                break;
            case 2:
                io.print("Please enter a valid ID");
                break;
        }
    }
}
