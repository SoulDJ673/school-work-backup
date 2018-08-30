package com.tsguild.foundations.flowcontrol.fors;

import java.util.Scanner;

/**
 *
 * @author souldj673
 */
public class ForTimesFor {

    private static int[] table;

    public static void main(String[] args) {
        //Variable and Scanner Declaration/Init
        int factor;
        Scanner userChoice = new Scanner(System.in);

        //Prompt
        System.out.println("Which times table should I recite?");
        factor = userChoice.nextInt();
        

    }

    public static String calculator(int factor, int answer) {
        //For Loop to calculate table
        for (int i = 1; i <= 15; i++) {
            table[i] = i * factor;
        }
    }
}
