package com.tsguild.vendingmachine.dao;

import com.tsguild.vendingmachine.dto.Item;
import java.util.List;

/**
 *
 * @author souldj673
 */
public interface VendingDAO {

    public void loadAllItems()
            throws VendingPersistenceException;

    public void saveAllChanges()
            throws VendingPersistenceException;

    public Item addItem(Item anItem);

    public List<Item> getAllItems();

    public Item getAnItem(String slotId);

    public void updateAnItem(String slotId, Item changedItem);

    public Item removeAnItem(String slotId);
}
