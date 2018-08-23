package com.thesoftwareguild.milestone1summative;

import java.util.Scanner;

/**
 *
 * @author souldj673
 */
public class HealthyHearts {
    public static void main(String[] args) {
        //Variable & Scanner Declaration and Init
        int age;
        int maxHeartRate;
        int targetMin;
        int targetMax;
        double targetMinTemp;
        double targetMaxTemp;
        Scanner userInput = new Scanner(System.in);
        
        //Age Prompt
        System.out.println("You may not care about your health, but we sure do!");
        System.out.print("What is your age? ");
        age = userInput.nextInt();
        
        //Healthy Math
        //Max Heart Rate
        maxHeartRate = 220 - age;
        
        //Recommended Range (Do Necessary Math and Convert to Int
        targetMinTemp = maxHeartRate * 0.5;
        targetMin = (int) targetMinTemp;
        targetMaxTemp = maxHeartRate * 0.85;
        targetMax = (int) targetMaxTemp;
        
        //Print Results
        System.out.println("Your maximum heart rate should be " + maxHeartRate + " beats per minute.");
        System.out.println("Your target heart rate zone should be " + targetMin + " - " + targetMax + " beats per minute.");
        System.out.println("");
        System.out.println("We hope you'll take this into consideration and take good care of your body!");
        System.out.println("Thanks for stopping by!!!");
    }
}
