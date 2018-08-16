package com.tsguild.foundations.basics.arrays;

import java.util.Random;

/**
 *
 * @author souldj673
 */
public class HiddenNuts {

    public static void main(String[] args) {
        //Setup hiding array & random
        String[] hidingSpots = new String[100];
        Random squirrel = new Random();

        //Hiding nut
        hidingSpots[squirrel.nextInt(hidingSpots.length)] = "Nut";
        System.out.println("The nut has been hidden...");

        //Finding Nut
        for (int i = 0; i < hidingSpots.length; i++) {
            if ("Nut".equals(hidingSpots[i])) {
                System.out.println("Found it! It's in spot " + i);
            }
        }
    }
}
