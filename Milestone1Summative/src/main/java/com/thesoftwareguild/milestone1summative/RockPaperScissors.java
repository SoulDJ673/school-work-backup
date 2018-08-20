package com.thesoftwareguild.milestone1summative;

import java.util.Scanner;
import java.util.Random;

/**
 *
 * @author souldj673
 */
public class RockPaperScissors {

    public static void main(String[] args) {
        //Variable & Etc Declaration and Initialization
        int rounds = 0;
        boolean repeat = true;
        String userReponse;
        int userChoice;
        int roboChoice;
        Scanner userInput = new Scanner(System.in);
        Random entropy = new Random(3);
        boolean userValid = true;
        String[] weapons = {"Rock", "Paper", "Scissors"};

        //Stats Array [0,1,2] [Ties, RoboWins, UserWins]
        int[] stats = new int[3];

        System.out.println("I love playing games of chance, especially Rock, Paper, Scissors!");
        System.out.println("(Lowkey gambling issue)");

        //Actual game starts
        do {
            System.out.println("How many rounds would you like to play?");
            rounds = userInput.nextInt();
            if(rounds >= 1 && rounds <= 10) {
                
            } else {
                if(rounds > 10) {
                    System.out.println("Even I don't have enough time for that, and you shouldn't either if you have a life.");
                }
            }
        } while (repeat == true);
    }
}
