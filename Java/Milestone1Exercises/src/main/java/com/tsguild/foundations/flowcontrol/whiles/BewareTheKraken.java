package com.tsguild.foundations.flowcontrol.whiles;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author souldj673
 */
public class BewareTheKraken {

    public static void main(String[] args) {
        //Scanner & Response Setup
        Scanner userAnswer = new Scanner(System.in);
        boolean userResponse;

        System.out.println("Already, get yer flippers & wetsuit on - we're going diving!");
        System.out.println("Here we goooOOooOooo.....! *SPLOOSH*");

        int depthDivedInFt = 0;

        /*
        If this read true then the program would work as it has been, 
        because of out Kraken condition that prevents us from reaching 
        the limit that's set in this while loop.  However, if that if
        statement didn't exist, we would be allowed to continue swimming
        forever.
         */
        // The ocean is only so deep, 36200 at the deepest survey,
        // Stop at the bottom
        while (depthDivedInFt < 36200) {
            System.out.println("So far, we've swam " + depthDivedInFt + " feet");

            //User Continue Prompt
            System.out.print("Would you like to continue? [y/n] ");
            userResponse = inputValid(userAnswer.next());

            //Use Valid input to Continue/Break
            if (!userResponse) {
                break;
            } else {
            }

            //Escape Kraken at below 20000
            if (depthDivedInFt >= 20000) {
                System.out.println("OwO I think I see a Kraken, guys ....");
                System.out.println("TIME TO GO!");
                break;
            }

            //Fish Prompt
            System.out.println("Ooh look! A " + randomFish() + "!");

            // Fast Swimmer Owo
            depthDivedInFt += 1000;
        }
        System.out.println("");
        System.out.println("We ended up swimming " + depthDivedInFt + " feet down.");
        System.out.println("I bet we can do better next time!");
    }

    //Input Validation
    public static boolean inputValid(String userResponse) {
        try {

            // Yes Continues Swim
            if (userResponse.equalsIgnoreCase("y") || userResponse.equalsIgnoreCase("yes")) {
                System.out.println("\nOkay! Let's go!");
                return true;

                //No Ends Voyage
            } else if (userResponse.equalsIgnoreCase("n") || userResponse.equalsIgnoreCase("no")) {
                System.out.println("\nOkay. Time to go.");
                return false;
            }

        } catch (Exception e) {
            System.out.println("\nIt's a yes or no question.  Your stupidity causes you to continue swimming.");
            return true;
        }

        return true; //This shouldn't occur
    }

    public static String randomFish() {
        //Random and Array Declare/Init
        String[] fish = {"Forgetful Blue Fish", "Nemo fish thing", "Ray", "Jellyfish"};
        Random magic = new Random();

        //Poof, random fish
        return fish[magic.nextInt(fish.length) - 1];
    }
}
