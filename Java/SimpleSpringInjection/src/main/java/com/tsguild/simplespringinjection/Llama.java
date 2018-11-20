package com.tsguild.simplespringinjection;

/**
 *
 * @author souldj673
 */
public class Llama {

    private String name;
    private String woolColor;
    private Llama dam;
    private Llama sire;

    public Llama getDam() {
        return dam;
    }

    public void setDam(Llama dam) {
        this.dam = dam;
    }

    public Llama getSire() {
        return sire;
    }

    public void setSire(Llama sire) {
        this.sire = sire;
    }

    public Llama(String name, String woolColor, Llama dam, Llama sire) {
        this.name = name;
        this.woolColor = woolColor;
        this.dam = dam;
        this.sire = sire;
    }

    public Llama(String name, String woolColor) {
        this.name = name;
        this.woolColor = woolColor;
    }

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

    @Override
    public String toString() {
        return "Llama{" + "name=" + name + ", woolColor=" + woolColor + '}';
    }

}
