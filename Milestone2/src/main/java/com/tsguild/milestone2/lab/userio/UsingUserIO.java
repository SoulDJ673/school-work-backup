/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tsguild.milestone2.lab.userio;

/**
 *
 * @author ahill
 */
public class UsingUserIO {

    public static void main(String[] args) {

        UserIO yourUserIO = null;
        yourUserIO = new UserIOCalcImpl(); // Uncomment this when you've pasted in your UserIO

        yourUserIO.print("WOW! That's a cool UserIO you've built.\n");

        String favColor = yourUserIO.readString("What's your favorite color? ");
        yourUserIO.print("\n" + favColor + " is a good one. Mine's peacock green.\n");

        int cats = yourUserIO.readInt("Okay, how many cats have you owned? ");
        yourUserIO.print("\n" + cats + " doesn't seem like THAT many cats. Huh.\n");

        double coffee = yourUserIO.readDouble("How many cups of coffee have you drank today? ");
        yourUserIO.print("\nHa! Well I've drank " + (coffee + 3) + " cups!\n");

        long miles = yourUserIO.readLong("How many miles from the sun are we, do you think? ");
        yourUserIO.print("\n" + miles + " seems so very far away!\n");

        float airspeed = yourUserIO.readFloat("What is the airspeed velocity of an unladen swallow? ");
        yourUserIO.print("\nHeh. I thought it was only " + (airspeed / 4) + "!\n");

        int num = yourUserIO.readInt("Give me a number between 1 & 10 ...", 1, 10);
        yourUserIO.print("\n" + num + " - not bad! I would have picked 3.\n");

        double loveJava = yourUserIO.readDouble("On a scale of 0 to 100, how much do you love java? ", 0, 100);
        yourUserIO.print("\nHa! " + loveJava + ", huh? I would have said 101!\n");

        long what = yourUserIO.readLong("Can you guess a number between -1000 and 1000? ", -1000, 1000);
        yourUserIO.print("\n" + what + " was right!\n");

        float chocolate = yourUserIO.readFloat("What is fraction of chocolate needed to make coffee taste like a mocha? (0 - 100%)", 0, 100);
        if (chocolate > 70) {
            yourUserIO.print("\n" + (chocolate * 100) + "%! You must really like chocolate.");
        } else if (chocolate < 20) {
            yourUserIO.print("\nOnly, " + (chocolate * 100) + "%?! You must be really sensitive to chocolate.");
        } else {
            yourUserIO.print("\nInteresting. " + (chocolate * 100) + "% is not what I would have chosen.");
        }

    }

}
