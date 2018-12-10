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
import com.tsguild.flooringmastery.dto.Product;
import com.tsguild.flooringmastery.dto.TaxRate;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

/**
 *
 * @author souldj673
 */
public class FlooringMasteryView {

    private UserIO io;
    private ConsoleEraser eraser;

    public FlooringMasteryView(UserIO theIo, ConsoleEraser theEraser) {
        this.io = theIo;
        this.eraser = theEraser;
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
        String bannerCageMaterial = (">");

        //Grow Cage to line length
        int titleLength = titleText.split("\n")[0].length();
        String fittedCage = "";
        for (int i = 0; i < titleLength; i++) {
            fittedCage += bannerCageMaterial;
        }

        //Print Title with banner
        io.print(fittedCage + "\n\n");
        io.print(titleText + "\n");
        io.print(fittedCage + "\n");
    }

    public int mainMenu() {
        String[] options = {"Display Orders", "Add Order",
            "Edit Order", "Remove Order", "Save", "Quit"};

        io.print("                                      \n"
                + "@@@@@@@@@@    @@@@@@   @@@  @@@  @@@  \n"
                + "@@@@@@@@@@@  @@@@@@@@  @@@  @@@@ @@@  \n"
                + "@@! @@! @@!  @@!  @@@  @@!  @@!@!@@@  \n"
                + "!@! !@! !@!  !@!  @!@  !@!  !@!!@!@!  \n"
                + "@!! !!@ @!@  @!@!@!@!  !!@  @!@ !!@!  \n"
                + "!@!   ! !@!  !!!@!!!!  !!!  !@!  !!!  \n"
                + "!!:     !!:  !!:  !!!  !!:  !!:  !!!  \n"
                + ":!:     :!:  :!:  !:!  :!:  :!:  !:!  \n"
                + ":::     ::   ::   :::   ::   ::   ::  \n"
                + " :      :     :   : :  :    ::    :   \n"
                + "                                      \n"
                + "                                           \n"
                + "@@@@@@@@@@   @@@@@@@@  @@@  @@@  @@@  @@@  \n"
                + "@@@@@@@@@@@  @@@@@@@@  @@@@ @@@  @@@  @@@  \n"
                + "@@! @@! @@!  @@!       @@!@!@@@  @@!  @@@  \n"
                + "!@! !@! !@!  !@!       !@!!@!@!  !@!  @!@  \n"
                + "@!! !!@ @!@  @!!!:!    @!@ !!@!  @!@  !@!  \n"
                + "!@!   ! !@!  !!!!!:    !@!  !!!  !@!  !!!  \n"
                + "!!:     !!:  !!:       !!:  !!!  !!:  !!!  \n"
                + ":!:     :!:  :!:       :!:  !:!  :!:  !:!  \n"
                + ":::     ::    :: ::::   ::   ::  ::::: ::  \n"
                + " :      :    : :: ::   ::    :    : :  :   \n"
                + "                                           \n\n");

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

    public void displayOrders(List<Order> orders) {
        io.print("\n");

        for (Order order : orders) {
            io.print(order.getOrderNum() + ".) " + order.getCustomerName()
                    + " - Order for " + order.getProductType() + " to "
                    + order.getState() + "\n");
        }
        io.print("\n\n");
    }

    public Order createOrder(int latestId, List<TaxRate> states, List<Product> products, Order order) {
        banner("                                                           \n"
                + " @@@@@@@  @@@@@@@   @@@@@@@@   @@@@@@   @@@@@@@  @@@@@@@@  \n"
                + "@@@@@@@@  @@@@@@@@  @@@@@@@@  @@@@@@@@  @@@@@@@  @@@@@@@@  \n"
                + "!@@       @@!  @@@  @@!       @@!  @@@    @@!    @@!       \n"
                + "!@!       !@!  @!@  !@!       !@!  @!@    !@!    !@!       \n"
                + "!@!       @!@!!@!   @!!!:!    @!@!@!@!    @!!    @!!!:!    \n"
                + "!!!       !!@!@!    !!!!!:    !!!@!!!!    !!!    !!!!!:    \n"
                + ":!!       !!: :!!   !!:       !!:  !!!    !!:    !!:       \n"
                + ":!:       :!:  !:!  :!:       :!:  !:!    :!:    :!:       \n"
                + " ::: :::  ::   :::   :: ::::  ::   :::     ::     :: ::::  \n"
                + " :: :: :   :   : :  : :: ::    :   : :     :     : :: ::   \n"
                + "                                                           ");

        Order theOrder;

        if (order == null) {
            String custName = io.readString("Firstly, I need your name.  What is that?");

            io.print("\n\nI need the delivery date for your order.\n");
            int day = io.readInt("Please insert the date of delivery (1-31) ");
            int month = io.readInt("\nNow the month (1-12) ");
            int year = io.readInt("\nLastly, the year (YYYY) ");
            LocalDate deliveryDate = LocalDate.of(year, month, day);

            displayValidStates(states);
            String state = io.readString("\n\nWhich state will the order be sent to? (DC)");

            displayValidProducts(products);
            String product = io.readString("\n\nWhich material are you ordering? (Tile)");
            double area = io.readDouble("\nHow much material, in square feet, would you like to order? (100 (minimum))");

            theOrder = new Order(latestId, custName, state, product, area, deliveryDate);
        } else {

            /**
             * This is legacy code and no longer serves a purpose.
             */
            boolean fixed = false;

            if (order.getCustomerName() == null) {
                String custName = io.readString("Let's try again with your name.  It cannot be blank. ");
                order.setCustomerName(custName);
            }
            if (order.getState() == null) {
                displayValidStates(states);
                String state = io.readString("\n\nThe state you entered before was either invalid or we don't deliver there.  Try again. (DC)");
                order.setState(state);
            }
            if (order.getProductType() == null) {
                displayValidProducts(products);
                String product = io.readString("\n\nThe previously entered material was either invalid or we don't sell that.  Try again. (Tile)");
                order.setProductType(product);
            }
            if (order.getArea() == 0) {
                double area = io.readDouble("\nThe minimum amount of material we sell is 100 sqft. Try again. (100)");
                order.setArea(area);
            }

            if (!fixed) {
                return null;
            } else {
                theOrder = order;
            }

        }

        return theOrder;
    }

    public Order creationConfirmationPrompt(Order theOrder) {
        this.clearConsole();
        io.print("\n\nThe name for the order is " + theOrder.getCustomerName());
        io.print("\nYour order ID is " + theOrder.getOrderNum() + ".");
        io.print("\nThe order is for " + theOrder.getArea() + " sqft of "
                + theOrder.getProductType() + " to " + theOrder.getState());
        io.print("\nYour total cost is: $" + theOrder.getTotal().setScale(2, RoundingMode.FLOOR));
        String choice = io.readString("\n\nWould you like to confirm this purchase? (y/N)");
        switch (choice.toLowerCase()) {
            case "y":
            case "yes":
                return theOrder;
            default:
                return null;
        }
    }

    private void displayValidStates(List<TaxRate> states) {
        io.print("The following are valid responses:\n");
        for (TaxRate state : states) {
            io.print(state.getAbbr() + "\n");
        }
    }

    private void displayValidProducts(List<Product> products) {
        io.print("The following are valid responses:\n");
        for (Product product : products) {
            io.print(product.getType() + "\n");
        }
    }

    public void errors(String exception) {

        banner("");
        switch (exception.toLowerCase()) {
            case "filenotfound":
                io.print("\nThere aren't any order files!\n\n");
                break;
            case "unsupportedoperation":
                io.print("\nSorry kiddo, can't do that yet!\n\n");
                break;
            case "noorders":
                io.print("\nThere aren't any orders set to deliver on the given"
                        + " date!\n\n");
                break;
            case "invalidorder":
                io.print("\nYou entered some invalid information into your orde"
                        + "r.  Let's try again, but this time with valid inform"
                        + "ation.\n\n");
                break;
            case "filenotfoundpretest":
                io.print("\nThere aren't any order files to read from! Must be"
                        + " the first time running...  We'll keep going though.");
                break;
        }
    }

    public void notices(String notice) {
        switch (notice.toLowerCase()) {
            case "trainingmode":
                io.print("\nYou are in training mode.  Any changes will not be "
                        + "saved.\n\n");
                break;
            case "productionmode":
                io.print("\nYou are in production mode.  All changes will be "
                        + "saved.");
        }
    }

    private void clearConsole() {

        eraser.clearConsole();
    }

}
