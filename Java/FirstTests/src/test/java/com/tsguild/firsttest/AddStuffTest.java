/*
 * OwO
 */
package com.tsguild.firsttest;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author souldj673
 */
public class AddStuffTest {

    public AddStuffTest() {
    }

    @Before
    public void setUp() {
    }

    @Test
    public void testAddStuffWith5And10() {
        //Figuring out inputs
        int input1 = 5;
        int input2 = 10;

        //Call method and Capture return
        int result = SomeMethods.addStuff(input1, input2);

        //Assert on return 
        Assert.assertEquals("I added 5 and 10, which should be 15", 15, result);
    }

    @Test
    public void testAddStuffWithNegative() {
        int input1 = -3;
        int input2 = 5;

        int result = SomeMethods.addStuff(input1, input2);

        Assert.assertEquals("The sum of -3 and 5 should be 2", 2, result);
    }

    @Test
    public void testAddStuffOnlyNegatives() {
        int input1 = -10;
        int input2 = -20;

        int result = SomeMethods.addStuff(input1, input2);

        Assert.assertEquals("The sum of -10 and -20 should be -30", -30, result);
    }

}
