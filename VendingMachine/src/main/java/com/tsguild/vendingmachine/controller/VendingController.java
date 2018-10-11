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

import com.tsguild.vendingmachine.dao.VendingDAO;
import com.tsguild.vendingmachine.dao.VendingDAOImpl;
import com.tsguild.vendingmachine.dto.ChangePurse;
import com.tsguild.vendingmachine.service.VendingService;
import com.tsguild.vendingmachine.service.VendingServiceImpl;

/**
 *
 * @author souldj673
 */
public class VendingController {

    private VendingDAO dao = new VendingDAOImpl("inventory.txt");
    private VendingService service = new VendingServiceImpl(dao);
    private ChangePurse userPurse;

    //This must run first, but only run once
    private void populateChangePurse() {

    }

    public void run() {
        populateChangePurse();
    }

    private void maintainenceMode() {

    }

}
