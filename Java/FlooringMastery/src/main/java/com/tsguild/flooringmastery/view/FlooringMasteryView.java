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
package com.tsguild.flooringmastery.view;

import com.tsguild.flooringmastery.dto.Order;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Collection;
import java.util.Map;

/**
 *
 * @author souldj673
 */
public class FlooringMasteryView {

    private UserIO io;

    public FlooringMasteryView(UserIO theIo) {
        this.io = theIo;
    }

    private int menus(String[] options) {
        int i = 1;
        for (String option : options) {
            io.print(i + ".) " + option + "\n");
            i++;
        }

        int itemCode = io.readInt("Select what you would like to do: (1-" + (i - 1) + ")");

        return itemCode;
    }

    private void banner(String titleText) {
        String bannerCage = ("#################################################"
                + "#################################");

        //Trim Cage to word length
        int titleLength = titleText.length();
        String fittedCage = bannerCage.substring(0, titleLength);

        //Print Title with banner
        io.print(fittedCage + "\n");
        io.print(titleText + "\n");
        io.print(fittedCage + "\n");
    }

    public int mainMenu() {
        String[] options = {"Display Orders", "Add Order",
            "Edit Order", "Remove Order", "Quit"};

        banner("Main Menu");

        //Return User selection
        return menus(options);
    }

    public void temporaryLolMessage() {
        io.print("\nI'd ask you to save, but production/training mode isn't "
                + "\nimplemented yet.  Since writing to files isn't implemented "
                + "\neither, there isn't a point yet to have a save prompt here.");
    }

    public LocalDate getOrderDate() {
        LocalDate orderDate;
        DateTimeFormatter monthDayYear = DateTimeFormatter.ofPattern("MM/dd/yyyy");

        io.print("\nI need the date that the order was created.\n");
        int orderDay = io.readInt("Please input the day the order was created:", 1, 31);
        int orderMonth = io.readInt("Input the month:", 1, 12);
        int orderYear = io.readInt("Input the year:");

        orderDate = LocalDate.of(orderYear, orderMonth, orderDay);

        return orderDate;
    }

    public void displayOrders(Map<Integer, Order> orders) {
        io.print("\n");
        Collection<Order> ordersC = orders.values();
        for (Order order : ordersC) {

            io.print(order.getOrderNum() + ".) " + order.getCustomerName() + " - Order for "
                    + order.getDeliveryDate().toString() + "\n");

        }
        io.print("\n\n");
    }

    public void errors(String exception) {
        switch (exception.toLowerCase()) {
            case "filenotfound":
                io.print("\nUh oh! Couldn't find the specified file!\n\n");
                break;
            case "unsupportedoperation":
                io.print("\nSorry kiddo, can't do that yet!\n\n");
                break;
            case "noorders":
                io.print("\nThere aren't any orders set to deliver on the given date!\n\n");
        }
    }

}
