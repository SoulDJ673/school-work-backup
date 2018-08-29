package com.tsguild.milestone2.challenge.goblinrpg;

import java.util.List;

/**
 *
 * @author souldj673
 */
public class Monster implements Armor, Weapon {

    private int health;
    private int experience;
    private List loot;
    private Armor armor;
    private Weapon weapon;
    private String name;
    private String description;

    //Getters
    public int getHealth() {
        return health;
    }

    public int getExperience() {
        return experience;
    }

    public List getLoot() {
        return loot;
    }

    public Armor getArmor() {
        return armor;
    }

    public Weapon getWeapon() {
        return weapon;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    //Setter
    public void setHealth(int health) {
        this.health = health;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public void setLoot(List loot) {
        this.loot = loot;
    }

    public void setArmor(Armor armor) {
        this.armor = armor;
    }

    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
