package com.tsguild.foundations.flowcontrol.whiles;

import java.util.Scanner;

/**
 *
 * @author souldj673
 */
public class BewareTheKraken {

    public static void main(String[] args) {
        //Scanner & Response Setup
        Scanner userAnswer = new Scanner(System.in);
        String userResponse;

        System.out.println("Already, get yer flippers & wetsuit on - we're going diving!");
        System.out.println("Here we goooOOooOooo.....! *SPLOOSH*");

        int depthDivedInFt = 0;

        // The ocean is only so deep, 36200 at the deepest survey,
        // Stop at the bottom
        while (depthDivedInFt < 36200) {
            System.out.println("So far, we've swam " + depthDivedInFt + " feet");

            //User Continue Prompt
            System.out.print("Would you like to continue? [y/n] ");
            userResponse = userAnswer.next();
            try {                                                                                   //Input Validation

                // Yes Continues Swim
                if (userResponse.equalsIgnoreCase("y") || userResponse.equalsIgnoreCase("yes")) {
                    System.out.println("\nOkay! Let's go!");

                    //No Ends Voyage
                } else if (userResponse.equalsIgnoreCase("n") || userResponse.equalsIgnoreCase("no")) {
                    System.out.println("\nOkay. Time to go.");
                    break;
                }

            } catch (Exception e) {
                System.out.println("\nIt's a yes or no question.  Your stupidity causes you to continue swimming.");
            }
            
            //Escape Kraken at below 20000
            if (depthDivedInFt >= 20000) {
                System.out.println("OwO I think I see a Kraken, guys ....");
                System.out.println("TIME TO GO!");
                break;
            }

            // Fast Swimmer Owo
            depthDivedInFt += 1000;
        }
        System.out.println("");
        System.out.println("We ended up swimming " + depthDivedInFt + " feet down.");
        System.out.println("I bet we can do better next time!");
    }
}
