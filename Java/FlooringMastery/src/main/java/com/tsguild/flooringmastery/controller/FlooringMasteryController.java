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
package com.tsguild.flooringmastery.controller;

import com.tsguild.flooringmastery.dto.Order;
import com.tsguild.flooringmastery.service.FlooringMasteryNoOrdersForDateException;
import com.tsguild.flooringmastery.service.FlooringMasteryService;
import com.tsguild.flooringmastery.view.FlooringMasteryView;
import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.util.List;

/**
 *
 * @author souldj673
 */
public class FlooringMasteryController {

    private FlooringMasteryView view;
    private FlooringMasteryService service;

    public FlooringMasteryController(FlooringMasteryView view, FlooringMasteryService service) {
        this.view = view;
        this.service = service;
    }

    public void run() {
        menuLoop:
        while (1 == 1) {
            try {

                int selection = view.mainMenu();
                switch (selection) {
                    case 1:
                        displayOrders();
                        break;
                    case 2:
                        createOrder();
                        break;
                    case 3:
                    case 4:
                        throw new UnsupportedOperationException("Sorry kiddo, can't do that yet.");
                    case 5:
                        view.temporaryLolMessage();
                        return;
                }
            } catch (FileNotFoundException e) {
                view.errors("FileNotFound");
            } catch (UnsupportedOperationException u) {
                view.errors("UnsupportedOperation");
            } catch (FlooringMasteryNoOrdersForDateException n) {
                view.errors("NoOrders");
            }
        }
    }

    private void displayOrders() throws FileNotFoundException, FlooringMasteryNoOrdersForDateException {
        LocalDate deliveryDate = view.getOrderDate();
        List<Order> dayOrders = service.getOrders(deliveryDate);
        view.displayOrders(dayOrders);
    }

    private void createOrder() {

    }

}
