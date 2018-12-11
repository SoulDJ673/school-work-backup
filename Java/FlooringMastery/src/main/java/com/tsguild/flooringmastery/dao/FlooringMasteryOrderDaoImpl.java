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
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
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
    private final File orderDirectory; //Reading from Directories!!!

    private final String DELIMITER = ",";

    public FlooringMasteryOrderDaoImpl(String orderDir) {
        orderDirectory = new File(orderDir);
    }

    @Override
    public List<Order> getOrders() {
        //Convert Collection to List
        List<Order> dayOrders = new ArrayList<>();

        for (Order order : ordersForDay.values()) {
            dayOrders.add(order);
        }

        return dayOrders;
    }

    @Override
    public Map<LocalDate, List<Order>> getAllOrders() {
        return allOrders;
    }

    @Override
    public Order addOrder(Order theOrder) {
        //Make sure correct day is loaded
        try {
            this.mapOrdersForDate(theOrder.getDeliveryDate());
        } catch (FileNotFoundException f) {
            /**
             * This exception is only thrown when the specified file name given
             * to the scanner doesn't exist, but since the name would not be
             * given to scanner unless it exists, this shouldn't happen.
             */
        }
        this.ordersForDay.put(theOrder.getOrderNum(), theOrder);
        return theOrder;
    }

    @Override
    public void editOrder(Order theOrder) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Order removeOrder(int orderId) {
        return ordersForDay.remove(orderId);
    }

    @Override
    public void mapOrdersForDate(LocalDate date) throws FileNotFoundException {

        /**
         * If ordersForDay isn't empty, add it's contents to allOrders, then
         * clear it and reload
         */
        if (!ordersForDay.isEmpty()) {
            List<Order> dayOrders = new ArrayList<>();
            for (Order order : ordersForDay.values()) {
                dayOrders.add(order);
            }
            allOrders.put(dayOrders.get(0).getDeliveryDate(), dayOrders);
            ordersForDay.clear();
        }

        /**
         * Only call loadFromFiles() if there aren't any key/value pairs in
         * allOrders (don't wanna overwrite any unsaved changes!
         */
        if (allOrders.isEmpty() && ordersForDay.isEmpty()) {
            loadFromFiles();
        }

        /**
         * Grab a List of orders from the specified date from allOrders, run
         * through the returned list and add them to ordersForDay
         */
        try {
            for (Order order : allOrders.get(date)) {
                ordersForDay.put(order.getOrderNum(), order);
            }
        } catch (NullPointerException n) {
            ordersForDay.clear();
        }
    }

    //Load all from files
    private void loadFromFiles() throws FileNotFoundException {
        String[] orderFiles = orderDirectory.list(); //Get Order File names
        for (String fileName : orderFiles) { //Iterate over each file

            //Separate the Date from the rest of the fileName
            String fileDeliveryDate = fileName.replace("Orders_", "");
            fileDeliveryDate = fileDeliveryDate.replace(".txt", "");

            //Parse LocalDate from fileDeliveryDate
            DateTimeFormatter fileFormat = DateTimeFormatter.ofPattern("MMddyyyy");
            LocalDate deliveryDate = LocalDate.parse(fileDeliveryDate, fileFormat);
            deliveryDate.format(DateTimeFormatter.ofPattern("MM-dd-yyyy"));

            //Add rest of directory to fileName
            fileName = "Orders/" + fileName;

            Scanner scanner = new Scanner(new BufferedReader(
                    new FileReader(fileName)));

            //Create List for storing date orders
            List<Order> dayOrders = new ArrayList<>();
            while (scanner.hasNextLine()) {
                String marshalledOrder = scanner.nextLine();
                Order order = unmarshallOrder(marshalledOrder, deliveryDate);

                //Don't add a null object
                if (order != null) {
                    dayOrders.add(order);
                }
            }
            //Read LocalDate from first order to add to allOrders
            allOrders.put(dayOrders.get(0).getDeliveryDate(), dayOrders);
            scanner.close();
        }
    }

    private Order unmarshallOrder(String marshalledOrder, LocalDate deliveryDate) {
        /**
         * Order order
         *
         * OrderNumber,CustomerName,State,TaxRate,ProductType,Area,
         * CostPerSquareFoot,LaborCostPerSquareFoot,MaterialCost,LaborCost,Tax,
         * Total
         */
        String[] pieces = marshalledOrder.split(DELIMITER);

        /**
         * Don't return any invalid information (Formatting hint from Sample
         * File) Check to make sure orderId is actually an ID
         */
        try {
            Integer.parseInt(pieces[0]);
        } catch (NumberFormatException e) {
            return null;
        }

        //Can't create new Order object without first recreating the BigDecimals
        BigDecimal costPerSqrFt = new BigDecimal(pieces[6]);
        BigDecimal laborCostPerSqrFt = new BigDecimal(pieces[7]);

        //Now construct
        Order order = new Order(Integer.parseInt(pieces[0]), pieces[1],
                pieces[2], Double.parseDouble(pieces[3]), pieces[4],
                Double.parseDouble(pieces[5]), costPerSqrFt, laborCostPerSqrFt,
                deliveryDate);

        return order;
    }

    private void saveToFiles() {

    }

    /**
     * This method will loop through all of the orders until it finds one with
     * the matching ID. Because of this, no LocalDate is needed. Will return
     * null if the order cannot be found.
     *
     * @param orderId
     * @return
     */
    @Override
    public Order getOrder(int orderId) {

        int nextAvailableId = 0;
        for (List<Order> dayOrders : allOrders.values()) {
            for (Order order : dayOrders) {
                /**
                 * This needs to check every Order ID to see if it matches. If
                 * it does, return it.
                 */
            }
        }

        return nextAvailableId;
    }

}
