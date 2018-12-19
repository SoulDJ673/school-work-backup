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
package com.tsguild.vendingmachine.dao;

import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author souldj673
 */
public class VendingPersistenceExceptionTest {

    public VendingPersistenceExceptionTest() {
    }

    @Before
    public void setUp() {
    }

    @Test
    public void callingTheExceptionNoConstructorExercise() {
        try {
            VendingPersistenceException uh = new VendingPersistenceException();
            Assert.assertEquals(true, true);
        } catch (Exception e) {
            Assert.fail("We should probably add a constructor so this will work");
        }
    }

    @Test
    public void callingTheExceptionMessageConstructorExercise() {
        try {
            VendingPersistenceException uh = new VendingPersistenceException("Hewwo");
            Assert.assertEquals(true, true);
        } catch (Exception e) {
            Assert.fail("We should probably add a constructor so this will work");
        }
    }

    @Test
    public void callingTheExceptionNullConstructorExercise() {
        try {
            VendingPersistenceException uh = new VendingPersistenceException(null);
            Assert.assertEquals("Good, we still want this to work even with a null", true, true);
        } catch (Exception e) {
            Assert.fail("We should make this work instead of breaking");
        }
    }

}
