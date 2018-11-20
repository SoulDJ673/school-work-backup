package com.tsguild.milestone2.lab.statecapitals;

/**
 *
 * @author souldj673
 */
public class Capital {

    //Properties
    private String name;
    private long population;
    private int sqrMiles;

    //All Args Constructor
    public Capital(String name, long population, int sqrMiles) {
        this.name = name;
        this.population = population;
        this.sqrMiles = sqrMiles;
    }

    //Getters and Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getPopulation() {
        return population;
    }

    public void setPopulation(long population) {
        this.population = population;
    }

    public int getSqrMiles() {
        return sqrMiles;
    }

    public void setSqrMiles(int sqrMiles) {
        this.sqrMiles = sqrMiles;
    }

}
