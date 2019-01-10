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
package com.tsguild.flooringmastery.dao;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

/**
 *
 * @author souldj673
 */
public class FlooringMasteryModeDaoImpl implements FlooringMasteryModeDao {

    private String mode;

    @Override
    public boolean isProduction() {
        return mode.equalsIgnoreCase("production");
    }

    @Override
    public boolean isTraining() {
        return mode.equalsIgnoreCase("training");
    }

    @Override
    public void loadMode() throws FileNotFoundException, FlooringMasteryModeErrorException {
        Scanner scanner = new Scanner(new BufferedReader(
                new FileReader("Data/Mode.txt")));

        if (!scanner.hasNextLine()) {
            throw new FlooringMasteryModeErrorException();
        } else {
            String readMode = scanner.nextLine();
            String[] garbageSeparator = readMode.split("::");
            mode = garbageSeparator[1].trim();
        }

        if (!mode.equalsIgnoreCase("production") && !mode.equalsIgnoreCase("training")) {
            throw new FlooringMasteryModeErrorException();
        }
    }

    @Override
    public void changeMode() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
