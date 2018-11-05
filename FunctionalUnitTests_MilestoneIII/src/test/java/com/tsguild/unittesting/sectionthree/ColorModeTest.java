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

import static com.tsguild.unittesting.sectionthree.WorkWithArrays.mostCommonColor;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author souldj673
 */
public class ColorModeTest {

    public ColorModeTest() {
    }

    @Before
    public void setUp() {
    }

    @Test
    public void twoColors() {

        String[] testArray = {"Red", "Blue", "Red", "Blue", "Red", "Blue", "Red"};
        String modeColor = mostCommonColor(testArray);

        Assert.assertEquals("Should return Red", "Red", modeColor);
    }

    @Test
    public void multiModeSet() {
        String[] testArray = {"Violet", "Indigo", "Blue", "Green", "Yellow",
            "Orange", "Red"};
        String modeColor = mostCommonColor(testArray);

        Assert.assertEquals("Should return Violet", "Violet", modeColor);
    }

    @Test
    public void allButOne() {
        String[] testArray = {"Green", "Green", "Green", "Green", "Green",
            "Red", "Green"};
        String modeColor = mostCommonColor(testArray);
        
        Assert.assertEquals("Should return Green", "Green", modeColor);
    }

}
