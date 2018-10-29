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
        return a * a * b;
    }

    public static int returnTheBigger(int a, int b) {
        return a < b ? a : b;
    }

}
