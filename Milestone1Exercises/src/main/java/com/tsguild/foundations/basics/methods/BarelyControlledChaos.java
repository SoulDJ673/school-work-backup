package com.tsguild.foundations.basics.methods;

import java.util.Random;

/**
 *
 * @author souldj673
 */
public class BarelyControlledChaos {

    private static Random entropy = new Random();

    public static void main(String[] args) {
        //Variable and Misc Initalization
        String color;
        String colorAgain;
        String animal;
        int weight;
        int distance;
        int number;
        int time;

        //Storyteller
        color = colors(entropy.nextInt(101));
        animal = animals(entropy.nextInt(5));
        colorAgain = colors(entropy.nextInt(101));
        weight = weight(entropy.nextInt(200)); // with a range between 5 - 200 
        distance = distance(entropy.nextInt(20)); // with a range between 10 - 20 
        number = number(entropy.nextInt(20000)); // with a range between 10000 - 20000 
        time = time(entropy.nextInt(6)); // with a range between 2 - 6            

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

    //Picker Classes
    public static String colors(int entropyVar) {
        if (entropyVar <= 20) {
            return "blue";
        }
        if (entropyVar <= 40 && entropyVar > 20) {
            return "green";
        }
        if (entropyVar <= 60 && entropyVar > 40) {
            return "red";
        }
        if (entropyVar <= 80 && entropyVar > 60) {
            return "yellow";
        } else {
            return "white";
        }
    }

    public static String animals(int entropyVar) {
        String[] animals = {"dog", "cat", "sheep", "pig", "cow"};
        return animals[entropyVar];
    }

    public static int weight(int entropyVar) {
        while (entropyVar < 5) {
            entropyVar = entropy.nextInt(200);
        }
        return entropyVar;
    }

    public static int distance(int entropyVar) {
        while (entropyVar < 10) {
            entropyVar = entropy.nextInt(20);
        }
        return entropyVar;
    }

    public static int number(int entropyVar) {
        while (entropyVar < 10000) {
            entropyVar = entropy.nextInt(20000);
        }
        return entropyVar;
    }

    public static int time(int entropyVar) {
        while (entropyVar < 2) {
            entropyVar = entropy.nextInt(6);
        }
        return entropyVar;
    }

}
