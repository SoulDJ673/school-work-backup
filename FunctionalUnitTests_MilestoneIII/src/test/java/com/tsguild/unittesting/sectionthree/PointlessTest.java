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

import static com.tsguild.unittesting.sectionthree.WorkWithArrays.pointFree;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author souldj673
 */
public class PointlessTest {

    public PointlessTest() {
    }

    @Before
    public void setUp() {
    }

    /* 
    ** Given an array of doubles, return the biggest number of the lot ... as if the decimal had gone missing!
    **
    ** Ex:
    ** pointFree( [1.1, .22]  ) ->  22
    ** pointFree( [ .039 , 20 , .005005 ]  ) ->  5005
    ** pointFree( [ -9.9 , -700 , -.5  ]  ) ->  -5
     */
    @Test
    public void intifyTest() {
        double[] testArray = {6.9, .69, .00006009, 690.00};

        int result = pointFree(testArray);
        
        assertEquals("Should be 6009", 6009, result);

    }

}
