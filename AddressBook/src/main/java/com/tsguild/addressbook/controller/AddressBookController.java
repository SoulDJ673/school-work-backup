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

    }

    public int getMenuAndSelection() {
        myView.menuBanner();
        return myView.mainMenu();
    }

}
