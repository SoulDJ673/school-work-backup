package com.tsguild.foundations.random;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author souldj673
 */
//DON'T USE NEXTINT
public class CoinFlipper {

    public static void main(String[] args) {
        //Random, Scanner, Variable Declare/Init
        Scanner pause = new Scanner(System.in); //Used to slow program down
        Random coin = new Random();
        boolean result;
        String side;

        //Dialogue
        System.out.println("       Welcome to Coin Flipper       ");
        System.out.println("|===== Press Enter to Continue =====|");
        pause.nextLine();

        //Flip
        System.out.println("Ready, Set, Flip!!!");
        result = coin.nextBoolean();

        //Convert Boolean to String
        side = coinSide(result);

        //Print Results
        System.out.println("You got " + side + "!");
    }

    //Uses boolean to determine results
    public static String coinSide(boolean result) {
        if (result) {
            return "HEADS";
        } else {
            return "TAILS";
        }
    }
}
