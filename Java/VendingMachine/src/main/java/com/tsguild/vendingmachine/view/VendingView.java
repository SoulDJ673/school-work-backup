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
package com.tsguild.vendingmachine.view;

import com.tsguild.vendingmachine.dto.*;
import java.math.RoundingMode;
import java.util.List;

/**
 *
 * @author souldj673
 */
public class VendingView {

    private UserIO io;

    public VendingView(UserIO userIO) {
        this.io = userIO;
    }

    private String menus(String[] options) {
        int i = 1;
        for (String option : options) {
            io.print(i + ".) " + option);
            i++;
        }

        String itemCode = io.readString("Please select the item you wish to "
                + "purchase: (Enter q to exit, or $ to view your change purse "
                + "balance)");

        spacer();

        return itemCode;
    }

    private void banners(String titleText) {
        String bannerCage = ("#################################################"
                + "#################################");

        //Trim Cage to word length
        int titleLength = titleText.length();
        String fittedCage = bannerCage.substring(0, titleLength);

        //Print Title with banner
        io.print(fittedCage);
        io.print(titleText);
        io.print(fittedCage);
    }

    public String mainMenu() {

        String[] options = {};
        return this.menus(options);
    }

    public void displayAvailableItems(List<Item> items) {
        banners("Items sold by the vending machine");

        for (Item currentItem : items) {
            io.print(currentItem.getId() + ": " + currentItem.getItemName());
        }
    }

    public void errors(int i) {
        switch (i) {
            case 1:
                io.print("Please check to ensure that the inventory file "
                        + "exists/isn't corrupt.");
                spacer();
                break;
            case 2:
                io.print("You don't have enough money to afford that item!");
                spacer();
                break;
            case 3:
                io.print("Please enter a valid item code.");
                spacer();
                break;
            case 4:
                io.print("There is no more of that item, sorry for the "
                        + "inconvienience!");
                spacer();
                break;
            case 5:
                io.print("Invalid choice.  Defaulting to no...");
                spacer();
                break;
        }
    }

    public String displayItem(Item userSelect) {
        banners(userSelect.getItemName() + " - " + userSelect.getId());
        io.print("Amount of item remaining: " + userSelect.getItemCount());
        io.print("Cost of item: " + userSelect.getItemCost().toString());

        String choiceString = io.readString("Would you like to purchase this it"
                + "em? (y/N): ");

        spacer();

        return choiceString;
    }

    public int[] changePursePopulation() {
        int[] coins = new int[4];

        banners("Money in your change purse");
        
        io.print("\nAs you approach a Vending Machine you check how much change "
                + "you have in your change purse...\n");

        coins[0] = io.readInt("How many pennies do you have in your change purse?");
        coins[1] = io.readInt("How many nickels do you have in your change purse?");
        coins[2] = io.readInt("How many dimes do you have in your change purse?");
        coins[3] = io.readInt("How many quarters do you have in your change purse?");

        spacer();

        return coins;
    }

    private void spacer() {
        io.print("\n\n\n");
    }

    public void displayChangePurseAmount(ChangePurse userPurse) {
        banners("Change Purse Balance");

        io.print("$" + userPurse.getTotal().setScale(2, RoundingMode.HALF_DOWN).toString());

        spacer();
    }

}
