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
package com.tsguild.flooringmastery.dto;

/**
 *
 * @author souldj673
 */
public class TaxRate {

    private String abbr;
    private String state;
    private double taxRate;

    public TaxRate(String abbr, String state, double taxRate) {
        this.abbr = abbr;
        this.state = state;
        this.taxRate = taxRate;
    }

    @Override
    public String toString() {
        return "TaxRate{" + "abbr=" + abbr + ", state=" + state + ", taxRate=" + taxRate + '}';
    }

    public String getAbbr() {
        return abbr;
    }

    public String getState() {
        return state;
    }

    public double getTaxRate() {
        return taxRate;
    }

    public void setTaxRate(double taxRate) {
        this.taxRate = taxRate;
    }

}
