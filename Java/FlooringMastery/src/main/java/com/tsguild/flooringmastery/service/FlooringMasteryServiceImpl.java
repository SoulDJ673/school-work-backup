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
import com.tsguild.flooringmastery.dto.Order;
import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.util.Map;

/**
 *
 * @author souldj673
 */
public class FlooringMasteryServiceImpl implements FlooringMasteryService {

    private final FlooringMasteryOrderDao orderDao;

    public FlooringMasteryServiceImpl(FlooringMasteryOrderDao theOrderDao) {
        this.orderDao = theOrderDao;
    }

    @Override
    public Map<Integer, Order> getOrders(LocalDate deliveryDate) throws FileNotFoundException, FlooringMasteryNoOrdersForDateException {
        orderDao.mapOrdersForDate(deliveryDate);

        //Check if there are orders for the given date
        Map<Integer, Order> dayOrders = orderDao.getOrders();
        if (!dayOrders.isEmpty()) {
            return dayOrders;
        } else {
            throw new FlooringMasteryNoOrdersForDateException("No orders found for given date");
        }

    }

}
