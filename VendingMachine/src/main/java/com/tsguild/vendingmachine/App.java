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
package com.tsguild.vendingmachine;

import com.tsguild.vendingmachine.controller.VendingController;
import com.tsguild.vendingmachine.dao.VendingDAO;
import com.tsguild.vendingmachine.dao.VendingDAOImpl;
import com.tsguild.vendingmachine.service.VendingService;
import com.tsguild.vendingmachine.service.VendingServiceImpl;
import com.tsguild.vendingmachine.view.UserIO;
import com.tsguild.vendingmachine.view.UserIOConsoleImpl;
import com.tsguild.vendingmachine.view.VendingView;

/**
 *
 * @author souldj673
 */
public class App {

    private static final VendingDAO DAO = new VendingDAOImpl("inventory.txt");
    private static final VendingService SERVICE = new VendingServiceImpl(DAO);
    private static final UserIO IO = new UserIOConsoleImpl();
    private static final VendingView VIEW = new VendingView(IO);
    private static final VendingController CONTROLLER = new VendingController(SERVICE, VIEW);
    
    public static void main(String[] args) {
        CONTROLLER.run();
    }

}
