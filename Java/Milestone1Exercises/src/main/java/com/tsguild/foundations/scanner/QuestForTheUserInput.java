package com.tsguild.foundations.scanner;

import java.util.Scanner;

/**
 *
 * @author souldj673
 */
public class QuestForTheUserInput {
    public static void main(String[] args) {
        Scanner inputReader = new Scanner(System.in);
        
        String yourName;
        String yourQuest;
        double velocityOfSwallow;
        
        System.out.print("What is your name??? ");
        yourName = inputReader.nextLine();
        
        System.out.print("What is your quest??? ");
        yourQuest = inputReader.nextLine();
        
        System.out.print("What is the airspeed velocity of an unladen swallow?!?!? ");
        velocityOfSwallow = inputReader.nextDouble();
        
        System.out.println("How do you know " + velocityOfSwallow + " is correct " + yourName + "?");
        System.out.println("You didn't even know if the swallow was African or Eupoean!");
        
        System.out.println("You actually suck.  Maybe you should skip the birds and just go " + yourQuest + ".");
    }
}
