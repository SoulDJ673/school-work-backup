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
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
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

    //Temporarily Hardcoded File - Remove This and Constructor Later
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

        //Create List for storing date orders
        List<Order> dayOrders = new ArrayList<>();
        while (scanner.hasNextLine()) {
            String marshalledOrder = scanner.nextLine();
            Order order = unmarshallOrder(marshalledOrder);
            dayOrders.add(order);

        }
        //Read LocalDate from first order to add to allOrders
        allOrders.put(dayOrders.get(0).getDeliveryDate(), dayOrders);
    }

    private void saveToFiles() {

    }

    private Order unmarshallOrder(String marshalledOrder) {
        /**
         * Order order
         *
         * OrderNumber,CustomerName,State,TaxRate,ProductType,Area,
         * CostPerSquareFoot,LaborCostPerSquareFoot,MaterialCost,LaborCost,Tax,
         * Total
         */
        String[] pieces = marshalledOrder.split(DELIMITER);

        //Can't create new Order object without first recreating the BigDecimals
        BigDecimal costPerSqrFt = new BigDecimal(pieces[6]);
        BigDecimal laborCostPerSqrFt = new BigDecimal(pieces[7]);

        //Compatibility with Sample Orders
        LocalDate deliveryDate;
        try {
            deliveryDate = LocalDate.parse(pieces[12]);
        } catch (Exception e) { //It won't accept OutOfBoundsException for some reason
            //We'll make it null so the date can be added back in loadFromFiles
            deliveryDate = null;
        }

        //Now construct
        Order order = new Order(Integer.parseInt(pieces[0]), pieces[1],
                pieces[2], Double.parseDouble(pieces[3]), pieces[4],
                Double.parseDouble(pieces[5]), costPerSqrFt, laborCostPerSqrFt,
                deliveryDate);
        
        return order;
    }

}
