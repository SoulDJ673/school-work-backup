package com.tsguild.foundations.random;

import java.util.Random;

/**
 *
 * @author souldj673
 */
public class Opinionator {

    public static void main(String[] args) {
        Random randomizer = new Random();
        System.out.println("I can't decide what animal I like the best.");
        System.out.println("I know! Random can decide FOR ME!");

        int x = randomizer.nextInt(6);

        System.out.println("The number we chose was: " + x);

        switch (x) {
            case 0:
                System.out.println("Llamas are the best!");
                break;
            case 1:
                System.out.println("Dodos are the best!");
                break;
            case 2:
                System.out.println("Woolly Mammoths are DEFINITELY the best!");
                break;
            case 3:
                System.out.println("Sharks are the greatest, they have their own week!");
                break;
            case 4:
                System.out.println("Cockatoos are just so awesome!");
                break;
            case 5:
                System.out.println("Have you ever met a Mole-Rat? They're GREAT!");
                break;
            default:
                break;
        }

        System.out.println("Thanks Random, maybe YOU'RE the best!");
    }
}

//There aren't any obvious bugs that I'm able to spot.  I did change the if/else statements to a switch case because it's easier to look at.
//Because the randomizer is set to a range of 0-4, case 5 will never occur.  This could be a bug
