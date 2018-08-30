package com.tsguild.milestone2.challenge.goblinrpg;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author souldj673
 */
public class Goblin implements Armor, Weapon {

    //Properties
    private int health;
    private int experience;
    private String name;
    private List inventory;
    private Armor armor;
    private Weapon weapon;

    //Constructors
    public Goblin() {
        this.name = "Jeffuuu UwU";
        this.health = 100;
        this.experience = 0;
        
        this.inventory = new ArrayList();
        
        this.armor = null;
        this.weapon = null;
    }

    public Goblin(String name) {
        this.name = name;
        this.health = 100;
        this.experience = 0;
        
        this.inventory = new ArrayList();
        
        this.armor = null;
        this.weapon = null;
    }

    //Setters
    public void setHealth(int health) {
        this.health = health;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setInventory(List inventory) {
        this.inventory = inventory;
    }

    public void setArmor(Armor armor) {
        this.armor = armor;
    }

    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }

    //Getters
    public int getHealth() {
        return health;
    }

    public int getExperience() {
        return experience;
    }

    public String getName() {
        return name;
    }

    public List getInventory() {
        return inventory;
    }

    public Armor getArmor() {
        return armor;
    }

    public Weapon getWeapon() {
        return weapon;
    }

}
