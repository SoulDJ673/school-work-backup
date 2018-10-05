package com.tsguild.vendingmachine.dao;

import com.tsguild.vendingmachine.dto.Item;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author souldj673
 */
public class VendingDAOImpl implements VendingDAO {

    private final String VENDING_INVENTORY;
    private final String DELIMITER = "::";

    public VendingDAOImpl(String InvFile) {
        this.VENDING_INVENTORY = InvFile;
    }

    @Override
    public void loadAllItems() throws VendingPersistenceException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private Item unmarshallItem() throws VendingPersistenceException {

        try {
            Scanner scanner = new Scanner(
                    new BufferedReader(
                            new FileReader(VENDING_INVENTORY)));

        } catch (FileNotFoundException ex) {
            throw new VendingPersistenceException("Couldn't find the inventory "
                    + "of the machine!");
        }
    }

    @Override
    public void saveAllChanges() throws VendingPersistenceException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private Item marshallItem() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List getAllItems() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Item getAnItem(String slotId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void updateAnItem(String slotId, Item changedItem) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Item removeAnItem(String slotId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Item addItem(Item anItem) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
