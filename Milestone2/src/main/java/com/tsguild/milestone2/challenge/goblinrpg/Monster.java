package com.tsguild.milestone2.challenge.goblinrpg;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 *
 * @author souldj673
 */
public class Monster {

    //Properties
    private int health;
    private int experience;
    private List loot;
    private Armor armor;
    private Weapon weapon;
    private String name;
    private String description;

    //No Args Constructor
    public Monster() {
        this.name = "Big Bug";
        this.description = "A giant black beetle.";

        this.health = 10;
        this.experience = 0;

        this.loot = new ArrayList();

        this.armor = null;
        this.weapon = null;
    }

    //Attacking?
    public boolean attack(Goblin goblin) {
        Random crits = new Random();
        int damageToDo = crits.nextInt(2);
        if (weapon == null) { //Attack if no weapon
            damageToDo += 2;
        } else { //Attack with weapon
            damageToDo = this.weapon.strike() + damageToDo;
        }

        int damageDone = goblin.takeDamage(damageToDo);
        return goblin.isDead();
    }

    //Damage Taken
    public int takeDamage(int damage) {
        int damageToTake = damage;
        if (this.armor != null) { //Check for armor
            damageToTake = this.armor.protect(damage);
        }

        this.health = this.health - damageToTake; //Take Damage Accordingly
        if (this.health < 0) { //If health goes below 0, reset to 0
            this.health = 0;
        }
        return damageToTake;
    }

    //Healing
    public void heal(int health) {

    }

    //isDead
    public boolean isDead() {
        return this.health < 1;
    }

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

    //Setters
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
