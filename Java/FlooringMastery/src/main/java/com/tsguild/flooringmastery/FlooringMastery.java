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
package com.tsguild.flooringmastery;

import com.tsguild.flooringmastery.controller.FlooringMasteryController;
import com.tsguild.flooringmastery.dao.FlooringMasteryOrderDao;
import com.tsguild.flooringmastery.dao.FlooringMasteryOrderDaoImpl;
import com.tsguild.flooringmastery.dao.FlooringMasteryTaxesProductDao;
import com.tsguild.flooringmastery.dao.FlooringMasteryTaxesProductDaoImpl;
import com.tsguild.flooringmastery.service.FlooringMasteryService;
import com.tsguild.flooringmastery.service.FlooringMasteryServiceImpl;
import com.tsguild.flooringmastery.view.FlooringMasteryView;
import com.tsguild.flooringmastery.view.UserIO;
import com.tsguild.flooringmastery.view.UserIOConsoleImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author souldj673
 */
public class FlooringMastery {

    public static void main(String[] args) {
        ApplicationContext fmContext = new ClassPathXmlApplicationContext("flooring-mastery.xml");

        UserIO IO = fmContext.getBean(UserIOConsoleImpl.class);
        FlooringMasteryView VIEW = fmContext.getBean(FlooringMasteryView.class);
        FlooringMasteryOrderDao DAO = fmContext.getBean(FlooringMasteryOrderDaoImpl.class);
        FlooringMasteryTaxesProductDao TAXPROD = fmContext.getBean(FlooringMasteryTaxesProductDaoImpl.class);
        FlooringMasteryService SERVICE = fmContext.getBean(FlooringMasteryServiceImpl.class);
        FlooringMasteryController CONTROLLER = fmContext.getBean(FlooringMasteryController.class);

        CONTROLLER.run();
    }

}
