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

import java.math.BigDecimal;

/**
 *
 * @author souldj673
 */
public class Product {

    private String type;
    private BigDecimal costPerSqrFt;
    private BigDecimal laborCostPerSqrFt;

    public Product(String type, BigDecimal costPerSqrFt, BigDecimal laborCostPerSqrFt) {
        this.type = type;
        this.costPerSqrFt = costPerSqrFt;
        this.laborCostPerSqrFt = laborCostPerSqrFt;
    }

    @Override
    public String toString() {
        return "Product{" + "type=" + type + ", costPerSqrFt=" + costPerSqrFt + ", laborCostPerSqrFt=" + laborCostPerSqrFt + '}';
    }

    public String getType() {
        return type;
    }

    public BigDecimal getCostPerSqrFt() {
        return costPerSqrFt;
    }

    public void setCostPerSqrFt(BigDecimal costPerSqrFt) {
        this.costPerSqrFt = costPerSqrFt;
    }

    public BigDecimal getLaborCostPerSqrFt() {
        return laborCostPerSqrFt;
    }

    public void setLaborCostPerSqrFt(BigDecimal laborCostPerSqrFt) {
        this.laborCostPerSqrFt = laborCostPerSqrFt;
    }

}
