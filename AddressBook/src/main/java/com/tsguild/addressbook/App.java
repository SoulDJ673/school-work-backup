package com.tsguild.addressbook;

import com.tsguild.addressbook.controller.*;
import com.tsguild.addressbook.dao.*;
import com.tsguild.addressbook.ui.*;

/**
 *
 * @author souldj673
 */
public class App {

    public static void main(String[] args) {
        //Loose Coupling
        UserIO myIo = new UserIOConsoleImpl();
        AddressBookView myView = new AddressBookView(myIo);
        AddressBookDao myDao = new AddressBookDaoFileImpl();
        AddressBookController controller = new AddressBookController(myDao, myView);
        
        //Wake Up Controller
        controller.run();
    }
}
