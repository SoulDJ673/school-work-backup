package com.tsguild.foundations.random;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author souldj673
 */
public class HighRoller {

    public static void main(String[] args) {
        //Random, Scanner, and Variable Declaration/Initialization
        Random diceRoller = new Random();
        Scanner userInput = new Scanner(System.in);
        int diceSides;

        //Interactive - Dice Sides Prompt
        System.out.println(">>> Dice Roller >>>");
        System.out.print("How many sides will the die have? ");
        diceSides = userInput.nextInt();

        //Rolling
        int rollResult = diceRoller.nextInt(diceSides) + 1;

        System.out.println("TIME TO ROOOOOOLL THE DICE!");
        System.out.println("I rolled a " + rollResult);

        //1 & Max Dialogues
        if (rollResult == 1) {
            System.out.println("You rolled a crit failure! Ouch.");
        } else if (rollResult == diceSides) {
            System.out.println("You rolled a critical! Nice Job!");
        }
    }
}
