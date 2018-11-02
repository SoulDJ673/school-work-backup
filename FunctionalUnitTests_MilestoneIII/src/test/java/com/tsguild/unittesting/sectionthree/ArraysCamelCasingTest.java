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

import static com.tsguild.unittesting.sectionthree.WorkWithArrays.camelCaseIt;
import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author souldj673
 */
public class ArraysCamelCasingTest {

    public ArraysCamelCasingTest() {
    }

    @Before
    public void setUp() {
    }

    @Test
    public void llamaDuck() {
        String[] testArray = {"llama", "llama", "duck"};

        String result = camelCaseIt(testArray);

        Assert.assertEquals("Should be llamaLlamaDuck", "llamaLlamaDuck", result);
    }

    @Test
    public void oats() {
        String[] testArray = {"lambs", "eat", "oats", "and", "does", "eat", "oats"};

        String result = camelCaseIt(testArray);

        Assert.assertEquals("Should be lambsEatOatsAndDoesEatOats", "lambsEatOatsAndDoesEatOats", result);
    }

    @Test
    public void yoda() {
        String[] testArray = {"DO", "OR", "DO", "NOT", "THERE", "IS", "NO", "TRY"};

        String result = camelCaseIt(testArray);

        Assert.assertEquals("Should be doOrDoNotThereIsNoTry", "doOrDoNotThereIsNoTry", result);
    }

}
