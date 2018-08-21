package com.tsguild.milestone1.labs;

import java.util.Scanner;
import java.util.Random;

/**
 *
 * @author souldj673
 */
public class LuckySevens {

    public static void main(String[] args) {
        //Var, Scanner, and Random Declaration and Initialization
        Scanner userInput = new Scanner(System.in);
        Random diceRoller = new Random();
        double cash;
        double maxMoney;
        int rolls = 0;
        int maxRolls = 0;

        //Ask user for $
        System.out.println("Hey, ya got some money? Give it here for a chance to win some more ;)");
        cash = userInput.nextDouble();
        maxMoney = cash;

        /*Cash as text Example
        String cashAsText = userInput.nextLine();
        cash = Double.parseDouble(cashAsText);
         */
        while (cash > 0) {

            //Roll dice and add total
            int rollOne = diceRoller.nextInt(6) + 1;
            int rollTwo = diceRoller.nextInt(6) + 1;
            int diceTotal = rollOne + rollTwo;
            rolls++;

            System.out.println(rollOne + " + " + rollTwo + " = " + diceTotal);

            //Update Money
            if (diceTotal == 7) {
                System.out.println("Hey! You won this round: [" + rolls + "]");
                cash = cash + 4;
                System.out.println("");

                //Check if we had more than we had once!
                if (cash > maxMoney) {
                    maxMoney = cash;
                    maxRolls = rolls;
                }
            } else {
                System.out.println("Lmao you suck: [" + rolls + "]");
                cash--;
                System.out.println("");
            }
        }
        //Maybe start game again
        //If money is gone, end game
        System.out.println("You are broke after " + rolls + " rolls");
        System.out.println("You should have quit after " + maxRolls + " rolls when you had $" + maxMoney);
    }
}
