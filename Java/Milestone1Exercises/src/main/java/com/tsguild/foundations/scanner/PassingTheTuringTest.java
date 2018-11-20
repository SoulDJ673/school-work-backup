package com.tsguild.foundations.scanner;

import java.util.Scanner;

/**
 *
 * @author souldj673
 */
public class PassingTheTuringTest {

    public static void main(String[] args) {
        //Scanner Declare/Init
        Scanner userInput = new Scanner(System.in);

        //Variable Declares & Inits
        String userName;
        String userColor;
        String userFruit;
        int userNumber;

        //Convo Start
        System.out.println("Hello there!");
        System.out.print("What's your name? "); //Name prompt
        userName = userInput.next();

        System.out.println("");

        System.out.print("Hi, " + userName + "! What's your favorite color? "); //Color prompt
        userColor = userInput.next();

        System.out.println("");

        System.out.println("Huh, " + userColor + "? Mine's Electric Lime.");
        
        System.out.println("");
        
        System.out.println("I really like limes. They're my favorite fruit, too.");
        System.out.print("What's YOUR favorite fruit, " + userName + "? "); //Fruit prompt
        userFruit = userInput.next();
        
        System.out.println("");
        
        System.out.println("Really? " + userFruit + "? That's wild!");
        System.out.print("Speaking of favorites, what's your favorite number? "); //Number prompt
        userNumber = userInput.nextInt();
        
        System.out.println("");
        
        System.out.println(userNumber + " is a cool number. Mine's -7.");
        System.out.println("Did you know " + userNumber + " * -7 is " + (userNumber * -7) + "? That's a cool number too!");
        
        System.out.println("");
        
        System.out.println("Well, thanks for talking to me, " + userName + "!");
    }
}
