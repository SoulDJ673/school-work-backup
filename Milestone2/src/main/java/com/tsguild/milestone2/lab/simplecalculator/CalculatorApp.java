package com.tsguild.milestone2.lab.simplecalculator;

import java.util.Scanner;

/**
 *
 * @author souldj673
 */
public class CalculatorApp {

    public static void main(String[] args) {
        //Init/Declare Vars and Scanner
        Scanner userInput = new Scanner(System.in);
        long userNum1;
        long userNum2;
        String userResponse;
        double answer;

        //Build Simple Calculator
        SimpleCalculator calc = new SimpleCalculator();

        //Welcome Prompt
        System.out.println("Welcome to the Calculator");

        //More Maths
        while (true) {
            //Menu
            System.out.println("\nWould you like to add [+], subtract [-], multiply [*], divide [/], or use an exponent [^]?");
            System.out.println("Anything else will exit the program.");
            userResponse = userInput.next();

            //Spacing for looks
            System.out.println("");

            //Determine Operation then call corresponding method
            switch (userResponse) {

                //Each Case will have context aware prompts that will ask for the operands
                case "+":
                    System.out.println("Which two numbers would you like to add? (NO RATIONAL NUMBERS)");
                    System.out.print("Number 1: ");
                    userNum1 = userInput.nextLong();
                    System.out.print("Number 2: ");
                    userNum2 = userInput.nextLong();

                    answer = calc.addition(userNum1, userNum2);
                    break;

                case "-":
                    System.out.println("Which two numbers would you like to subtract? (NO RATIONAL NUMBERS)");
                    System.out.print("Number 1: ");
                    userNum1 = userInput.nextLong();
                    System.out.print("Number 2: ");
                    userNum2 = userInput.nextLong();

                    answer = calc.subtraction(userNum1, userNum2);
                    break;

                case "*":
                    System.out.println("Which two numbers would you like to multiply? (NO RATIONAL NUMBERS)");
                    System.out.print("Number 1: ");
                    userNum1 = userInput.nextLong();
                    System.out.print("Number 2: ");
                    userNum2 = userInput.nextLong();

                    answer = calc.addition(userNum1, userNum2);
                    break;

                case "/":
                    System.out.println("Which two numbers would you like to divide? (NO RATIONAL NUMBERS)");
                    System.out.print("Number 1: ");
                    userNum1 = userInput.nextLong();
                    System.out.print("Number 2: ");
                    userNum2 = userInput.nextLong();

                    answer = calc.division(userNum1, userNum2);
                    break;

                case "^":
                    System.out.println("(NO RATIONAL NUMBERS)");
                    System.out.print("The base number: ");
                    userNum1 = userInput.nextLong();
                    System.out.print("The exponent: ");
                    userNum2 = userInput.nextLong();

                    answer = calc.exponents(userNum1, userNum2);
                    break;

                default:
                    System.out.println("Thanks for choosing me as your calculating companion!");
                    System.out.println("Happy mathing!");
                    return;
            }

            //Print out result of calculations
            System.out.println("The answer is: " + answer);

        }
    }
}
