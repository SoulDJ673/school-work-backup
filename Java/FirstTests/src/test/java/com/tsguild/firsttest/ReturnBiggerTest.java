/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tsguild.firsttest;

import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author souldj673
 */
public class ReturnBiggerTest {

    public ReturnBiggerTest() {
    }

    @Before
    public void setUp() {
    }

    @Test
    public void smallNumTest() {
        int inputA = 7;
        int inputB = 3;

        int bigger = SomeMethods.returnTheBigger(inputA, inputB);

        Assert.assertEquals("The larger number of 7 and 3 should be 7", 7, bigger);
    }

    @Test
    public void bigNumTest() {
        int inputA = 2374;
        int inputB = 2139084;

        int bigger = SomeMethods.returnTheBigger(inputA, inputB);

        Assert.assertEquals("The larger number of 2374 and 2139084 should be 2139084", 2139084, bigger);
    }

    @Test
    public void negativeNumTest() {
        int inputA = 231;
        int inputB = -42;

        int bigger = SomeMethods.returnTheBigger(inputA, inputB);

        Assert.assertEquals("The larger number of 231 and -42 should be 231", 231, bigger);
    }

}
