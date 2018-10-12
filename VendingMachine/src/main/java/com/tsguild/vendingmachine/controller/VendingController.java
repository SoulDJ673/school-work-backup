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
package com.tsguild.vendingmachine.controller;

import com.tsguild.vendingmachine.dao.VendingPersistenceException;
import com.tsguild.vendingmachine.dto.ChangePurse;
import com.tsguild.vendingmachine.dto.Item;
import com.tsguild.vendingmachine.service.VendingInsufficientFundsException;
import com.tsguild.vendingmachine.service.VendingNoItemInventoryException;
import com.tsguild.vendingmachine.service.VendingService;
import com.tsguild.vendingmachine.view.VendingView;
import java.math.BigDecimal;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author souldj673
 */
public class VendingController {

    private VendingService service;
    private VendingView view;
    private ChangePurse userPurse;

    public VendingController(VendingService myService, VendingView myView) {
        this.service = myService;
        this.view = myView;
    }

    //This must run first, but only run once
    private void populateChangePurse() {

    }

    public void run() {
        populateChangePurse();

        while (true) {

            //Load the inventory
            try {
                service.loadMachine();
            } catch (VendingPersistenceException e) {
                view.errors(1);
            }

            //List all items in inventory
            view.displayAvailableItems(service.getAllItemsInMachine());

            //Allow user to select an item
            String selection = view.mainMenu();
            selection = selection.toLowerCase();

            //Retrieve item & Display information & Get User Purchase choice
            boolean purchaseChoice = displayItem(selection);

            try {
                if (purchaseChoice) {

                    service.purchaseItem(selection, userPurse.getTotal());

                }
            } catch (VendingInsufficientFundsException e) {
                view.errors(2);
            } catch (VendingNoItemInventoryException ex) {
                view.errors(3);
            } catch (VendingPersistenceException ex) {
                view.errors(1);
            }
        }
    }

    private boolean displayItem(String slotId) {
        Item userSelect = service.getOneItem(slotId);
        String purchaseChoice = view.displayItem(userSelect);

        boolean purchase;
        switch (purchaseChoice.toLowerCase()) {
            case "y":
            case "yes":
            case "true":
                purchase = true;
            default:
                purchase = false;
        }

        return purchase;
    }

}
