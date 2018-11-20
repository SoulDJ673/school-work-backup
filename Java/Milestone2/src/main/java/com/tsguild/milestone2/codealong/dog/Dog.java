package com.tsguild.milestone2.codealong.dog;

import java.awt.Color;

/**
 *
 * @author souldj673
 */
public class Dog {

    private String name;
    private double weight;
    private int age;
    private Color furColor;
    private Trick[] tricksKnown;

    //This is defining the no args (no params) constructor for the Dog class (Charles constructor)
    public Dog() {
        this.name = "Charles";
        this.weight = 200.0;
        this.age = 42;
        this.furColor = Color.BLACK;
        this.tricksKnown = new Trick[0];
    }

    //This is defining a more flexible contructor for the Dog Class - OVERLOADING
    public Dog(String name, double weight, int age) {
        this.name = name;
        this.weight = weight;
        this.age = age;
        this.furColor = Color.BLACK;
        this.tricksKnown = new Trick[0];
    }

    /*
    These are getters for all Dog properties
    Every getter has the following pattern
    access modifier - public
    return type - matches property type
    name - get<PropName>
    param list - ()
     */
    public double getWeight() {
        return this.weight;
    }

    public String getName() {
        return this.name;
    }

    public int getAge() {
        return this.age;
    }

    public Color getFurColor() {
        return this.furColor;
    }

    public Trick[] getTricksKnown() {
        return this.tricksKnown;
    }

    /*
    These are setters for all Dog properties
    Every getter has the following pattern
    access modifier - public
    return type - void
    name - set<PropName>
    param list - (PropertyType propertyName)
     */
    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    //BEHAVIORS
    public void bark() {
        System.out.println("BARK!");
    }
}
