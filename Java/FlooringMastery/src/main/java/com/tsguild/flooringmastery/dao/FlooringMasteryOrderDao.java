package com.tsguild.flooringmastery.dao;

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
public interface FlooringMasteryOrderDao {

    /**
     * This method will return a single order, given that the provided ID
     * matches any existing orders.
     *
     * @param orderId
     * @return
     */
    Order getOrder(int orderId);

    /**
     * This method will return a list of all the orders for a specific date.
     *
     * @return
     */
    List getOrders();

    /**
     * This method will return a map of all the existing orders.
     *
     * @return
     */
    Map getAllOrders();

    Order addOrder(Order theOrder);

    void editOrder(Order theOrder);

    Order removeOrder(int orderId);

    /**
     * This method will load all of the orders for a specific date into their
     * own particular organizational object (Maps, Collections, etc depends on
     * the implementation). Any orders within that particular area at the time
     * of calling will be placed back with the rest of the orders before
     * clearing out that area.
     *
     * @param date
     * @throws FileNotFoundException
     */
    void mapOrdersForDate(LocalDate date) throws FileNotFoundException;

    /**
     * This calls any saving related methods/helper methods to help in
     * persistence.  Will throw an IOException if it is unable to write.
     * @throws java.io.IOException
     */
    void persistOrders() throws IOException;

}
