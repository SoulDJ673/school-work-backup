package com.tsguild.milestone2.codealong.methods;

/**
 *
 * @author souldj673
 */
public class StaticMethods {

    public static String colorThingOne(String color) {
        if (color.equalsIgnoreCase("red")) {
            return "Blue";
        } else {
            return "Green";
        }
    }

    public static String colorThingTwo(String color) {
        String aColor;
        if (color.equalsIgnoreCase("red")) {
            aColor = "Blue";
        } else {
            aColor = "Green";
        }
        return aColor;
    }

    //Did it myself
    /*public static int highestNum(int first, int second, int third) {
        if (first > second && first > third) {
            return first;
        }
        if (second > first && second > third) {
            return second;
        } else {
            return third;
        }
    }*/
    //Class Ex
    public static int highestNum(int first, int second) {
        if (first > second) {
            return first;
        } else {
            return second;
        }
    }

    public static int highestNum(int first, int second, int third) {
        //Compare first two values using 2 param method
        int result = StaticMethods.highestNum(first, second);

        //Compare Largest of last step with final number
        result = StaticMethods.highestNum(result, third);

        //Return Result of Last Step
        return result;
    }
}
