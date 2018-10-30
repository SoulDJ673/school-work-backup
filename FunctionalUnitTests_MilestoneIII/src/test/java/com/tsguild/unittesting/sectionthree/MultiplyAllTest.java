/*
 * Copyright (C) 2018 souldj673
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package com.tsguild.unittesting.sectionthree;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author souldj673
 */
public class MultiplyAllTest {

    public MultiplyAllTest() {
    }

    @Before
    public void setUp() {
    }

    /* 
    ** Given a integer and an array of ints, times each number in the array by the multiplier.
    **
    ** Ex:
    ** multiplyAll( 5 , [ 1 , 2 , 3 , 4 , 5 ] ) ->  [ 5 , 10 , 15 , 20 , 25 ]
    ** multiplyAll( 0 , [ 1 , 1 , 1 , 1 , 1  , 1 , 1 , 1 , 1 ] ) ->  [ 0 , 0 , 0 , 0 , 0 , 0 , 0 , 0 , 0 ]
    ** multiplyAll( -1 , [ -2 , 0 , 0 , 1 ] ) ->  [ 2 , 0 , 0 , -1 ]
     */
    @Test
    public void fiveMultiplier() {
        int[] numbers = {1, 2, 3, 4, 5};
        int[] correctAnswer = {5, 10, 15, 20, 25};
        int[] multipliedNumbers = WorkWithArrays.multiplyAll(5, numbers);

        Assert.assertArrayEquals("This should work", correctAnswer, multipliedNumbers);
    }

    @Test
    public void zeroMultiplier() {
        int[] numbers = {1, 1, 1, 1, 1, 1, 1, 1, 1};
        int[] correctAnswer = {0, 0, 0, 0, 0, 0, 0, 0, 0};
        int[] multipliedNumbers = WorkWithArrays.multiplyAll(0, numbers);

        Assert.assertArrayEquals(correctAnswer, multipliedNumbers);
    }

    @Test
    public void negativeMultiplier() {
        int[] numbers = {-2, 0, 0, 1};
        int[] answerKey = {2, 0, 0, -1};
        int[] multipliedNums = WorkWithArrays.multiplyAll(-1, numbers);

        Assert.assertArrayEquals(answerKey, multipliedNums);
    }

}
