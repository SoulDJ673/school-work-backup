package com.thesoftwareguild.milestone1summative;

import java.util.Scanner;
import java.util.Random;

/**
 *
 * @author souldj673
 */
public class DogGenetics {

    public static void main(String[] args) {
        //Initializations and Declarations
        Random genetics = new Random();
        Scanner dogOwner = new Scanner(System.in);
        int[] dogBackground = new int[5];
        String dogName;
        int dogPercentSum;

        //Name Prompt
        System.out.println("Hello, welcome to DoggoDNA.com!");
        System.out.println("+++++++++++++++++++++++++++++++");
        System.out.println("What is your dog's name?");

        dogName = dogOwner.nextLine();

        //Elevator Music
        System.out.println("");
        System.out.println("Please hold for just a second while our team puts together some records of your dog...");

        //DNA Math Magic
        //Generate Random Percents Continuously until a set adds to 100
        do {
            dogPercentSum = 0;
            dogBackground[0] = genetics.nextInt(100);
            dogBackground[1] = genetics.nextInt(100);
            dogBackground[2] = genetics.nextInt(100);
            dogBackground[3] = genetics.nextInt(100);
            dogBackground[4] = genetics.nextInt(100);

            for (int i = 0; i < dogBackground.length; i++) {
                dogPercentSum += dogBackground[i];
            }
        } while (dogPercentSum != 100);

        //Checking & Fixing Validity of Generated Numbers (0 is Invalid)
        for (int i = 0; i < dogBackground.length; i++) {
            if (dogBackground[i] == 0) {
                if (dogBackground[0] != 0) {
                    dogBackground[0] = dogBackground[0] - 1;
                    dogBackground[i] += dogBackground[i];
                }
                if (dogBackground[1] != 0) {
                    dogBackground[1] = dogBackground[1] - 1;
                    dogBackground[i] += dogBackground[i];
                }
                if (dogBackground[2] != 0) {
                    dogBackground[2] = dogBackground[2] - 1;
                    dogBackground[i] += dogBackground[i];
                }
                if (dogBackground[3] != 0) {
                    dogBackground[3] = dogBackground[3] - 1;
                    dogBackground[i] += dogBackground[i];
                }
                if (dogBackground[4] != 0) {
                    dogBackground[4] = dogBackground[4] - 1;
                    dogBackground[i] += dogBackground[i];
                }
            }
        }
        //Done Thinking!
        System.out.println("We've got it!  " + dogName + " is:");
        System.out.println("");

        //Print DNA Results
        System.out.println(dogBackground[0] + "% St. Bernard");
        System.out.println(dogBackground[1] + "% Chihuahua");
        System.out.println(dogBackground[2] + "% Dramatic RedNosed Asian Pug");
        System.out.println(dogBackground[3] + "% Common Cur");
        System.out.println(dogBackground[4] + "% King Doberman");

    }
}
