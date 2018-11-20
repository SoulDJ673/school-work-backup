package com.tsguild.milestone1.classcodealongsaugust;

/**
 *
 * @author souldj673
 */
public class PracticeWithArrays {

    public static void main(String[] args) {

        //String Array Declaration
        String[] llamaHerd;
        //Array Length Declaration
        llamaHerd = new String[8];
        //Llama insertion
        llamaHerd[0] = "Beebop"; //Beebop is the FIRST llama, Alpha Llama
        llamaHerd[1] = "Floyd";
        llamaHerd[2] = "Prism";
        llamaHerd[3] = "Oreo";
        llamaHerd[4] = "Dixie";
        llamaHerd[5] = "Secret";
        llamaHerd[6] = "Penny";
        llamaHerd[7] = "Angelina";
        //llamaHerd[8] = "Boo"; //Extra One
        System.out.println("I have " + llamaHerd.length + " llamas in my herd! :)");

        //Printing Array Contents
        for (int index = 0; index < llamaHerd.length; index++) {
            System.out.println("My llama in stall " + index + " is named: " + llamaHerd[index]);
        }

        //Every other Llama
        System.out.println("LET'S PRINT OUT EVERY *OTHER* LLAMA!");
        for (int index = 0; index < llamaHerd.length; index = index + 2) {
            System.out.println("Llama in stall " + index + " is named: " + llamaHerd[index]);
        }

        //Now for some Numbers!!! - Writing to array with preknown values after declaration
        double[] someNums = {1.0, 42.6, 45.99, 33.2};
        System.out.println("The last number is: " + someNums[3]);

        //Combining Array Values - By Hand
        double result = someNums[0] + someNums[1] + someNums[2] + someNums[3];
        System.out.println("The total of the double array values are: " + result);

        //Combining Array Values - Magically
        int[] moarNums = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17};
        int sumResult = 0;
        for (int i = 0; i < moarNums.length; i++) {
            System.out.print(moarNums[i] + " ");
            sumResult = sumResult + moarNums[i];
        }
        System.out.println("The sum of the moarNums array is: " + sumResult);
        System.out.println("The average of the moarNums array is " + (sumResult / moarNums.length));
        
    }

}
