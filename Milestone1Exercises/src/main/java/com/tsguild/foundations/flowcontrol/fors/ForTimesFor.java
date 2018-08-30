package com.tsguild.foundations.flowcontrol.fors;

import java.util.Scanner;

/**
 *
 * @author souldj673
 */
public class ForTimesFor {

    private static int[] table = new int[15];

    public static void main(String[] args) {
        //Variable and Scanner Declaration/Init
        int factor;
        Scanner userChoice = new Scanner(System.in);

        //Prompt
        System.out.println("Which times table should I recite?");
        factor = userChoice.nextInt();

        //Generate table
        calculator(factor);

        //Quiz
        for (int i = 0; i <= table.length; i++) {
            System.out.println("What is " + factor + " * " + (i + 1) + "?");
            int answer = userChoice.nextInt();
            validator(i, answer);
        }

    }

    public static void calculator(int factor) {
        //For Loop to calculate table
        for (int i = 0; i < table.length; i++) {
            table[i] = (i + 1) * factor;
        }
    }

    //Verify that user answer is correct
    public static boolean validator(int i, int answer) {
        if (table[i] == answer) {
            System.out.println("Correct!");
            return true;
        } else {
            System.out.println("Incorrect!");
            return false;
        }
    }
}
