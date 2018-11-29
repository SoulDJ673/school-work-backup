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
package com.tsguild.flooringmastery.dao;

import com.tsguild.flooringmastery.dto.Order;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author souldj673
 */
public class FlooringMasteryOrderDaoImpl implements FlooringMasteryOrderDao {

    private final Map<Integer, Order> ordersForDay = new HashMap<>();
    private final Map<LocalDate, List<Order>> allOrders = new HashMap<>();

    private final String DELIMITER = ",";

    //Temporarily Hardcoded File
    private final String TEMPHARDCODEDDATE;

    public FlooringMasteryOrderDaoImpl(String dateLocation) throws FileNotFoundException {
        TEMPHARDCODEDDATE = dateLocation;
        this.loadFromFiles();
    }

    public FlooringMasteryOrderDaoImpl() throws FileNotFoundException {
        this.loadFromFiles();
        TEMPHARDCODEDDATE = null;
    }

    @Override
    public Map<Integer, Order> displayOrders() {
        return ordersForDay;
    }

    @Override
    public Order addOrder(Order theOrder) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void editOrder(Order theOrder) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Order removeOrder(int orderId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mapOrdersForDate(LocalDate date) {
        //If ordersForDay isn't empty, clear it and reload
        if (!ordersForDay.isEmpty()) {
            ordersForDay.clear();
        }

        /**
         * Grab a List of orders from the specified date from allOrders, run
         * through the returned list and add them to ordersForDay
         */
        for (Order order : allOrders.get(date)) {
            ordersForDay.put(order.getOrderNum(), order);
        }
    }

    //Load/Save all from/to files
    private void loadFromFiles() throws FileNotFoundException {
        Scanner scanner = new Scanner(new BufferedReader(
                new FileReader(TEMPHARDCODEDDATE)));

        while (scanner.hasNextLine()) {
            Order order = unmarshallOrder();
        }
    }

    private void saveToFiles() {

    }

}
