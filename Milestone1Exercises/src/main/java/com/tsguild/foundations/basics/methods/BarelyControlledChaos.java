package com.tsguild.foundations.basics.methods;

import java.util.Random;

/**
 *
 * @author souldj673
 */
public class BarelyControlledChaos {

    public static void main(String[] args) {
        //Variable and Misc Initalization
        Random entropy = new Random();
        int entropyVar;
        String color;
        String colorAgain;
        String animal;
        int weight;
        int distance;
        int number;
        int time;

        color = colors(entropy.nextInt(101));
        animal =;
        colorAgain =;
        weight =;
        // with a range between 5 - 200 
        distance =;
        // with a range between 10 - 20 
        number =;
        // with a range between 10000 - 20000 
        time =;
        // with a range between 2 - 6            

        System.out.println("Once, when I was very small...");

        System.out.println("I was chased by a " + color + ", "
                + weight + "lb " + " miniature " + animal
                + " for over " + distance + " miles!!");

        System.out.println("I had to hide in a field of over "
                + number + " " + colorAgain + " poppies for nearly "
                + time + " hours until it left me alone!");

        System.out.println("\nIt was QUITE the experience, "
                + "let me tell you!");

    }

    public static String colors(int entropyVar) {
        if (entropyVar <= 20) {
            return "blue";
        } if (entropyVar <= 40 && entropyVar > 20) {
            
        }
    }

}
