package com.tsguild.vendingmachine.service;

import com.tsguild.vendingmachine.dao.VendingPersistenceException;
import com.tsguild.vendingmachine.dto.Item;
import java.math.BigDecimal;
import java.util.List;

/**
 *
 * @author souldj673
 */
public interface VendingService {
    
    public void loadMachine() 
        throws VendingPersistenceException;
    
    public List<Item> getAllItemsInMachine();
    public Item getOneItem(String itemCode);
    
    public ChangePurse purchaseItem(String itemCode, BigDecimal money)
        throws VendingInsufficientFundsException, 
               VendingNoItemInventoryException, 
               VendingPersistenceException;
    
}
