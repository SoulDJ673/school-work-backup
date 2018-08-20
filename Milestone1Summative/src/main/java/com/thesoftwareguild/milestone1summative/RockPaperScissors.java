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
        String userResponse;
        int userChoice = 10;
        int roboChoice = 10;
        Scanner userInput = new Scanner(System.in);
        Random entropy = new Random(3);
        boolean userValid = false;
        String[] weapons = {"Rock", "Paper", "Scissors"};

        //Stats Array [0,1,2] [Ties, RoboWins, UserWins]
        int[] stats = new int[3];

        System.out.println("I love playing games of chance, especially Rock, Paper, Scissors!");
        System.out.println("(Lowkey gambling issue)");

        //Actual game starts
        do {
            System.out.println("How many rounds would you like to play?");
            rounds = userInput.nextInt();
            if (rounds >= 1 && rounds <= 10) {
                System.out.print("Awesome, let's start!  ");
                for (int i = 0; i <= rounds; i++) {
                    while (userValid == false) {
                        System.out.println("Rock, paper, or scissors?");
                        userResponse = userInput.next();
                        userResponse = userResponse.toLowerCase();

//User Input Validation
                        switch (userResponse) {
                            case "rock":
                                userChoice = 0;
                                userValid = true;
                                break;
                            case "r":
                                userChoice = 0;
                                userValid = true;
                                break;
                            case "paper":
                                userChoice = 1;
                                userValid = true;
                                break;
                            case "p":
                                userChoice = 1;
                                userValid = true;
                                break;
                            case "scissors":
                                userChoice = 2;
                                userValid = true;
                                break;
                            case "s":
                                userChoice = 2;
                                userValid = true;
                                break;
                            default:
                                System.out.println("Invalid input.  Seriously, pick one.");
                        }
                    }
                    //Robot Chooses Weapon
                    roboChoice = entropy.nextInt();
                    System.out.println("I chose: " + weapons[roboChoice]);

                    //Data Analysis
                    if (roboChoice == userChoice) {
                        stats[0]++;
                        System.out.println("It's a tie this round!");
                    }
                }
            }

            //Invalid round range ends program
            if (rounds > 10) {
                System.out.println("Even I don't have enough time for that, and you shouldn't either if you have a life.");
                System.out.println("I'm gonna go find someone else to play with.");
                return;
            }
            if (rounds < 1) {
                System.out.println("Really? If you didn't want to play then why'd you even show up?");
                System.out.println("Stop wasting my time, go away.");
                return;
            }

        } while (repeat == true);

    }
}
