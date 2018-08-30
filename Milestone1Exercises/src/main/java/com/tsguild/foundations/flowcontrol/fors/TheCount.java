package com.tsguild.foundations.flowcontrol.fors;

import java.util.Scanner;

/**
 *
 * @author souldj673
 */
public class TheCount {

    public static void main(String[] args) {
        //Variable & Scanner Declare/Init
        int start;
        int stop;
        int increment;
        int cackle = 0;
        Scanner userInput = new Scanner(System.in);

        //User gives required elements
        System.out.println("*** I LOVE TO COUNT! LET ME SHARE MY COUNTING WITH YOU! ***");

        System.out.print("Start at: ");
        start = userInput.nextInt();

        System.out.print("End at: ");
        stop = userInput.nextInt();

        System.out.print("Increment by: ");
        increment = userInput.nextInt();

        //For Counter
        for (int i = start; i < stop; i = i + increment) {
            System.out.print(i + " ");
            cackle++;
            
            if (cackle % 3 == 0) {
                System.out.println(" - Ah ah ah!");
            }
        }

    }
}
