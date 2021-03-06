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

import java.math.BigDecimal;

/**
 *
 * @author souldj673
 */
public class ChangePurse {

    private BigDecimal total;

    //Coin Types    
    private int pennies;
    private int nickels;
    private int dimes;
    private int quarters;

    public ChangePurse() {
        this.pennies = 0;
        this.nickels = 0;
        this.dimes = 0;
        this.quarters = 0;
        this.total = calculateTotal();
    }

    public ChangePurse(int pennies, int nickels, int dimes, int quarters) {
        this.pennies = pennies;
        this.nickels = nickels;
        this.dimes = dimes;
        this.quarters = quarters;
        this.total = calculateTotal();
    }

    public int getPennies() {
        return pennies;
    }

    public void setPennies(int pennies) {
        this.pennies = pennies;
        this.total = calculateTotal();
    }

    public int getNickels() {
        return nickels;
    }

    public void setNickels(int nickels) {
        this.nickels = nickels;
        this.total = calculateTotal();
    }

    public int getDimes() {
        return dimes;
    }

    public void setDimes(int dimes) {
        this.dimes = dimes;
        this.total = calculateTotal();
    }

    public int getQuarters() {
        return quarters;
    }

    public void setQuarters(int quarters) {
        this.quarters = quarters;
        this.total = calculateTotal();
    }

    public BigDecimal getTotal() {
        return total;
    }

    private BigDecimal calculateTotal() {
        return new BigDecimal((quarters * 0.25) + (dimes * 0.1)
                + (nickels * 0.05) + (pennies * 0.01));
    }

}
