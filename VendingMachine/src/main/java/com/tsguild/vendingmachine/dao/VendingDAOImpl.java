package com.tsguild.vendingmachine.dao;

import com.tsguild.vendingmachine.dto.Item;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.util.ArrayList;
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
    private Map<String, Item> inventory = new TreeMap<>();

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
        Item currentItem;

        while (scanner.hasNextLine()) {
            currentLine = scanner.nextLine();
            currentItem = unmarshallItem(currentLine);
            inventory.put(currentItem.getId(), currentItem);
        }
        scanner.close();
    }

    private Item unmarshallItem(String marshalledItem) {

        /**
         * slotId | itemName | itemCost | itemCount [0] [1] [2] [3]
         */
        String[] itemTokens = marshalledItem.split(DELIMITER);

        String id = itemTokens[0];
        Item newItem = new Item(id);
        BigDecimal itemCost = new BigDecimal(itemTokens[2]);

        newItem.setItemName(itemTokens[1]);
        newItem.setItemCost(itemCost);
        newItem.setItemCount(Integer.parseInt(itemTokens[3]));

        return newItem;
    }

    @Override
    public void saveAllChanges() throws VendingPersistenceException {
        PrintWriter save;
        try {
            save = new PrintWriter(new FileWriter(VENDING_INVENTORY));
        } catch (IOException e) {
            throw new VendingPersistenceException("Uh oh! The inventory is "
                    + "nowhere to be found! Unable to write to inventory.");
        }

        String textItem;
        List<Item> allItems = getAllItems();

        for (Item currentItem : allItems) {
            textItem = marshallItem(currentItem);
            save.println(textItem);
            save.flush();
        }

        save.close();
    }

    private String marshallItem(Item unmarshalledItem) {

        /**
         * slotId | itemName | itemCost | itemCount [0] [1] [2] [3]
         */
        String marshalledItem
                = unmarshalledItem.getId() + DELIMITER
                + unmarshalledItem.getItemName() + DELIMITER
                + unmarshalledItem.getItemCost().toString() + DELIMITER
                + unmarshalledItem.getItemCount();

        return marshalledItem;
    }

    @Override
    public List getAllItems() {
        List<Item> allItems = new ArrayList<>(inventory.values());
        return allItems;
    }

    @Override
    public Item getAnItem(String slotId) {
        return inventory.get(slotId);
    }

    @Override
    public void updateAnItem(String slotId, Item changedItem) {
        addItem(changedItem);
    }

    @Override
    public Item removeAnItem(String slotId) {
        return inventory.remove(slotId);
    }

    @Override
    public Item addItem(Item anItem) {
        inventory.put(anItem.getId(), anItem);
        return anItem;
    }

}
