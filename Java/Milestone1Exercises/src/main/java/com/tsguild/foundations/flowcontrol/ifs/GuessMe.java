package com.tsguild.foundations.flowcontrol.ifs;

import java.util.Scanner;

/**
 *
 * @author souldj673
 */
public class GuessMe {

    public static void main(String[] args) {

        //Variable Declaration
        int theNumber = 38;
        int theGuess;
        Scanner userGuess = new Scanner(System.in);

        //Guessing Game
        System.out.println("Let's play a game! I'm thinking of a number between 1-100, try to guess it in one try!");
        System.out.print("Guess a whole number [1-100]: ");
        theGuess = userGuess.nextInt();

        //Too Low
        if (theGuess < theNumber) {
            System.out.println("Ha, nice try - too low! I chose " + theNumber);
        }

        //Too High
        if (theGuess > theNumber) {
            System.out.println("Ha, nice try - too high! I chose " + theNumber);
        } else {
            //Correct
            System.out.println("Wow, nice guess! That was it!");
        }
    }
}
