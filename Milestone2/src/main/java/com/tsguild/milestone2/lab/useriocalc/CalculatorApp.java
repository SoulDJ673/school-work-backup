package com.tsguild.milestone2.lab.useriocalc;

import com.tsguild.milestone2.lab.userio.*;

/**
 *
 * @author souldj673
 */
public class CalculatorApp {

    public static void main(String[] args) {
        //Init/Declare Vars
        long userNum1;
        long userNum2;
        String userResponse;
        double answer;

        //Build Simple Calculator
        SimpleCalculator calc = new SimpleCalculator();

        //Build User IO Implementation
        UserIO userInOut = new UserIOCalcImpl();

        //Welcome Prompt
        userInOut.print("Welcome to the Calculator\n");

        //More Maths
        while (true) {
            //Menu
            userResponse = userInOut.readString("\nWould you like to add [+], subtract [-], multiply [*], divide [/], or use an exponent [^]?\nAnything else will exit the program.\n");

            //Spacing for looks
            userInOut.print("\n");

            //Determine Operation then call corresponding method
            switch (userResponse) {

                //Each Case will have context aware prompts that will ask for the operands
                case "+":
                    userInOut.print("Which two numbers would you like to add? (NO RATIONAL NUMBERS)\n");
                    userNum1 = userInOut.readLong("Number 1: ");
                    userNum2 = userInOut.readLong("Number 2: ");

                    answer = calc.addition(userNum1, userNum2);
                    break;

                case "-":
                    userInOut.print("Which two numbers would you like to subtract? (NO RATIONAL NUMBERS)\n");
                    userNum1 = userInOut.readLong("Number 1: ");
                    userNum2 = userInOut.readLong("Number 2: ");

                    answer = calc.subtraction(userNum1, userNum2);
                    break;

                case "*":
                    userInOut.print("Which two numbers would you like to multiply? (NO RATIONAL NUMBERS)\n");
                    userNum1 = userInOut.readLong("Number 1: ");
                    userNum2 = userInOut.readLong("Number 2: ");

                    answer = calc.multiplication(userNum1, userNum2);
                    break;

                case "/":
                    userInOut.print("Which two numbers would you like to divide? (NO RATIONAL NUMBERS)\n");
                    userNum1 = userInOut.readLong("Number 1: ");
                    userNum2 = userInOut.readLong("Number 2: ");

                    answer = calc.division(userNum1, userNum2);
                    break;

                case "^":
                    userInOut.print("(NO RATIONAL NUMBERS)\n");
                    userNum1 = userInOut.readLong("The base number: ");
                    userNum2 = userInOut.readLong("The exponent: ");

                    answer = calc.exponents(userNum1, userNum2);
                    break;

                default:
                    userInOut.print("Thanks for choosing me as your calculating companion!\n");
                    userInOut.print("Happy mathing!\n");
                    return;
            }

            //Print out result of calculations
            userInOut.print("The answer is: " + answer + "\n");

        }
    }
}
