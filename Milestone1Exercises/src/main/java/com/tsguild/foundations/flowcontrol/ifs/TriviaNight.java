package com.tsguild.foundations.flowcontrol.ifs;

import java.util.Scanner;

/**
 *
 * @author souldj673
 */
public class TriviaNight {

    public static void main(String[] args) {
        //Scanner and Variable Declare/Init
        Scanner userChoice = new Scanner(System.in);
        int correct = 0;
        int answer;

        System.out.println("Trivia Game...");
        System.out.println("");
        System.out.println("");

        System.out.println("Question 1:");
        System.out.println("What is the Lowest Level Programming Language?");
        System.out.println("1) Source Code                  2) Assembly");
        System.out.println("3) C#                           4) Machine Code");
        System.out.println("");
        System.out.print("Your Answer: ");
        answer = userChoice.nextInt();
        if (answer == 4) {
            correct++;
        } else {
        }

        System.out.println("");
        System.out.println("");

        System.out.println("Question 2:");
        System.out.println("Which of These Sci-Fi Ships Was Once Slated for a Full-Size Replica in Las Vegas?");
        System.out.println("1) Serenity                  2) The Battlestar Galactica");
        System.out.println("3) The USS Enterprise        4) The Millennium Falcon");
        System.out.println("");
        System.out.print("Your Answer: ");
        answer = userChoice.nextInt();
        if (answer == 3) {
            correct++;
        } else {
        }

        System.out.println("");
        System.out.println("");

        System.out.println("Question 3:");
        System.out.println("Website Security CAPTCHA Forms Are Descended From the Work of?");
        System.out.println("1) Grace Hopper                  2) Alan Turing");
        System.out.println("3) Charles Babbage               4) Larry Page");
        System.out.println("");
        System.out.print("Your Answer: ");
        answer = userChoice.nextInt();
        if (answer == 2) {
            correct++;
        } else {
        }

        System.out.println("");
        System.out.println("");

        System.out.println("Question 4:");
        System.out.println("How creative was it of me to steal these questions from the example?");
        System.out.println("1) Not at all                  2) Very");
        System.out.println("");
        System.out.print("Your Answer: ");
        answer = userChoice.nextInt();
        if (answer == 1) {
            correct++;
        } else {
        }
        
        System.out.println("");
        System.out.println("");
        
        System.out.println("You got " + correct + " correct.");
    }

}
