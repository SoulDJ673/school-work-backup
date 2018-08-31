package com.tsguild.foundations.scanner;

import java.util.Scanner;

/**
 *
 * @author souldj673
 */
public class AllTheTrivia {

    public static void main(String[] args) {
        //Scanner Declare/Init
        Scanner userFacts = new Scanner(System.in);

        //Fact Variables
        String tera;
        String clockwise;
        String volcano;
        String element;

        //Questions
        System.out.print("1,024 Gigabytes is equal to one what? ");
        tera = userFacts.next();

        System.out.print("\nIn our solar system which is the only planet that rotates clockwise? ");
        clockwise = userFacts.next();

        System.out.print("\nThe largest volcano ever discovered in our solar system is located on which planet? ");
        volcano = userFacts.next();

        System.out.print("\nWhat is the most abundant element in the earth's atmosphere? ");
        element = userFacts.next();

        //Confusion
        System.out.println("Wow, 1,024 Gigabytes is a " + volcano + "!");
        System.out.println("I didn't know that the largest ever volcano was discovered on " + tera + "!");
        System.out.println("That's amazing that " + clockwise + " is the most abundant element in the atmosphere...");
        System.out.println(element + " is the only planet that rotates clockwise, neat!");
    }
}
