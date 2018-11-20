package com.tsguild.foundations.scanner;

import java.util.Scanner;

/**
 *
 * @author souldj673
 */
public class MiniMadLibs {

    public static void main(String[] args) {
        //Scanner Declare/Init
        Scanner input = new Scanner(System.in);

        //Variables
        String noun1;
        String noun2;
        String adjective1;
        String adjective2;
        String number; //I used a string here because the number isn't used for any math, so it wouldn't matter.  I also didn't want the program to crash if this value isn't a number
        String nouns1;
        String nouns2;
        String nouns3;
        String verb;
        String verbed;

        //Filling in the nulls
        System.out.print("I need a noun: ");
        noun1 = input.next();

        System.out.print("\nNow an adjective: ");
        adjective1 = input.next();

        System.out.print("\nAnother noun: ");
        noun2 = input.next();

        System.out.print("\nA number: ");
        number = input.next();

        System.out.print("\nAnother adjective: ");
        adjective2 = input.next();

        System.out.print("\nA plural noun: ");
        nouns1 = input.next();

        System.out.print("\nAnother: ");
        nouns2 = input.next();

        System.out.print("\nOne more: ");
        nouns3 = input.next();

        System.out.print("\nA verb (present tense): ");
        verb = input.next();

        System.out.print("\nSame verb (past tense): ");
        verbed = input.next();

        //Mad Libs Starts
        System.out.println("");
        System.out.println("Filling in the blanks...");
        System.out.println(noun1 + ": the " + adjective1 + " frontier. These are the voyages of the starship " + noun2 + ". Its " + number + "-year mission: to explore strange " + adjective2 + " " + nouns1 + ", to seek out " + adjective2 + " " + nouns2 + " and " + adjective2 + " " + nouns3 + ", to boldly " + verb + " where no one has " + verbed + " before.");
    }
}
