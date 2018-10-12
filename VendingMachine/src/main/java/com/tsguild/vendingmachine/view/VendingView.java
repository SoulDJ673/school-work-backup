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

import com.tsguild.vendingmachine.dto.Item;
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

        return io.readString("Please select the item you wish to purchase: (Ent"
                + "er q to exit)");
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
        }
    }

    public void displayItem(Item userSelect) {
        banners(userSelect.getItemName() + " - " + userSelect.getId());

    }

}
