package com.tsguild.milestone2.lab.userio;

import java.util.Scanner;

/**
 *
 * @author souldj673
 */
public class UserIOCalcImpl implements UserIO {

    //Class accessible scanner for user input
    private Scanner userInput = new Scanner(System.in);

    //Method Implementations
    @Override
    public void print(String message) {
        System.out.print(message);
    }

    @Override
    public String readString(String msgPrompt) {
        //Declare Var for holding user input (string)
        String userS;

        System.out.print(msgPrompt);
        userS = userInput.next();

        //Return user input back to caller
        return userS;
    }

    @Override
    public int readInt(String msgPrompt) {
        //Declare Var for holding user input (integer)
        int userI;

        System.out.print(msgPrompt);
        userI = userInput.nextInt();

        return userI;
    }

    @Override
    public int readInt(String msgPrompt, int min, int max) {
        //Declare Var for holding user input (integer)
        int userI;

        System.out.print(msgPrompt);

        //Repeat if user gives an integer that is out of bounds
        while (true) {
            userI = userInput.nextInt();
            if (userI <= max && userI >= min) {
                return userI;
            } else {
                System.out.print("You must input a value between " + min + " and " + max);
            }
        }
    }

    @Override
    public double readDouble(String msgPrompt) {
        //Declare Var for holding user input (double)
        double userD;

        System.out.print(msgPrompt);
        userD = userInput.nextDouble();

        return userD;
    }

    @Override
    public double readDouble(String msgPrompt, double min, double max) {
        //Declare Var for holding user input (double)
        double userD;

        System.out.print(msgPrompt);

        //Repeat if user gives value that is out of bounds
        while (true) {
            userD = userInput.nextDouble();
            if (userD >= min && userD <= max) {
                return userD;
            } else {
                System.out.print("You must input a value between " + min + " and " + max);
            }
        }
    }

    @Override
    public float readFloat(String msgPrompt) {
        //Declare Var for holding user input (float)
        float userF;

        System.out.print(msgPrompt);
        userF = userInput.nextFloat();

        return userF;
    }

    @Override
    public float readFloat(String msgPrompt, float min, float max) {
        //Declare Var for holding user input (float)
        float userF;

        System.out.print(msgPrompt);

        //Repeat if user gives value that is out of bounds
        while (true) {
            userF = userInput.nextFloat();
            if (userF >= min && userF <= max) {
                return userF;
            } else {
                System.out.print("You must input a value between " + min + " and " + max);
            }
        }
    }

    @Override
    public long readLong(String msgPrompt) {
        //Declare Var for holding user input (float)
        long userL;

        System.out.print(msgPrompt);
        userL = userInput.nextLong();

        return userL;
    }

    @Override
    public long readLong(String msgPrompt, long min, long max) {
        //Declare Var for holding user input (long)
        long userL;

        System.out.print(msgPrompt);

        //Repeat if user gives value that is out of bounds
        while (true) {
            userL = userInput.nextLong();
            if (userL >= min && userL <= max) {
                return userL;
            } else {
                System.out.print("You must input a value between " + min + " and " + max);
            }
        }
    }
}
