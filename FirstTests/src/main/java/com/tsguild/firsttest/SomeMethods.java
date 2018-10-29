package com.tsguild.firsttest;

/**
 *
 * @author ahill
 */
public class SomeMethods {

    public static int addStuff(int a, int b) {
        /*
         * All 3 tests failed, only doubling the first input instead of adding 
         * the first and second
         * 
         * return a + a;
         */

        //All tests pass with this code, the correct sum is returned
        return a + b;
    }

    public static int multiplyStuff(int a, int b) {
        /*
         * All three tests failed due to the accidental squaring of a
         *
         * return a * a * b;
         */

        //Correct product returned, removed a^2
        return a * b;

    }

    public static int returnTheBigger(int a, int b) {
        /*
         * All three tests failed, returned the smaller number of the two 
         * because the < should be >
         *
         * return a < b ? a : b;
         */
        
        return a > b ? a : b;
    }

}
