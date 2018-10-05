package com.tsguild.vendingmachine.dto;

/**
 *
 * @author souldj673
 */
public class Item {

    private String slotId;
    private String itemName;
    private double itemCost;
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

    public double getItemCost() {
        return itemCost;
    }

    public void setItemCost(double itemCost) {
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
