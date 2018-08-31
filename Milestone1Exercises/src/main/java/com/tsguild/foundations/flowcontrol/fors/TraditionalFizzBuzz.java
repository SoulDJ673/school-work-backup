package com.tsguild.foundations.flowcontrol.fors;

import java.util.Scanner;

/**
 *
 * @author souldj673
 */
public class TraditionalFizzBuzz {

    //Required accessible fizzbuzz tracker variable
    private static int fizzbuzzes;

    public static void main(String[] args) {
        //Variable and Scanner declare/init
        int userNumber;
        Scanner userInput = new Scanner(System.in);

        //Number Prompt
        System.out.print("How much units fizzing and buzzing do you need in your life? ");
        userNumber = userInput.nextInt();

        //Start Counting
        counter(userNumber);

        //Conclusion
        System.out.println("TRADITION!!!!!");
    }

    //Counter
    public static void counter(int number) {

        //Count up from 0, Repeat until fizzbuzzes reaches desired number
        for (int i = 0; fizzbuzzes < number; i++) {

            //0 Can not be a fizz or a buzz
            //Multiple of 3 and 5 - fizz buzz
            if (i % 3 == 0 && i % 5 == 0 && i != 0) {
                System.out.println("fizz buzz");
                fizzbuzzes++;

            //Multiple of 3 - fizz
            } else if (i % 3 == 0 && i != 0) {
                System.out.println("fizz");
                fizzbuzzes++;

            //Multiple of 5 - buzz
            } else if (i % 5 == 0 && i != 0) {
                System.out.println("buzz");
                fizzbuzzes++;

            //Display all other numbers
            } else {
                System.out.println(i);
            }
        }
    }
}
