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

        int[] coins = view.changePursePopulation();
        userPurse = new ChangePurse(coins[0], coins[1], coins[2], coins[3]);

        /*
         * Array: Pennies, Nickels, Dimes, Quarters // 0, 1, 2, 3
         */
    }

    public void run() {
        populateChangePurse();

        menuRepeat:
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

            //Check selection for quit
            switch (selection.toLowerCase()) {
                case "q":
                case "quit":
                case "exit":
                    return;
                default:
                    break;
            }

            //Retrieve item & Display information & Get User Purchase choice
            boolean purchaseChoice = displayItem(selection);

            try {
                if (purchaseChoice) {
                    userPurse = service.purchaseItem(selection, userPurse.getTotal());
                }
            } catch (VendingInsufficientFundsException ex) {
                view.errors(2);
            } catch (VendingNoItemInventoryException ex) {
                view.errors(3);
            } catch (VendingPersistenceException ex) {
                view.errors(1);
            }
        }
    }

    private boolean displayItem(String slotId) {
        try {
            Item userSelect = service.getOneItem(slotId);
            String purchaseChoice = view.displayItem(userSelect);

            boolean purchase;
            switch (purchaseChoice.toLowerCase()) {
                case "y":
                case "yes":
                case "true":
                    purchase = true;
                    break;
                default:
                    purchase = false;
                    break;
            }

            return purchase;

        } catch (NullPointerException e) {
            view.errors(3);
        }
        
        return false;
    }
}
