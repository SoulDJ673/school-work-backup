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
package com.tsguild.vendingmachine.dto;

/**
 *
 * @author souldj673
 */
public class ChangePurse {

    //Coin Types    
    private int pennies;
    private int nickles;
    private int dimes;
    private int quarters;

    public ChangePurse() {
        this.pennies = 0;
        this.nickles = 0;
        this.dimes = 0;
        this.quarters = 0;
    }

    public ChangePurse(int pennies, int nickles, int dimes, int quarters) {
        this.pennies = pennies;
        this.nickles = nickles;
        this.dimes = dimes;
        this.quarters = quarters;
    }

    public int getPennies() {
        return pennies;
    }

    public void setPennies(int pennies) {
        this.pennies = pennies;
    }

    public int getNickles() {
        return nickles;
    }

    public void setNickles(int nickles) {
        this.nickles = nickles;
    }

    public int getDimes() {
        return dimes;
    }

    public void setDimes(int dimes) {
        this.dimes = dimes;
    }

    public int getQuarters() {
        return quarters;
    }

    public void setQuarters(int quarters) {
        this.quarters = quarters;
    }

}
