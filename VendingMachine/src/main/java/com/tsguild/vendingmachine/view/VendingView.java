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

/**
 *
 * @author souldj673
 */
public class VendingView {

    private UserIO io;

    public VendingView(UserIO userIO) {
        this.io = userIO;
    }

    public String menus(String[] options) {
        int i = 1;
        for (String option : options) {
            io.print(i + ".) " + option);
            i++;
        }

        return io.readString("Please select the item you wish to purchase: ");
    }

    public String mainMenu() {

        String[] options = {"Test", "Test", "Test"};
        return this.menus(options);
    }

}
