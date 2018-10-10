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
        ChangePurse updatedChangePurse = new ChangePurse();

        if (money.compareTo(selectedItem.getItemCost()) < 0) {
            throw new VendingInsufficientFundsException("You don't have enough "
                    + "money for that item!");
        } else {
            BigDecimal moneyDifference = money.subtract(
                    selectedItem.getItemCost());
            updatedChangePurse = calculateCoinsBack(moneyDifference);
            
            
        }
        return updatedChangePurse;
    }

    private void validateItem(Item item) throws VendingNoItemInventoryException {
        if (item == null) {
            throw new VendingNoItemInventoryException("That item doesn't exist!");
        } else if (item.getItemCount() == 0) {
            throw new VendingNoItemInventoryException("There is no more of that"
                    + " item left in the machine.  Sorry for the inconvienince!");
        }
    }

    private ChangePurse calculateCoinsBack(BigDecimal difference) {
        //Values in BigDecimal
        BigDecimal penny = new BigDecimal(.01);
        BigDecimal nickel = new BigDecimal(.05);
        BigDecimal dime = new BigDecimal(.1);
        BigDecimal quarter = new BigDecimal(.25);

        //Get Coin Counts
        BigDecimal[] quarters = difference.divideAndRemainder(quarter);
        BigDecimal[] dimes = quarters[1].divideAndRemainder(dime);
        BigDecimal[] nickels = dimes[1].divideAndRemainder(nickel);
        BigDecimal pennies = nickels[1].divide(penny);

        //Convert to Integers for updated purse creation
        int quarterCount = quarters[0].intValue();
        int dimeCount = dimes[0].intValue();
        int nickelCount = nickels[0].intValue();
        int pennyCount = pennies.intValue();

        ChangePurse updatedPurse = new ChangePurse(pennyCount, nickelCount, dimeCount, quarterCount);
        return updatedPurse;
    }

}
