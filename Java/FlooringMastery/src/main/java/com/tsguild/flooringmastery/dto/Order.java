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
import java.time.LocalDate;
import java.util.Objects;

/**
 *
 * @author souldj673
 */
public class Order {

    private int orderNum;
    private String customerName;
    private String state;
    private double taxRate;
    private String productType;
    private double area;
    private BigDecimal costPerSqrFt;
    private BigDecimal laborCostPerSqrFt;
    private BigDecimal materialCost;
    private BigDecimal laborCost;
    private BigDecimal tax;
    private BigDecimal total;
    private LocalDate deliveryDate;

    //Partial Args Constructor for inital tax & cost calc
    public Order(int orderNum, String customerName, String state, double taxRate,
            String productType, double area, BigDecimal costPerSqrFt,
            BigDecimal laborCostPerSqrFt, LocalDate date) {
        this.orderNum = orderNum;
        this.customerName = customerName;
        this.state = state;
        this.taxRate = taxRate;
        this.productType = productType;
        this.area = area;
        this.costPerSqrFt = costPerSqrFt;
        this.laborCostPerSqrFt = laborCostPerSqrFt;
        this.materialCost = BigDecimal.valueOf(area).multiply(costPerSqrFt);
        this.laborCost = BigDecimal.valueOf(area).multiply(laborCostPerSqrFt);
        this.tax = (materialCost.add(laborCost)).multiply(BigDecimal.valueOf(taxRate / 100));
        this.total = materialCost.add(laborCost.add(tax));
        this.deliveryDate = date;
    }

    //Setters
    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public void setState(String state) {
        this.state = state;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    public void setArea(double area) {
        this.area = area;
    }

    //Getters
    public int getOrderNum() {
        return orderNum;
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getState() {
        return state;
    }

    public double getTaxRate() {
        return taxRate;
    }

    public String getProductType() {
        return productType;
    }

    public double getArea() {
        return area;
    }

    public BigDecimal getCostPerSqrFt() {
        return costPerSqrFt;
    }

    public BigDecimal getLaborCostPerSqrFt() {
        return laborCostPerSqrFt;
    }

    public BigDecimal getMaterialCost() {
        return materialCost;
    }

    public BigDecimal getLaborCost() {
        return laborCost;
    }

    public BigDecimal getTax() {
        return tax;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public LocalDate getDeliveryDate() {
        return deliveryDate;
    }

    //Update costs when rates are changed via getters/setters
    public void recalc() {
        this.materialCost = BigDecimal.valueOf(area).multiply(costPerSqrFt);
        this.laborCost = BigDecimal.valueOf(area).multiply(laborCostPerSqrFt);
        this.tax = (materialCost.add(laborCost)).multiply(BigDecimal.valueOf(taxRate / 100));
        this.total = materialCost.add(laborCost.add(tax));
    }

    //toString fix
    
    //Make it so marshalling is easier!
    @Override
    public String toString() {
        return orderNum + ","
                + customerName + "," + state + "," + taxRate + "," + productType + "," + area + ","
                + "," + costPerSqrFt + ","
                + laborCostPerSqrFt + ", materialCost=" + materialCost + ", "
                + "laborCost=" + laborCost + ", tax=" + tax + ", total="
                + total + '}';
    }

    @Override
    public int hashCode() {
        //The only thing differentiating orders from the same date will be ID
        int hash = 0;
        hash = hash + this.orderNum;
        hash = hash + 11;
        hash = hash + this.deliveryDate.getYear()
                + this.deliveryDate.getDayOfMonth()
                + this.deliveryDate.getMonthValue();
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Order other = (Order) obj;
        if (this.orderNum != other.orderNum) {
            return false;
        }
        if (Double.doubleToLongBits(this.taxRate) != Double.doubleToLongBits(other.taxRate)) {
            return false;
        }
        if (Double.doubleToLongBits(this.area) != Double.doubleToLongBits(other.area)) {
            return false;
        }
        if (!Objects.equals(this.customerName, other.customerName)) {
            return false;
        }
        if (!Objects.equals(this.state, other.state)) {
            return false;
        }
        if (!Objects.equals(this.productType, other.productType)) {
            return false;
        }
        if (!Objects.equals(this.costPerSqrFt, other.costPerSqrFt)) {
            return false;
        }
        if (!Objects.equals(this.laborCostPerSqrFt, other.laborCostPerSqrFt)) {
            return false;
        }
        if (!Objects.equals(this.materialCost, other.materialCost)) {
            return false;
        }
        if (!Objects.equals(this.laborCost, other.laborCost)) {
            return false;
        }
        if (!Objects.equals(this.tax, other.tax)) {
            return false;
        }
        if (!Objects.equals(this.total, other.total)) {
            return false;
        }
        if (!Objects.equals(this.deliveryDate, other.deliveryDate)) {
            return false;
        }
        return true;
    }

}
