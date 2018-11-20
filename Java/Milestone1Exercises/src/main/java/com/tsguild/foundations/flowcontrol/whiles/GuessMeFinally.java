package com.tsguild.foundations.flowcontrol.whiles;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author souldj673
 */
public class GuessMeFinally {

    public static void main(String[] args) {

        //Random, Scanner, Variable Declaration
        Scanner userGuess = new Scanner(System.in);
        Random computerBrain = new Random();
        int theNumber = computerBrain.nextInt(200) - 100;
        int theGuess;

        //Guessing Game Prompt
        System.out.println("Let's play a game! I'm thinking of a number between -100 and 100, try to guess it!");

        //Start While Loop
        while (true) {
            System.out.print("Guess a whole number [-100 -> 100]: ");
            theGuess = userGuess.nextInt();

            if (theGuess == theNumber) {                                //Correct
                System.out.println("\nWow, nice guess! That was it!");
                break;

            } else if (theGuess < theNumber) {                          //Too Low
                System.out.println("\nHa, nice try - too low!");

            } else if (theGuess > theNumber) {                          //Too High
                System.out.println("\nHa, nice try - too high!");
            }
        }
    }
}
