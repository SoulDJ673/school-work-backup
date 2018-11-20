package com.tsguild.vendingmachine.dto;

import java.math.BigDecimal;

/**
 *
 * @author souldj673
 */
public class Item {

    private String slotId;
    private String itemName;
    private BigDecimal itemCost;
    private int itemCount;

    //Constructor
    public Item(String id) {
        this.slotId = id;
    }

    //Getters/Setters
    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public BigDecimal getItemCost() {
        return itemCost;
    }

    public void setItemCost(BigDecimal itemCost) {
        this.itemCost = itemCost;
    }

    public int getItemCount() {
        return itemCount;
    }

    public void setItemCount(int itemCount) {
        this.itemCount = itemCount;
    }

    public String getId() {
        return slotId;
    }
}
