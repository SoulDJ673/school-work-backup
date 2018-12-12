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

import com.tsguild.flooringmastery.dao.FlooringMasteryModeErrorException;
import com.tsguild.flooringmastery.dto.Order;
import com.tsguild.flooringmastery.dto.Product;
import com.tsguild.flooringmastery.dto.TaxRate;
import com.tsguild.flooringmastery.service.FlooringMasteryInvalidOrderException;
import com.tsguild.flooringmastery.service.FlooringMasteryNoOrdersForDateException;
import com.tsguild.flooringmastery.service.FlooringMasteryService;
import com.tsguild.flooringmastery.view.FlooringMasteryView;
import java.io.FileNotFoundException;
import java.io.IOException;
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

        boolean isProductionMode = false;
        try {
            isProductionMode = service.getMode();
        } catch (FileNotFoundException ex) {
            view.errors("ModeNoneError");
            return;
        } catch (FlooringMasteryModeErrorException ex) {
            view.errors("ModeInvalidError");
            return;
        }
        if (!isProductionMode) {
            view.notices("TrainingMode");
        } else {
            view.notices("ProductionMode");
        }

        //This is to make sure that at least one orders file exists.
        try {
            service.getOrders(LocalDate.now());
        } catch (FileNotFoundException f) {
            view.errors("FileNotFoundPreTest");

        } catch (FlooringMasteryNoOrdersForDateException n) {
            /**
             * This is to be expected. This should be thrown because orders must
             * be set to delivered in the future.
             */
        }
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
                        editOrder();
                    case 4:
                        removeOrder();
                        break;
                    case 5:
                        save();
                        break;
                    case 6:
                        boolean leave = saveAndExit();
                        if (leave) {
                            return;
                        }
                }
            } catch (FileNotFoundException e) {
                view.errors("FileNotFound");
            } catch (UnsupportedOperationException u) {
                view.errors("UnsupportedOperation");
            } catch (FlooringMasteryNoOrdersForDateException n) {
                view.errors("NoOrders");
            } catch (IOException i) {
                view.errors("IOException");
            } catch (FlooringMasteryEmergencyEscape e) {
                return;
            }
        }
    }

    private void displayOrders() throws FileNotFoundException, FlooringMasteryNoOrdersForDateException {
        LocalDate deliveryDate = view.getOrderDate();
        List<Order> dayOrders = service.getOrders(deliveryDate);
        view.displayOrders(dayOrders);
    }

    /**
     * For this, you need to throw an exception for an invalid order in the
     * validation stage, and only return an order if it's valid. This should fix
     * the issue that's been happening. Also, make a more specific exception.
     *
     * @throws FileNotFoundException
     */
    private void createOrder() throws FileNotFoundException {
        int lastestID = service.getLastID();
        List<TaxRate> states = service.getStates();
        List<Product> products = service.getProducts();
        Order theOrder = view.createOrder(lastestID, states, products, null);

        //Validation and fixing
        Order validMaybe;
        boolean fixed = false;

        do {
            try {
                validMaybe = service.validateOrder(theOrder);
                fixed = true;
            } catch (FlooringMasteryInvalidOrderException o) {
                view.errors("InvalidOrder");
                validMaybe = view.createOrder(lastestID, states, products, theOrder);
            }
        } while (!fixed);
        Order confirmOrder;
        confirmOrder = view.creationConfirmationPrompt(validMaybe);

        //If user confirms, add to Order map
        if (confirmOrder != null) {
            service.addOrder(confirmOrder);
        }

    }

    private void removeOrder() {
        /**
         * An ID of -69 can not be achieved. It is a magic number that is only
         * used to return to the main menu.
         */
        int orderId = view.removeOrderIdGrabber();
        Order grabbedOrder;

        if (orderId == -69) {
            return;
        } else {
            grabbedOrder = service.getOrder(orderId);
        }

        /**
         * removeOrderConfirmPrompt - Add here If true, remove Order. False will
         * keep order.
         */
        boolean remove = view.removeOrderConfirmPrompt(grabbedOrder);
        if (remove) {
            service.removeOrder(orderId);
            view.notices("OperationSuccess");
        }

    }

    /**
     * This method will return true if the user wants to exit, and false to
     * return to the main menu.
     *
     * @return
     */
    private boolean saveAndExit() throws IOException {
        int choice = view.saveAndExit();
        switch (choice) {
            case 1:
                return false;
            case 2:
                return true;
            case 3:
                try {
                    if (service.getMode()) {
                        service.saveOrders();
                        return true;
                    } else {
                        view.errors("WrongMode");
                        return true;
                    }
                } catch (FileNotFoundException | FlooringMasteryModeErrorException f) {
                    view.errors("PostStartModeError");
                    return true;
                }
        }

        //It shouldn't get here, but if it does, return to main
        return false;
    }

    private void save() throws IOException, FlooringMasteryEmergencyEscape {
        try {
            if (service.getMode()) {
                service.saveOrders();
            } else {
                view.errors("WrongMode");
            }
        } catch (FileNotFoundException | FlooringMasteryModeErrorException f) {
            view.errors("PostStartModeError");
            throw new FlooringMasteryEmergencyEscape();
        }
    }

    private void editOrder() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
