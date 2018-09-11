package com.tsguild.milestone2.lab.simplecalculator;

/**
 *
 * @author souldj673
 */
public class SimpleCalculator {

    public long addition(long userNum1, long userNum2) {
        //Returns the sum of the two provided numbers
        return userNum1 + userNum2;
    }

    public long subtraction(long num1, long num2) {
        //Returns difference between the two provided numbers
        return num1 - num2;
    }

    public long multiplication(long num1, long num2) {
        //Returns product of the two given numbers
        return num1 * num2;
    }

    public double division(long num1, long num2) {
        //Returns dividend of the two given numbers
        return num1 / num2;
    }

    public long exponents(long num1, long num2) {
        //Product Variable
        long product = 1;

        //Multiplies num1 by itself for num2 times via a for loop
        for (int i = 0; i < num2; i++) {
            product = product * num1;
        }

        return product;
    }
}
