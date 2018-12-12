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

import com.tsguild.flooringmastery.dao.FlooringMasteryModeDao;
import com.tsguild.flooringmastery.dao.FlooringMasteryModeErrorException;
import com.tsguild.flooringmastery.dao.FlooringMasteryOrderDao;
import com.tsguild.flooringmastery.dao.FlooringMasteryTaxesProductDao;
import com.tsguild.flooringmastery.dto.Order;
import java.io.FileNotFoundException;
import java.io.IOException;
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
    private final FlooringMasteryModeDao modeDao;

    public FlooringMasteryServiceImpl(FlooringMasteryOrderDao theOrderDao,
            FlooringMasteryTaxesProductDao theTaxProdDao, FlooringMasteryModeDao theModeDao) {
        this.orderDao = theOrderDao;
        this.taxProdDao = theTaxProdDao;
        this.modeDao = theModeDao;
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
    public Order validateOrder(Order order) throws FlooringMasteryInvalidOrderException {
        /**
         * Check for invalid fields in order && set them to null to be returned
         * and fixed
         */
        Order validMaybe = validateHelper(order);

        try {
            validMaybe.setTaxRate(taxProdDao.getTax(validMaybe.getState()).getTaxRate());
            validMaybe.setCostPerSqrFt(taxProdDao.getProduct(validMaybe.getProductType()).getCostPerSqrFt());
            validMaybe.setLaborCostPerSqrFt(taxProdDao.getProduct(validMaybe.getProductType()).getLaborCostPerSqrFt());
            validMaybe.recalc();
        } catch (NullPointerException n) {
            throw new FlooringMasteryInvalidOrderException();
        }

        return validMaybe;

    }

    /**
     * This will return all of the checked properties of the order, and any that
     * are invalid will be null
     *
     * @param order
     * @return
     */
    private Order validateHelper(Order order) throws FlooringMasteryInvalidOrderException {

        //Check for date in future
        LocalDate maybeBadDelivery;
        if (order.getDeliveryDate().compareTo(LocalDate.now()) <= 0) {
            throw new FlooringMasteryInvalidOrderException();
        } else {
            maybeBadDelivery = order.getDeliveryDate();
        }

        //Creates new Order
        Order kindaTheOrder = new Order(order.getOrderNum(),
                order.getCustomerName(), order.getState(), order.getProductType(),
                order.getArea(), maybeBadDelivery);

        //Check for blank or null name
        if (order.getCustomerName().trim().isEmpty() || order.getCustomerName()
                == null) {
            throw new FlooringMasteryInvalidOrderException();
        }

        //Check for if we sell in that state & if it's valid
        if (order.getState().trim().isEmpty() || order.getState() == null
                || taxProdDao.getTax(order.getState()) == null) {
            throw new FlooringMasteryInvalidOrderException();
        }

        //Check for if we sell that product & if it's valid
        if (order.getProductType().trim().isEmpty() || order.getProductType()
                == null || taxProdDao.getProduct(autoCap(order.getProductType())
                ) == null) {
            throw new FlooringMasteryInvalidOrderException();
        }

        //Check for minimal size reqs
        if (order.getArea() < 100) {
            throw new FlooringMasteryInvalidOrderException();
        }

        return kindaTheOrder;
    }

    /**
     * This method capitalizes the first letter of whatever string is passed in
     *
     * @param thing
     * @return
     */
    private String autoCap(String thing) {
        thing = thing.toLowerCase();
        return thing.replace(thing.substring(0, 1), thing.substring(0, 1).toUpperCase());
    }

    @Override
    public Order addOrder(Order order) {
        return orderDao.addOrder(order);
    }

    @Override
    public List getProducts() throws FileNotFoundException {
        taxProdDao.loadProducts();
        return taxProdDao.getAllProducts();
    }

    @Override
    public List getStates() throws FileNotFoundException {
        taxProdDao.loadTaxes();
        return taxProdDao.getAllTaxes();
    }

    /**
     * This implementation only uses the isProduction() method in the dao to
     * determine the mode type.
     *
     * @return true(Production) / false(training)
     * @throws java.io.FileNotFoundException
     * @throws com.tsguild.flooringmastery.dao.FlooringMasteryModeErrorException
     */
    @Override
    public boolean getMode() throws FileNotFoundException, FlooringMasteryModeErrorException {
        modeDao.loadMode();
        return modeDao.isProduction();
    }

    @Override
    public Order removeOrder(int orderId) {
        Order theOrder = orderDao.removeOrder(orderId);
        try {
            orderDao.mapOrdersForDate(null);
        } catch (FileNotFoundException f) {
            //Doesn't matter
        }
        return theOrder;
    }

    @Override
    public Order getOrder(int orderId) {
        Order theOrder = orderDao.getOrder(orderId);
        return theOrder;
    }

    @Override
    public void saveOrders() throws IOException {
        orderDao.persistOrders();
    }

}
