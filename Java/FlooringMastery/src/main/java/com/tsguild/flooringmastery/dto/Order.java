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
        this.deliveryDate = date;
        this.materialCost = BigDecimal.valueOf(area).multiply(costPerSqrFt);
        this.laborCost = BigDecimal.valueOf(area).multiply(laborCostPerSqrFt);
        this.tax = (materialCost.add(laborCost)).multiply(BigDecimal.valueOf(taxRate / 100));
        this.total = materialCost.add(laborCost.add(tax));
    }

    //Getters and Setters
    public int getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(int orderNum) {
        this.orderNum = orderNum;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public double getTaxRate() {
        return taxRate;
    }

    public void setTaxRate(double taxRate) {
        this.taxRate = taxRate;
    }

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
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

    public LocalDate getOrderDate() {
        return deliveryDate;
    }

    public void setOrderDate(LocalDate orderDate) {
        this.deliveryDate = orderDate;
    }

    //Update costs when rates are changed via getters/setters
    public void recalc() {
        this.materialCost = BigDecimal.valueOf(area).multiply(costPerSqrFt);
        this.laborCost = BigDecimal.valueOf(area).multiply(laborCostPerSqrFt);
        this.tax = (materialCost.add(laborCost)).multiply(BigDecimal.valueOf(taxRate / 100));
        this.total = materialCost.add(laborCost.add(tax));
    }

    //toString fix
    @Override
    public String toString() {
        return "Order{" + "orderNum=" + orderNum + ", customerName=" + customerName + ", state=" + state + ", taxRate=" + taxRate + ", productType=" + productType + ", area=" + area + ", costPerSqrFt=" + costPerSqrFt + ", laborCostPerSqrFt=" + laborCostPerSqrFt + ", materialCost=" + materialCost + ", laborCost=" + laborCost + ", tax=" + tax + ", total=" + total + '}';
    }
}
