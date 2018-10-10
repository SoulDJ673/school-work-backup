/*
 * Copyright (C) 2018 souldj673
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package com.tsguild.vendingmachine.service;

import com.tsguild.vendingmachine.dao.*;
import com.tsguild.vendingmachine.dto.*;
import java.math.BigDecimal;
import java.util.List;

/**
 *
 * @author souldj673
 */
public class VendingServiceImpl implements VendingService {

    VendingDAO dao = new VendingDAOImpl("inventory.txt");

    @Override
    public void loadMachine() throws VendingPersistenceException {
        dao.loadAllItems();
    }

    @Override
    public List<Item> getAllItemsInMachine() {
        return dao.getAllItems();
    }

    @Override
    public Item getOneItem(String itemCode) {
        return dao.getAnItem(itemCode);
    }

    @Override
    public ChangePurse purchaseItem(String itemCode, BigDecimal money) throws VendingInsufficientFundsException, VendingNoItemInventoryException, VendingPersistenceException {
        Item selectedItem = dao.getAnItem(itemCode);
        validateItem(selectedItem);
        
        if(money < selectedItem.getItemCost())
        
        ChangePurse updatedChangePurse = new ChangePurse();
        return updatedChangePurse;
    }

    private void validateItem(Item item) throws VendingNoItemInventoryException {
        if (item == null) {
            throw new VendingNoItemInventoryException("That item doesn't exist!");
        }
    }

}
