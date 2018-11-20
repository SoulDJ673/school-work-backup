package com.tsguild.foundations.flowcontrol.fors;

import java.util.Scanner;
/**
 *
 * @author souldj673
 */
public class ForTimes {
    public static void main(String[] args) {
        //Variable and Scanner Declaration/Init
        int factor;
        Scanner userChoice = new Scanner(System.in);
        
        //Prompt
        System.out.println("Which times table should I recite?");
        factor = userChoice.nextInt();
        
        //For Loop to print table
        for (int i = 1; i <= 15; i++) {
            System.out.println(i + " * " + factor + " = " + (factor * i));
        }
    }
}
