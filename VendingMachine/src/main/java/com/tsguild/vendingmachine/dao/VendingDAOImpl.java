package com.tsguild.vendingmachine.dao;

import com.tsguild.vendingmachine.dto.Item;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

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

    //Item Inventory
    Map<String, Item> inventory = new TreeMap<>();

    @Override
    public void loadAllItems() throws VendingPersistenceException {

        Scanner scanner;

        try {
            scanner = new Scanner(
                    new BufferedReader(
                            new FileReader(VENDING_INVENTORY)));

        } catch (FileNotFoundException ex) {
            throw new VendingPersistenceException("Couldn't find the inventory "
                    + "of the machine!");
        }

        String currentLine;
        Item currentItem = new Item(null);

        while (scanner.hasNextLine()) {
            currentLine = scanner.nextLine();
            currentItem = unmarshallItem(currentLine);
            inventory.put(currentItem.getId(), currentItem);
        }
        scanner.close();
    }

    private Item unmarshallItem(String marshalledItem) {
        
        String[] itemTokens = marshalledItem.split(DELIMITER);
        
        String id = itemTokens[0];
        Item newItem = new Item(id);
        
        return newItem;
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
