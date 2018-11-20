package com.tsguild.milestone2.challenge.goblinrpg;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 *
 * @author souldj673
 */
public class Goblin {

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

    //Attack against Monster
    public boolean attack(Monster foe) {
        Random crits = new Random();
        int damageToDo = crits.nextInt(3);
        if (weapon == null) { //Attack if no weapon
            System.out.println("Using your fists? You're so brave " + this.name + "uuuu!");
            damageToDo += 1;
        } else { //Attack with weapon
            System.out.println("Yeah! Beat 'em with your " + this.weapon.getName() + "!");
            damageToDo = this.weapon.strike() + damageToDo;
        }

        int damageDone = foe.takeDamage(damageToDo);
        System.out.println(this.name + "u, you've done " + damageDone + " damage to " + foe.getName() + "!");
        return foe.isDead();
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
        System.out.println(this.name + "uuu! You've taken " + damageToTake + " damage!");
        return damageToTake;
    }

    /*
    //Healing
    public int heal(int health) {

    }
     */
    //isDead
    public boolean isDead() {
        return this.health < 1;
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
