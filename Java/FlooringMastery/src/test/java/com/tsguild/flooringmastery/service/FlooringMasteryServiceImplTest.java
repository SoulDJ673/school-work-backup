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
package com.tsguild.flooringmastery.service;

import com.tsguild.flooringmastery.dao.FlooringMasteryModeDao;
import com.tsguild.flooringmastery.dao.FlooringMasteryModeDaoImpl;
import com.tsguild.flooringmastery.dao.FlooringMasteryOrderDao;
import com.tsguild.flooringmastery.dao.FlooringMasteryOrderDaoImpl;
import com.tsguild.flooringmastery.dao.FlooringMasteryTaxesProductDao;
import com.tsguild.flooringmastery.dao.FlooringMasteryTaxesProductDaoImpl;
import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author souldj673
 */
public class FlooringMasteryServiceImplTest {

    FlooringMasteryService service;

    public FlooringMasteryServiceImplTest() {
    }

    @Before
    public void setUp() {
        FlooringMasteryOrderDao dao = new FlooringMasteryOrderDaoImpl("Orders/");
        FlooringMasteryTaxesProductDao taxProd = new FlooringMasteryTaxesProductDaoImpl("Data/Taxes.txt", "Data/Products.txt");
        FlooringMasteryModeDao mode = new FlooringMasteryModeDaoImpl();
        service = new FlooringMasteryServiceImpl(dao, taxProd, mode);
    }

    @Test
    public void latestIdTest() {
        
        int id = service.getLastID();
        Assert.assertEquals(4, id);
    }

}
