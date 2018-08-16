package com.tsguild.milestone1.labs;

import java.util.Scanner;

/**
 *
 * @author souldj673
 */
public class Factorizer {

    public static void main(String[] args) {
        //Variable Setup
        Scanner userInput = new Scanner(System.in);
        int number;
        String repeat = "n";
        boolean tape = true;

        //Number Prompt
        System.out.println("I'm the Factoring Monster >:) Give me a number to munch on!!!  I only like natural counting numbers.");

        //Allow Continued Factorization - Manditory 1 run
        do {
            tape = true;
            System.out.print("Number to factor: ");
            number = userInput.nextInt();
            System.out.println("");

            //Call Factorizer Method
            Factorizer(number);

            //Repeat prompt
            while (tape == true) {
                repeat = userInput.nextLine();

                //Response Validation
                switch (repeat) {
                    case "y":
                        tape = false;
                        break;
                    case "n":
                        tape = false;
                        break;
                    case "Y":
                        tape = false;
                        break;
                    case "N":
                        tape = false;
                        break;
                    default:
                        //Actual Text Prompt that appears
                        System.out.println("");
                        System.out.println("FEED ME MORE !!! >:( [y/N]");
                }
            }
            //Use Repeat Prompt response to repeat scope or end program
        } while (repeat.equalsIgnoreCase("y"));

        //Conclusion
        System.out.println("");
        System.out.println("Thanks for feeding me!");
    }

    //Method that actually does the math
    public static void Factorizer(int number) {
        int totalFactors = 0;
        int factorSum = 0;

        //Binary Number
        if (number == 1) {
            System.out.println("1 is a special number.  It's factor is only itself.  It is prime but not perfect.");
            System.out.println("1 is referred to as a binary number.");
        } else {

            //Determine Factors
            System.out.print("The factors of " + number + " are: ");
            for (int i = 1; i < number; i++) {
                if (number % i == 0) {
                    totalFactors++;
                    System.out.println(i + " ");
                    factorSum += i;
                } else {
                    continue;
                }
            }
            System.out.println("");
            System.out.println(number + " has " + totalFactors + " factors.");

            //Prime Determination
            if (factorSum == 1) {
                System.out.println("Prime: Yes ");
            } else {
                System.out.println("Prime: No ");
            }

            //Perfect Determination
            if (factorSum == number) {
                System.out.println("Perfect: Yes ");
            } else {
                System.out.println("Perfect: No ");
            }

        }
    }
}
