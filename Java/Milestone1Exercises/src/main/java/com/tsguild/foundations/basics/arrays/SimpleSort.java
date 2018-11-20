package com.tsguild.foundations.basics.arrays;

/**
 *
 * @author souldj673
 */
public class SimpleSort {

    public static void main(String[] args) {
        int[] firstHalf = {3, 7, 9, 10, 16, 19, 20, 34, 55, 67, 88, 99};
        int[] secondHalf = {1, 4, 8, 11, 15, 18, 21, 44, 54, 79, 89, 100};

        int[] wholeNumbers = new int[24];
        int tmp;

        //Combining
        //FirstHalf - Every other space
        for (int i = 0; i < firstHalf.length; i++) {
            if (i == 0) {
                wholeNumbers[0] = firstHalf[i];
            }
            wholeNumbers[i * 2] = firstHalf[i];
        }
        //SecondHalf - Fill in the blanks
        for (int i = 0; i < secondHalf.length; i++) {
            if (i == 0) {
                wholeNumbers[1] = secondHalf[i];
            }
            wholeNumbers[(i * 2) + 1] = secondHalf[i];
        }
        //Sorting wholeNumbers
        for (int i = 0; i < wholeNumbers.length; i++) {
            if (i == 0) {
                System.out.print("Sorting");
            } else {
                if (wholeNumbers[i] < wholeNumbers[i - 1]) {
                    tmp = wholeNumbers[i - 1];
                    wholeNumbers[i - 1] = wholeNumbers[i];
                    wholeNumbers[i] = tmp;
                    System.out.print(".");
                } else {
                    System.out.print(".");
                }
            }
        }
        System.out.println("");
        System.out.println("Done!");
        System.out.println("Sorted Array: ");
        for (int i = 0; i < wholeNumbers.length; i++) {
            System.out.print(wholeNumbers[i] + " ");
        }
    }
}
