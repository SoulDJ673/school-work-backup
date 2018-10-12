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

    }

    public void run() {
        populateChangePurse();

        try {
            service.loadMachine();
        } catch (VendingPersistenceException e) {
            view.errors(1);
        }

        String selection = view.mainMenu();
        selection = selection.toLowerCase();

        view.displayAvailableItems(service.getAllItemsInMachine());

    }

}
