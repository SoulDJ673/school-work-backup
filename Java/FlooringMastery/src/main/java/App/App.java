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
package App;

import com.tsguild.flooringmastery.controller.FlooringMasteryController;
import com.tsguild.flooringmastery.dao.FlooringMasteryOrderDao;
import com.tsguild.flooringmastery.dao.FlooringMasteryOrderDaoImpl;
import com.tsguild.flooringmastery.service.FlooringMasteryService;
import com.tsguild.flooringmastery.service.FlooringMasteryServiceImpl;
import com.tsguild.flooringmastery.view.*;

/**
 * @author souldj673
 *
 * THIS IS TEMPORARY. WILL BE MIGRATING TO SPRING DI LATER
 */
public class App {

    public static final UserIO IO = new UserIOConsoleImpl();
    public static final FlooringMasteryView VIEW = new FlooringMasteryView(IO);
    public static final FlooringMasteryOrderDao DAO = new FlooringMasteryOrderDaoImpl();
    public static final FlooringMasteryService SERVICE = new FlooringMasteryServiceImpl(DAO);
    private static final FlooringMasteryController CONTROLLER = new FlooringMasteryController(VIEW, SERVICE);

    public static void main(String[] args) {
        CONTROLLER.run();
    }

}
