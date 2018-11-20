package com.tsguild.milestone2.codealong.files;

/**
 *
 * @author souldj673
 */
public class Llama {

    private String name;
    private String woolColor;
    private String woolType;
    private int age;
    private double woolLength;
    private boolean canDrive;

    //All Args Constructor
    public Llama(String name, String woolColor, String woolType, int age, double woolLength, boolean canDrive) {
        this.name = name;
        this.woolColor = woolColor;
        this.woolType = woolType;
        this.age = age;
        this.woolLength = woolLength;
        this.canDrive = canDrive;
    }

    public Llama() {
    }

    //Getters and Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getWoolColor() {
        return woolColor;
    }

    public void setWoolColor(String woolColor) {
        this.woolColor = woolColor;
    }

    public String getWoolType() {
        return woolType;
    }

    public void setWoolType(String woolType) {
        this.woolType = woolType;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getWoolLength() {
        return woolLength;
    }

    public void setWoolLength(double woolLength) {
        this.woolLength = woolLength;
    }

    public boolean isCanDrive() {
        return canDrive;
    }

    public void setCanDrive(boolean canDrive) {
        this.canDrive = canDrive;
    }

}
