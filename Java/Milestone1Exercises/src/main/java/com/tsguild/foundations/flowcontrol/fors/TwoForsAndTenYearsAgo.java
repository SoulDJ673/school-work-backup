package com.tsguild.foundations.flowcontrol.fors;

import java.util.Scanner;

/**
 *
 * @author souldj673
 */
public class TwoForsAndTenYearsAgo {

    public static void main(String[] args) {
        Scanner userInput = new Scanner(System.in);
        System.out.print("What year would you like to count back from? ");
        int year = userInput.nextInt();

        /*
        Range is 0-10.  This one is the most clear because it is very straight
        forward, whereas in the other loop you're forced to do math to figure it
        out.
         */
        for (int i = 0; i <= 10; i++) {
            System.out.println(i + " years ago would be " + (year - i));
        }

        System.out.println("\nI can count backwards using a different way too...");

        for (int i = year; i >= year - 10; i = i - 20) {                        //Range is 10-0 (year => year-10)
            System.out.println((year - i) + " years ago would be " + i);
        }
    }
}
