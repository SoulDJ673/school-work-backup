package com.tsguild.milestone3basics.carlotservicelayer.service;

import com.tsguild.milestone3basics.carlotservicelayer.dto.*;
import java.math.BigDecimal;
import java.util.List;

public interface CarLotService {

    public Car getACar(String VIN);

    public List<Car> getAllCars();

    public List<Car> getCarsByColor(String color);

    public List<Car> getCarsByPrice(BigDecimal maxPrice);

    public BigDecimal discountCar(String VIN, BigDecimal discount)
            throws NoSuchCarException;

    public CarKey sellCar(String VIN, BigDecimal cashPaid)
            throws NoSuchCarException,
            OverpaidPriceException,
            UnderpaidPriceException;
}
