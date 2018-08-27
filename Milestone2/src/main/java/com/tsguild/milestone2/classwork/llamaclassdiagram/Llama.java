package com.tsguild.milestone2.classwork.llamaclassdiagram;

/**
 *
 * @author souldj673
 */
public class Llama {

    //Property Declaration
    private int numLegs;
    private int yearsOld;
    private String woolType;
    private String woolColor;
    private String name;

    //Llama Constructors
    public Llama() {
        this.numLegs = 4;
        this.yearsOld = 7;
        this.woolType = "Fluffy";
        this.woolColor = "Brown";
        this.name = "Llama";
    }

    public Llama(int numLegs, int yearsOld, String woolType, String woolColor, String name) {
        this.numLegs = numLegs;
        this.yearsOld = yearsOld;
        this.woolType = woolType;
        this.woolColor = woolColor;
        this.name = name;
    }

    //Getter Methods
    public int getNumLegs() {
        return this.numLegs;
    }

    public int getYearsOld() {
        return this.yearsOld;
    }

    public String getWoolType() {
        return this.woolType;
    }

    public String getWoolColor() {
        return this.woolColor;
    }

    public String getName() {
        return this.name;
    }

    //Setter Methods
    public void setNumLegs(int legs) {
        this.numLegs = legs;
    }

    public void setYearsOld(int age) {
        this.yearsOld = age;
    }

    public void setWoolType(String type) {
        this.woolType = type;
    }

    public void setWoolColor(String color) {
        this.woolColor = color;
    }

    public void setName(String name) {
        this.name = name;
    }
}
