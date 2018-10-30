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
package com.tsguild.milestone3basics.testing.happyllamas;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author souldj673
 */
public class HappyLlamasTest {

    public HappyLlamasTest() {
    }

    @Before
    public void setUp() {
    }

    @Test
    public void testNormalTrampoline20() {
        Assert.assertFalse(ExampleWork.areTheLlamasHappy(false, 20));
    }

    @Test
    public void testNormalTrampoline30() {
        Assert.assertTrue(ExampleWork.areTheLlamasHappy(false, 30));
    }

}
