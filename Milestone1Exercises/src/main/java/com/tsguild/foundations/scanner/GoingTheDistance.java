package com.tsguild.foundations.scanner;

import java.util.Scanner;

/**
 *
 * @author souldj673
 */
public class GoingTheDistance {

    public static void main(String[] args) {
        //Scanner Declare/Init
        Scanner userInput = new Scanner(System.in);

        //Variable Declare/Init
        double speed;
        double time;

        //Prompts
        System.out.print("How fast are you going (mph)? ");
        speed = userInput.nextDouble();

        System.out.print("How long are you going to keep at it (hr)? ");
        time = userInput.nextDouble();

        //Math
        System.out.println("Wow! That means you'll be traveling " + (speed * time) + " miles!");
    }
}
