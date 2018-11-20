package com.tsguild.foundations.random;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author souldj673
 */
public class GuessMeMore {
    public static void main(String[] args) {
        
        //Random, Scanner, and Variable Declaration/Init
        Scanner userGuess = new Scanner(System.in);
        Random thonkNum = new Random();
        int theNumber = thonkNum.nextInt(201) - 100;
        int theGuess;

        
        //Guessing Game
        System.out.println("Let's play a game! I'm thinking of a number between -100 and 100, try to guess it in one try!");
        System.out.print("Guess a whole number [-100 => 100]: ");
        theGuess = userGuess.nextInt();
        
        //Too Low
        if(theGuess < theNumber) {
            System.out.println("Ha, nice try - too low! I chose " + theNumber);
        }
        
        //Too High
        if(theGuess > theNumber) {
            System.out.println("Ha, nice try - too high! I chose " + theNumber);
        } else {
            //Correct
            System.out.println("Wow, nice guess! That was it!");
        }
    }
}
