package com.tsguild.addressbook.controller;

import com.tsguild.addressbook.dao.*;
import com.tsguild.addressbook.dto.*;
import com.tsguild.addressbook.ui.*;

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
                }
            }
        } catch (Exception e) {

        }
    }

    private int getMenuAndSelection() {
        myView.menuBanner("Main Menu");
        return myView.mainMenu();
    }
    
    //Display Banner & Add Address
    private void addAddress() throws AddressBookDaoException {
        myView.menuBanner("Add Address");
        Address newAddress = myView.addAddress();
        myDao.addAddress(newAddress.getId(), newAddress);
    }
    
    //Display Banner & Edit Address
    private void editAddress() throws AddressBookDaoException {
        myView.menuBanner("Edit Address");
    }

}
