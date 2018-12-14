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
package com.tsguild.flooringmastery.service;

import com.tsguild.flooringmastery.dao.FlooringMasteryModeErrorException;
import com.tsguild.flooringmastery.dto.Order;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

/**
 *
 * @author souldj673
 */
public interface FlooringMasteryService {

    /**
     * This method takes the incoming LocalDate and finds the send it to the DAO
     * to find the corresponding orders, and returns the Map given back to it
     * that contains the orders and their IDs. This can also just be used to
     * load the orders for a particular date into the date specific map in the
     * DAO.
     *
     * @param deliveryDate
     * @return Map with IDs and Order objects
     * @throws FileNotFoundException
     * @throws FlooringMasteryNoOrdersForDateException
     */
    public List getOrders(LocalDate deliveryDate) throws FileNotFoundException, FlooringMasteryNoOrdersForDateException;

    /**
     * Simple call to orderDao, validates before return
     *
     * @param orderId
     * @return
     * @throws com.tsguild.flooringmastery.service.FlooringMasteryInvalidOrderException
     */
    public Order getOrder(int orderId) throws FlooringMasteryInvalidOrderException;

    /**
     * This method simply gets the latest order ID
     *
     * @return
     */
    public int getLastID();

    public Order validateOrder(Order order) throws FlooringMasteryInvalidOrderException;

    public Order addOrder(Order order);

    public List getProducts() throws FileNotFoundException;

    public List getStates() throws FileNotFoundException;

    public boolean getMode() throws FileNotFoundException, FlooringMasteryModeErrorException;

    public Order removeOrder(int orderId);

    public void saveOrders() throws IOException;

}
