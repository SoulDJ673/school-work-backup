package com.tsguild.milestone3basics.bigdecimalwork;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 *
 * @author souldj673
 */
public class PracticingWithBigDecimal {

    public static void main(String[] args) {
        //Primitive Math
        System.out.println("Let's practice some math in Java!\n");
        System.out.println("\n=== With Primitives ===");
        System.out.println("1 + 3 = " + (1 + 3));
        System.out.println("5 x 5 = " + (5 * 5));
        System.out.println("33.3 - 42.42 = " + (33.3 - 42.42));
        System.out.println("15 / 2.5 = " + (15 / 2.5));
        System.out.println("2((3 + 4) / 7) = " + (2 * ((3 + 4) / 7)));

        //BigDecimal math
        System.out.println("\n=== With BigDecimal ===");
        addition();
        multiplication();
        subtraction();
        division();
        multioperation();

    }

    /**
     * All methods here are for the BigDecimal operations
     */
    //Addition 1 + 3
    private static void addition() {
        BigDecimal add1 = new BigDecimal(1); //Both addends must be BigDecimals
        BigDecimal add3 = new BigDecimal(3);
        BigDecimal sum = add1.add(add3); //The .add method returns a BigDecimal, create yet another BigDecimal
        System.out.println(add1.toString() + " + " + add3.toString() + " = "
                + sum.toString());
    }

    //Multiplication 5x5
    private static void multiplication() {
        BigDecimal factor1 = new BigDecimal(5);
        BigDecimal factor2 = new BigDecimal(5);
        BigDecimal product = factor1.multiply(factor2);
        System.out.println(factor1.toString() + " x " + factor2.toString()
                + " = " + product.toString());
    }

    //Subtraction 33.3 - 42.42
    private static void subtraction() {
        /**
         * .setScale is used to let BigDecimal know which decimal to stop at.
         * This way, we don't end up with crazy long or irrational numbers that
         * break our program.
         */
        BigDecimal sub1 = new BigDecimal(33.3);
        BigDecimal sub1b = sub1.setScale(2, RoundingMode.HALF_UP);

        BigDecimal sub2 = new BigDecimal(42.42);
        BigDecimal sub2b = sub2.setScale(2, RoundingMode.HALF_UP);

        BigDecimal difference = sub1b.subtract(sub2b);

        System.out.println(sub1b.toString() + " - " + sub2b.toString() + " = "
                + difference.toString());
    }

    //Division 15 / 2.5
    private static void division() {
        BigDecimal dividend = new BigDecimal(15);
        BigDecimal divisor = new BigDecimal(2.5);
        BigDecimal quotient = dividend.divide(divisor, 2, RoundingMode.HALF_UP);

        System.out.println(dividend.toString() + " / " + divisor.toString()
                + " = " + quotient.toString());
    }

    //Multioperational 2((3 + 4) / 7)
    private static void multioperation() {
        BigDecimal coefficient = new BigDecimal(2);
        BigDecimal addend1 = new BigDecimal(3);
        BigDecimal addend2 = new BigDecimal(4);
        BigDecimal divisor = new BigDecimal(7);
        BigDecimal answer = coefficient.multiply(divisor.divide(addend1.add(addend2), 2, RoundingMode.HALF_UP));
        System.out.println("2((3 + 4) / 7) = " + answer.toString());
    }
}
