package com.thesoftwareguild.milestone1summative;

/**
 *
 * @author souldj673
 */
public class SummativeSums {

    public static void main(String[] args) {
        //Array Declarations and Assignments
        int[] arrayOne = {1, 90, -33, -55, 67, -16, 28, -55, 15};
        int[] arrayTwo = {999, -60, -77, 14, 160, 301};
        int[] arrayThree = {10, 20, 30, 40, 50, 60, 70, 80, 90, 100, 110, 120, 130, 140, 150, 160, 170, 180, 190, 200, -99};

        //Method Calls and Print Results
        System.out.println("#1 Array Sum: " + SummativeSums.summerator(arrayOne));
        System.out.println("#2 Array Sum: " + SummativeSums.summerator(arrayTwo));
        System.out.println("#3 Array Sum: " + SummativeSums.summerator(arrayThree));
    }

    //Array Summation Method
    public static int summerator(int[] array) {
        //Run through Entire Array and Sum Values into Variable
        int arraySum = 0;

        for (int i = 0; i < array.length; i++) {
            arraySum += array[i];
        }

        //Return Sum
        return (arraySum);
    }
}
