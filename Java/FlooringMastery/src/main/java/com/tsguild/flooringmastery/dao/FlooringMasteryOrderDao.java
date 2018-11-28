package com.tsguild.flooringmastery.dao;

import com.tsguild.flooringmastery.dto.Order;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author souldj673
 */
public interface FlooringMasteryOrderDao {

    Map<Integer, Order> DAY_ORDERS = new HashMap<>();

    public List<Order> displayOrders();

    public Order addOrder(Order theOrder);

    public void editOrder(Order theOrder);

    public Order removeOrder(int orderId);

    public void mapOrdersForDate(LocalDate date);

}
