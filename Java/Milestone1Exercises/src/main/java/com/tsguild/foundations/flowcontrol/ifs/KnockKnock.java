package com.tsguild.foundations.flowcontrol.ifs;

import java.util.Scanner;

/**
 *
 * @author souldj673
 */
public class KnockKnock {

    public static void main(String[] args) {

        Scanner inputReader = new Scanner(System.in);

        System.out.print("Knock Knock! Guess who!! ");
        String nameGuess = inputReader.nextLine();

        //If the capitalization is incorrect, then Java won't see the two strings as equal.  This can be solved by using String.equalsIgnoreCase
        if (nameGuess.equals("Marty McFly")) { //While the code may compile, using == to compare strings is improper and could lead to bugs if done incorrectly
            System.out.println("Hey! That's right! I'm back!");
            System.out.println(".... from the Future."); // Sorry, had to!
        } else {
            System.out.println("Dude, do I -look- like " + nameGuess);
        }
    }
}
