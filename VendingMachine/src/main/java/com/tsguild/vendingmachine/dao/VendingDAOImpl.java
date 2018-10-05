package com.tsguild.vendingmachine.dao;

import com.tsguild.vendingmachine.dto.Item;
import java.util.List;

/**
 *
 * @author souldj673
 */
public class VendingDAOImpl implements VendingDAO {

    @Override
    public void loadAllItems() throws VendingPersistenceException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private Item unmarshallItem() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void saveAllChanges() throws VendingPersistenceException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private Item marshallItem() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void addItem(Item anItem) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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

}
