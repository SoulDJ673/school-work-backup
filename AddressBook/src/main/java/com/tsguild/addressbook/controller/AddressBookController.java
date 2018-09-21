package com.tsguild.addressbook.controller;

import com.tsguild.addressbook.dao.*;
import com.tsguild.addressbook.dto.*;
import com.tsguild.addressbook.ui.*;
import java.io.FileNotFoundException;

/**
 *
 * @author souldj673
 */
public class AddressBookController {

    AddressBookView myView;
    AddressBookDao myDao;

    //Dependency Injection
    public AddressBookController(AddressBookDao myDao, AddressBookView myView) {
        this.myView = myView;
        this.myDao = myDao;
    }

    //"Main" method
    public void run() {
        int menuSelect = 0;
        boolean repeat = true;
        try {
            while (repeat) {
                menuSelect = getMenuAndSelection();

                //Determine Next Option
                switch (menuSelect) {
                    case 1:
                        addAddress();
                        break;
                    case 2:
                        editAddress();
                        break;
                    case 3:
                        removeAddress();
                        break;
                    case 4:
                        findAddress();
                        break;
                    case 5:
                        listAddressCount();
                        break;
                    case 6:
                        listAllAddreses();
                        break;
                    case 7:
                        repeat = false;

                }
            }
        } catch (Exception FileNotFoundException) {
            myView.menuBanner("ERROR");
        }
    }

    private int getMenuAndSelection() {
        myView.menuBanner("Main Menu");
        return myView.mainMenu();
    }

    //Display Banner & Add Address
    private void addAddress() throws FileNotFoundException {
        myView.menuBanner("Add Address");
        Address newAddress = myView.addAddress();
        myDao.addAddress(newAddress.getId(), newAddress);
    }

    //Display Banner & Edit Address
    private void editAddress() throws FileNotFoundException {
        int menuSelect = 0;
        boolean repeat = true;

        String addressId = myView.editAddressSelect();

        Address changingAddress = myDao.getAddress(addressId);
        String oldId = changingAddress.getId();

        menuLoop:
        while (repeat) {
            myView.menuBanner("Edit Address");
            menuSelect = myView.editAddressMenu();
            switch (menuSelect) {
                case 1:
                    changingAddress = myView.editAddressId(changingAddress);
                    break;
                case 2:
                    changingAddress = myView.editAddressOwner(changingAddress);
                    break;
                case 3:
                    changingAddress = myView.editAddressStreet(changingAddress);
                    break;
                case 4:
                    changingAddress = myView.editAddressCity(changingAddress);
                    break;
                case 5:
                    changingAddress = myView.editAddressState(changingAddress);
                    break;
                case 6:
                    changingAddress = myView.editAddressCountry(changingAddress);
                    break;
                case 7:
                    changingAddress = myView.editAddressZip(changingAddress);
                    break;
                case 8:
                    repeat = false;
            }

        }

        myDao.editAddress(oldId, changingAddress);
    }

    //Display Banner & Find Address
    private void findAddress() throws FileNotFoundException {
        myView.menuBanner("Find Address");
        int menuSelect = myView.searchMenu();

        String query;

        switch (menuSelect) {
            case 1:
                query = myView.searchName();
                if (!myDao.checkQueryNull(query, 0)) {
                    myView.menuBanner("Search Complete");
                    myView.printSearchResults(myDao.getAddressByName(myView.searchName(), 0));

                } else {
                    myView.menuBanner("Search Complete");
                    myView.noResults();
                }
                break;
            case 2:
                query = myView.searchName();
                if (!myDao.checkQueryNull(query)) {
                    myView.menuBanner("Search Complete");
                    myView.printSearchResults(myDao.getAddress(myView.searchId()));

                } else {
                    myView.menuBanner("Search Complete");
                    myView.noResults();
                }
                break;
        }
    }

    //Display Banner & Remove Address
    private void removeAddress() throws FileNotFoundException {
        myView.menuBanner("Remove Address");
        myDao.removeAddress(myView.deleteAddress());

    }

    //Display Banner & List All Addresses
    private void listAllAddreses() throws FileNotFoundException {
        myView.menuBanner("Address List");
        myView.displayAddressList(myDao.getAllAddresss());
    }

    //Display Banner & List Address Count
    private void listAddressCount() {

    }

}
