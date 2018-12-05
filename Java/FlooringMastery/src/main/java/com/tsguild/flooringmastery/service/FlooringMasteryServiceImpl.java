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

import com.tsguild.flooringmastery.dao.FlooringMasteryOrderDao;
import com.tsguild.flooringmastery.dao.FlooringMasteryTaxesProductDao;
import com.tsguild.flooringmastery.dto.Order;
import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;

/**
 *
 * @author souldj673
 */
public class FlooringMasteryServiceImpl implements FlooringMasteryService {

    private final FlooringMasteryOrderDao orderDao;
    private final FlooringMasteryTaxesProductDao taxProdDao;

    public FlooringMasteryServiceImpl(FlooringMasteryOrderDao theOrderDao,
            FlooringMasteryTaxesProductDao theTaxProdDao) {
        this.orderDao = theOrderDao;
        this.taxProdDao = theTaxProdDao;
    }

    @Override
    public List<Order> getOrders(LocalDate deliveryDate) throws FileNotFoundException, FlooringMasteryNoOrdersForDateException {
        orderDao.mapOrdersForDate(deliveryDate);

        //Check if there are orders for the given date
        List<Order> dayOrders = orderDao.getOrders();
        if (!dayOrders.isEmpty()) {
            return dayOrders;
        } else {
            throw new FlooringMasteryNoOrdersForDateException("No orders found for given date");
        }
    }

    @Override
    public int getLastID() {
        //Orders should be loaded by this point, but just in case they aren't...
        try {
            orderDao.mapOrdersForDate(LocalDate.now());
        } catch (NullPointerException n) {
            /**
             * This will most likely happen, but since we're only calling this
             * to load orders into memory, it doesn't matter.
             */
        } catch (FileNotFoundException f) {
            /**
             * This shouldn't happen, this error should be caught before this
             * method is used
             */
            return -1;
        }

        Map<LocalDate, List<Order>> allOrdersM = orderDao.getAllOrders();

        //Iterate over all orders to get highest ID, maybe save it somewhere?
        int nextAvailableId = 0;
        for (List<Order> dayOrders : allOrdersM.values()) {
            for (Order order : dayOrders) {
                if (order.getOrderNum() >= nextAvailableId) {
                    nextAvailableId = order.getOrderNum() + 1;
                }
            }
        }

        return nextAvailableId;
    }

    @Override
    public Order addOrder(Order order) {
        //Check for invalid fields in order
        boolean[] valid = validateOrder(order);
    }

    private boolean[] validateOrder(Order order) {
        boolean[] booleanTableThing = new boolean[5];

        //Check for date in future
        if (order.getDeliveryDate().compareTo(LocalDate.now()) <= 0) {
            booleanTableThing[0] = false;
        } else {
            booleanTableThing[0] = true;
        }

        //Check for blank or null name
        if (order.getCustomerName().trim().isEmpty() || order.getCustomerName()
                == null) {
            booleanTableThing[1] = false;
        } else {
            booleanTableThing[1] = true;
        }

        //Check for if we sell in that state & if it's valid
        if (order.getState().trim().isEmpty() || order.getState() == null
                || taxProdDao.getTax(order.getState()) == null) {
            booleanTableThing[2] = false;
        } else {
            booleanTableThing[2] = true;
        }

        //Check for if we sell that product & if it's valid
        if (order.getProductType().trim().isEmpty() || order.getProductType()
                == null || taxProdDao.getProduct(order.getProductType()) == null) {
            booleanTableThing[3] = false;
        } else {
            booleanTableThing[3] = true;
        }

        //Check for minimal size reqs
        if (order.getArea() < 100) {
            booleanTableThing[4] = false;
        } else {
            booleanTableThing[4] = true;
        }
    }

}
