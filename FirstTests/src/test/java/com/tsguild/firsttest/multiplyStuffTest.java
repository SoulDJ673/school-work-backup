/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tsguild.firsttest;

import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author souldj673
 */
public class multiplyStuffTest {

    public multiplyStuffTest() {
    }

    @Before
    public void setUp() {
    }

    @Test
    public void multiplyPositiveSmall() {
        int inputA = 3;
        int inputB = 5;

        int product = SomeMethods.multiplyStuff(inputA, inputB);

        Assert.assertEquals("The product of 3 and 5 should be 15", 15, product);
    }

    @Test
    public void multiplyNegativeSmall() {
        int inputA = -4;
        int inputB = -7;

        int product = SomeMethods.multiplyStuff(inputA, inputB);

        Assert.assertEquals("The product of -4 and -7 should be 28", 28, product);
    }

    @Test
    public void multiplyBig() {
int inputA = 300;
int inputB = -600;

int product = SomeMethods.multiplyStuff(inputA, inputB);

Assert.assertEquals("The product of 300 and -600 should be -180000", -180000, product);
    }

}
