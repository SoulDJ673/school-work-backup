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

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author souldj673
 */
public class VendingDAOImplTest {

    public VendingDAOImplTest() {
    }

    @Before
    public void setUp() {
    }

    //Throwing the exception when unable to load the file
    @Test
    public void loadAllItemsExceptionThrowingInvalidFileTest() {
        VendingDAO fakeDao = new VendingDAOImpl("inventroy.tt");
        try {
            fakeDao.loadAllItems();
            Assert.fail("The exception wasn't thrown like it was supposed to.");
        } catch (VendingPersistenceException ex) {
            Assert.assertEquals("An exception was thrown because the file doesn't exist", true, true);
        }
    }

    @Test
    public void loadAllItemsExceptionThrowingValidFileTest() {
        VendingDAO fakeDao = new VendingDAOImpl("inventory.txt");
        try {
            fakeDao.loadAllItems();
            Assert.assertEquals("The exception wasn't thrown :)", true, true);
        } catch (VendingPersistenceException ex) {
            Assert.fail("An exception was thrown because the file doesn't exist");
        }
    }

    @Test
    public void loadAllItemsExceptionThrowingNullTest() {
        VendingDAO fakeDao = new VendingDAOImpl(null);
        try {
            fakeDao.loadAllItems();
            Assert.assertEquals("The exception wasn't thrown :0", false, true);
        } catch (VendingPersistenceException ex) {
            Assert.assertEquals("An exception was thrown because the file doesn't exist", true, true);
        }
    }

    @Test
    public void loadAllItemsExceptionThrowingBlankTest() {
        VendingDAO fakeDao = new VendingDAOImpl(" ");
        try {
            fakeDao.loadAllItems();
            Assert.assertEquals("The exception wasn't thrown :0", false, true);
        } catch (VendingPersistenceException ex) {
            Assert.assertEquals("An exception was thrown because the file doesn't exist", true, true);
        }
    }

}
