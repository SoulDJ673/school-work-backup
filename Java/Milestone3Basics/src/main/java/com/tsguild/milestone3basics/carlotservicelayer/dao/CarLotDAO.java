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
package com.tsguild.milestone3basics.carlotservicelayer.dao;

import com.tsguild.milestone3basics.carlotservicelayer.dto.*;
import java.util.List;

/**
 *
 * @author souldj673
 */
public interface CarLotDAO {

    public Car addCar(String VIN, Car car);

    public Car getCar(String VIN);

    public List<Car> getCars();

    public void editCar(String VIN, Car car);

    public Car removeCar(String VIN);
}
