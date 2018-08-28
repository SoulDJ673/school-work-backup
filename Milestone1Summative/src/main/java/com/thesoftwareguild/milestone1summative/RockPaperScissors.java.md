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
        Random entropy = new Random(2);
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
            //Round Range Valid
            if (rounds >= 1 && rounds <= 10) {
                System.out.print("Awesome, let's start!  ");
                for (int i = 0; i < rounds; i++) {
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
                    roboChoice = entropy.nextInt(2);
                    System.out.println("I chose: " + weapons[roboChoice]);

                    //Data Analysis
                    //Tie
                    if (roboChoice == userChoice) {
                        stats[0]++;
                        System.out.println("It's a tie this round!");
                    }
                    //Robo Wins
                    if (roboChoice == 0 && userChoice == 2) {
                        stats[1]++;
                        System.out.println("Ha! I win this round!");
                    }
                    if (roboChoice == 2 && userChoice == 1) {
                        stats[1]++;
                        System.out.println("Ha! I wint this round!");
                    }
                    if (roboChoice == 1 && userChoice == 0) {
                        stats[1]++;
                        System.out.println("Ha! I win this round!");
                    }
                    //User Wins
                    if (userChoice == 0 && roboChoice == 2) {
                        stats[2]++;
                        System.out.println("Darn, you win this round.");
                    }
                    if (userChoice == 2 && roboChoice == 1) {
                        stats[2]++;
                        System.out.println("Darn, you win this round.");
                    }
                    if (userChoice == 1 && roboChoice == 0) {
                        stats[2]++;
                        System.out.println("Darn, you win this round.");
                    }
                }
            }

            //Print Stats and winner
            if (stats[1] > stats[2]) {
                System.out.println("Ha! I win!");
                System.out.println("Don't feel so bad, nobody beats me.  I'm the best.");
            }
            if (stats[1] < stats[2]) {
                System.out.println("WHAT?!??! YOU WON?!?!?!?! AAAAAGGHHH YOU CHEATED!");
                System.out.println("YOU MUST'VE CHEATED, NOBODY BEATS ME!!");
            }
            if (stats[1] == stats[2]) {
                System.out.println("Hmm.  You're pretty good, but not better than me.  We tied.");
            }
            System.out.println("");
            System.out.println("You won " + stats[2] + " times.");
            System.out.println("I won " + stats[1] + " times.");
            System.out.println("We tied " + stats[0] + " times.");
            System.out.println("");

            //Repeat Prompt
            if (stats[1] < stats[2]) {
                System.out.println("I want a rematch!");
                System.out.println("(Will you challenge him again? [true/false])");
            } else {
                System.out.println("I'll be kind enough to let you attempt to beat me again, though I promise you'll fail.");
                System.out.println("What do you think?");
                System.out.println("(Will you play again? [true/false])");
            }
            repeat = userInput.nextBoolean();
            //False exits loop

        } while (repeat == true);
        //Exit Prompts
        if (stats[1] < stats[2]) {
            System.out.println("AAAAGGGGHHH FINE! YOU MUST NEVER SPEAK OF THIS, CHEATER!!!");
        } else {
            System.out.println("Okay, bye!");
        }
    }
}
