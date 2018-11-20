package com.tsguild.foundations.flowcontrol.ifs;

import java.util.Scanner;

/**
 *
 * @author souldj673
 */
public class BirthStones {

    public static void main(String[] args) {
        //Scanner & Variable Declare/Init
        Scanner userInput = new Scanner(System.in);
        int month;
        String birthstone;
        String monthName;

        //Month Prompt
        System.out.print("Which month's birthstone are you wanting to know? ");
        month = userInput.nextInt();

        //Finding info
        birthstone = birthStone(month);
        monthName = monthName(month);

        //monthName error - invalid number
        if (monthName.equals("null")) {
            System.out.println("You must be confused, " + month + " doesn't correspond to a month.");
            return;
        }

        //Printing info
        System.out.println(monthName + "'s birthstone is " + birthstone + ".");

    }

    //Determines Birthstone
    public static String birthStone(int month) {
        if (month == 1) {
            return "Garnet";
        } else if (month == 2) {
            return "Amethyst";
        } else if (month == 3) {
            return "Aquamarine";
        } else if (month == 4) {
            return "Diamond";
        } else if (month == 5) {
            return "Emerald";
        } else if (month == 6) {
            return "Pearl";
        } else if (month == 7) {
            return "Ruby";
        } else if (month == 8) {
            return "Peridot";
        } else if (month == 9) {
            return "Sapphire";
        } else if (month == 10) {
            return "Opal";
        } else if (month == 11) {
            return "Topaz";
        } else if (month == 12) {
            return "Turquoise";
        } else {
            return ("null");
        }
    }

    //Converts month number to name
    public static String monthName(int month) {
        if (month == 1) {
            return "January";
        } else if (month == 2) {
            return "February";
        } else if (month == 3) {
            return "March";
        } else if (month == 4) {
            return "April";
        } else if (month == 5) {
            return "May";
        } else if (month == 6) {
            return "June";
        } else if (month == 7) {
            return "July";
        } else if (month == 8) {
            return "August";
        } else if (month == 9) {
            return "September";
        } else if (month == 10) {
            return "October";
        } else if (month == 11) {
            return "November";
        } else if (month == 12) {
            return "December";
        } else {
            return ("null");
        }
    }
}
