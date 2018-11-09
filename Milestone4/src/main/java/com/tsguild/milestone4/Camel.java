/*
 * Copyright (C) 2018 souldj673
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package com.tsguild.milestone4;

/**
 *
 * @author souldj673
 */
public class Camel {

    private String name;
    private int numberOfHumps;
    private int amountOfSpit;
    private boolean isMad = false;

    //Constructors
    public Camel() {
    }

    public Camel(String name, int numberOfHumps, int amountOfSpit) {
        this.name = name;
        this.numberOfHumps = numberOfHumps;
        this.amountOfSpit = amountOfSpit;
    }

    //Behaviors
    public String spit() {

        if (this.isMad) {
            this.amountOfSpit -= 5;
            this.isMad = false;
            return "SPLOITUH! SPLOITUH! SPLOITUH! SPLOITUH! SPLOITUH!";
        } else if (this.amountOfSpit > 0) {
            this.amountOfSpit--;
            return "SPLOITUH!";
        } else {
            return "Thhhhhh...";
        }
    }

    public String whatKindaCamel() {
        if (this.numberOfHumps == 2) {
            return "Bactrian";
        } else if (this.numberOfHumps == 1) {
            return "Dromedary";
        } else {
            return "Uh... I'm not sure that's even a camel.";
        }
    }

    public void poke() {
        this.isMad = true;
        System.out.println("REEEEEEEE");
    }

    //Getters & Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumberOfHumps() {
        return numberOfHumps;
    }

    public void setNumberOfHumps(int numberOfHumps) {
        this.numberOfHumps = numberOfHumps;
    }

    public int getAmountOfSpit() {
        return amountOfSpit;
    }

    public void setAmountOfSpit(int amountOfSpit) {
        this.amountOfSpit = amountOfSpit;
    }

}
