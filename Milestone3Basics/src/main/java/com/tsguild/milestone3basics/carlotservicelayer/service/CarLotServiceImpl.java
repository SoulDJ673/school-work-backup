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
package com.tsguild.milestone3basics.carlotservicelayer.service;

import com.tsguild.milestone3basics.carlotservicelayer.dao.*;
import com.tsguild.milestone3basics.carlotservicelayer.dto.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author souldj673
 */
public class CarLotServiceImpl implements CarLotService {

    CarLotDAO dao = new CarLotDAO();

    @Override
    public Car getACar(String VIN) {
        return dao.getCar(VIN);
    }

    @Override
    public List<Car> getAllCars() {
        return dao.getCars();
    }

    @Override
    public List<Car> getCarsByColor(String color) {

        List<Car> allCars = dao.getCars();
        List<Car> colorCars = new ArrayList<>();

        for (Car currentCar : allCars) {
            if (currentCar.getColor().equalsIgnoreCase(color)) {
                colorCars.add(currentCar);
            }
        }

        return colorCars;
    }

    @Override
    public List<Car> getCarsByPrice(BigDecimal maxPrice) {
        List<Car> allCars = dao.getCars();
        List<Car> affordableCars = new ArrayList<>();

        for (Car currentCar : allCars) {
            if (currentCar.getPrice().compareTo(maxPrice) <= 0) {
                affordableCars.add(currentCar);
            }
        }

        return affordableCars;
    }

    @Override
    public BigDecimal discountCar(String VIN, BigDecimal discount) throws NoSuchCarException {
        Car car = dao.getCar(VIN);

        BigDecimal originalPrice = car.getPrice();
        BigDecimal discountedPrice = originalPrice.subtract(discount);

        return discountedPrice;

    }

    @Override
    public CarKey sellCar(String VIN, BigDecimal cashPaid) throws NoSuchCarException, OverpaidPriceException, UnderpaidPriceException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void validateInput(String input) {

    }

}
