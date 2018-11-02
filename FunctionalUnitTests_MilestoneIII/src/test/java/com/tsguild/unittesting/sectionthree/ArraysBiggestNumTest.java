/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tsguild.unittesting.sectionthree;

import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author souldj673
 */
public class ArraysBiggestNumTest {

    public ArraysBiggestNumTest() {
    }

    @Before
    public void setUp() {
    }

    @Test
    public void oneArray() {

        int[] testArray = {1};

        int biggestNum = WorkWithArrays.maxOfArray(testArray);

        Assert.assertEquals("This should be 1", 1, biggestNum);
    }

    @Test
    public void threeArray() {

        int[] testArray = {3, 4, 5};

        int biggestNum = WorkWithArrays.maxOfArray(testArray);

        Assert.assertEquals("This should be 5", 5, biggestNum);
    }

    @Test
    public void negativeArray() {

        int[] testArray = {-9000, -700, -50, -3};

        int biggestNum = WorkWithArrays.maxOfArray(testArray);

        Assert.assertEquals("This should be -3", -3, biggestNum);
    }

}
