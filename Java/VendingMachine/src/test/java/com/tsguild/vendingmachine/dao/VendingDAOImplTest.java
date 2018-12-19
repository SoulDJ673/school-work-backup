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

import com.tsguild.vendingmachine.dto.Item;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author souldj673
 */
public class VendingDAOImplTest {
    
    VendingDAO dao;
    
    public VendingDAOImplTest() {
    }
    
    @Before
    public void setUp() {
        dao = new VendingDAOImpl("inventory.txt");
        try {
            dao.loadAllItems();
        } catch (VendingPersistenceException ex) {
            Logger.getLogger(VendingDAOImplTest.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        VendingDAO fakeDao = new VendingDAOImpl(null); //It's throwing an exception here when it shouldn't be
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
            Assert.assertEquals("The exception wasn't thrown :O", false, true);
        } catch (VendingPersistenceException ex) {
            Assert.assertEquals("An exception was thrown because the file doesn't exist", true, true);
        }
    }

    /**
     * Get Items
     */
    //Get an Item
    @Test
    public void getANonexistantItemTest() {
        Item lol = dao.getAnItem("77");
        //Lol should be null

        Assert.assertEquals("Checking to make sure lol is null", null, lol);
    }
    
    @Test
    public void getANullIDTest() {
        Item stillLol = dao.getAnItem(null);
        //Should be null without throwing an exception

        Assert.assertEquals("Checking to make sure the returned item is null", null, stillLol);
    }
    
    @Test
    public void getABlankIDTest() {
        Item stillLol = dao.getAnItem("  ");
        //Should be null without throwing an exception

        Assert.assertEquals("Checking to make sure the returned item is null", null, stillLol);
    }

    //Get A List of Items
    @Test
    public void getAllItemsNormal() {
        List<Item> theItems = dao.getAllItems();
        
        Assert.assertEquals("This is just making sure that the list isn't empty", false, theItems.isEmpty());
        
        boolean atLeastOneIsNotNull = false;
        for (Item item : theItems) {
            if (item != null) {
                atLeastOneIsNotNull = true;
            }
        }
        Assert.assertEquals("Making sure the items in the list aren't null", true, atLeastOneIsNotNull);
    }
    
    @Test
    public void getAllItemsNull() {
        VendingDAO fakeDao = new VendingDAOImpl("inventroy.tt");
        List<Item> theItems = fakeDao.getAllItems();
        
        Assert.assertEquals("This is just making sure that the list is empty", true, theItems.isEmpty());
        
        boolean atLeastOneIsNotNull = false;
        for (Item item : theItems) {
            if (item != null) {
                atLeastOneIsNotNull = true;
            }
        }
        Assert.assertEquals("Making sure the items in the list are null", false, atLeastOneIsNotNull);
    }

    //Update Items
    @Test
    public void updateItemNormalTest() {
        Item changedItem = new Item("2a");
        Item oldItem = dao.getAnItem("2a");
        dao.updateAnItem("2a", changedItem);
        
        Assert.assertEquals("Making sure the updated item actually is", changedItem, dao.getAnItem("2a"));
        Assert.assertEquals("Making sure the changed item is different from the old one", false, changedItem.equals(oldItem));
    }
    
    @Test
    public void updateItemNullsTest() {
        VendingDAO customDao = new VendingDAOImpl("fake");
        
        Item changedItem = new Item("3b");
        customDao.updateAnItem("2a", changedItem);
        
        Assert.assertEquals("Making sure the updated item actually is", changedItem, customDao.getAnItem("2a"));
    }
}
