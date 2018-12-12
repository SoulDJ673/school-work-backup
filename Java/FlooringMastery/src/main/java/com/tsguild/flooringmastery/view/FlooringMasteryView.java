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

        io.print("O┬┌─┐  ╔╦╗┌─┐┬┌┐┌  ╔╦╗┌─┐┌┐┌┬ ┬  ┌─┐O┬\n"
                + "┌┘│└┘  ║║║├─┤││││  ║║║├┤ ││││ │  │└┘┌┘\n"
                + "┴O└──  ╩ ╩┴ ┴┴┘└┘  ╩ ╩└─┘┘└┘└─┘  └──┴O\n\n");

        //Return User selection
        return menus(options);
    }

    public LocalDate getOrderDate() {

        String enteredDate = io.readString("Enter the date in the format MM-dd-yyyy (01-01-1999): ");
        DateTimeFormatter orderDate = DateTimeFormatter.ofPattern("MM-dd-yyyy");
        LocalDate deliveryDate = LocalDate.parse(enteredDate, orderDate);
        
        return deliveryDate;
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
        banner("O┬  ╔═╗┬─┐┌─┐┌─┐┌┬┐┌─┐  O┬\n"
                + "┌┘  ║  ├┬┘├┤ ├─┤ │ ├┤   ┌┘\n"
                + "┴O  ╚═╝┴└─└─┘┴ ┴ ┴ └─┘  ┴O\n\n");

        Order theOrder;

        if (true) {
            String custName = io.readString("Firstly, I need your name.  What is that?");

            io.print("\n\nI need the delivery date for your order.\n");

            String enteredDate = io.readString("Enter the date in the format MM-dd-yyyy (01-01-1999): ");
            DateTimeFormatter orderDate = DateTimeFormatter.ofPattern("MM-dd-yyyy");
            LocalDate deliveryDate = LocalDate.parse(enteredDate, orderDate);

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
        displayOrderInfo(theOrder);
        String choice = io.readString("\n\nWould you like to confirm this purchase? (y/N)");
        switch (choice.toLowerCase()) {
            case "y":
            case "yes":
            case "true":
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

    //Remove Pt 1
    public int removeOrderIdGrabber() {
        banner("O┬  ╦═╗┌─┐┌┬┐┌─┐┬  ┬┌─┐  O┬\n"
                + "┌┘  ╠╦╝├┤ ││││ │└┐┌┘├┤   ┌┘\n"
                + "┴O  ╩╚═└─┘┴ ┴└─┘ └┘ └─┘  ┴O\n\n");

        int orderId;

        validLoop:
        while (true) {
            String orderIdMaybe = io.readString("Please enter your order ID (Ex: 1)"
                    + " or type 'q' to return to the main menu");
            switch (orderIdMaybe.toLowerCase()) {
                case "q":
                case "quit":
                case "main":
                case "exit":
                case "x":
                    return -69;
            }

            try {
                orderId = Integer.parseInt(orderIdMaybe);
                break validLoop;
            } catch (NumberFormatException n) {
                io.print("\n");
            }
        }
        return orderId;
    }

    //Remove Pt 2
    public boolean removeOrderConfirmPrompt(Order theOrder) {
        displayOrderInfo(theOrder);
        String userResponse = io.readString("\nAre you sure that you want to pe"
                + "rmanently remove this order? (y/N)");
        switch (userResponse.toLowerCase()) {
            case "y":
            case "yes":
            case "true":
                return true;
            default:
                return false;
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
                        + " the first time running...  We'll keep going though.\n");
                break;
            case "modenoneerror":
                io.print("\nThe file for the mode type is nonexistent or unread"
                        + "able.  Please check to make sure reading permissions"
                        + " are correct and that the file exists. The program w"
                        + "ill not run.\n");
                break;
            case "modeinvaliderror":
                io.print("\nThe running mode chosen was invalid.  Please check "
                        + "the Data/Mode.txt file to ensure that a valid runnin"
                        + "g mode is set (Training/Production).  The program wi"
                        + "ll not run.\n");
                break;
            case "nullorder":
                io.print("\nThe order ID you entered doesn't match any existing o"
                        + "rders.\n");
                break;
            case "wrongmode":
                io.print("\nYou are in training mode, and are therefore unable to"
                        + " save.\n");
                break;
            case "poststartmodeerror":
                io.print("\nThe mode was unable to be determined.  There is eit"
                        + "her a bug in this program or the Mode.txt file has c"
                        + "hanged/corrupted/gone missing after the start of thi"
                        + "s program.  The program could be under attack.  This"
                        + " is a very serious problem, the program will termina"
                        + "te immediately.");
                break;
            case "ioexception":
                io.print("\nThere was a problem while writing your changes to s"
                        + "torage.  Check to make sure the write permissions ar"
                        + "e correct for all of the program files.\n\n");
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
                        + "saved.\n\n");
                break;
            case "operationsuccess":
                io.print("\nOperation was successful.\n\n");
        }
    }

    public int saveAndExit() {
        io.print("You are about to exit the program.  You have 3 options.\n");
        String[] options = {"Return to Main Menu", "Exit without Saving", "Save and Exit"};
        return menus(options);
    }

    /**
     * A little method to clear the console screen for a better UX. It uses ANSI
     * escape codes, but these don't seem to be supported in NetBeans so this
     * method isn't really used in this project.
     */
    private void clearConsole() {
        eraser.clearConsole();
    }

    /**
     * This is a helper method used by createOrder, removeOrder, editOrder, and
     * maybe a search function if implemented. It reads and displays the
     * important information on the given order.
     *
     * @param theOrder
     */
    private void displayOrderInfo(Order theOrder) {
        io.print("\n\nName:" + theOrder.getCustomerName());
        io.print("\nOrder ID: " + theOrder.getOrderNum());
        io.print("\nThe order is for " + theOrder.getArea() + " sqft of "
                + theOrder.getProductType() + " to " + theOrder.getState());
        io.print("\nTotal Cost: $" + theOrder.getTotal().setScale(2, RoundingMode.HALF_UP));
    }

}
