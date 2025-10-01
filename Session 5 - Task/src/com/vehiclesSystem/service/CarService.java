package com.vehiclesSystem.service;

import com.vehiclesSystem.dao.CarDao;
import com.vehiclesSystem.model.Car;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@NoArgsConstructor
public class CarService {

    private CarDao carDao;

    @Autowired
    public CarService(CarDao carDao) {
        this.carDao = carDao;
    }

    public void saveCar(Car car) {

        if(car == null){
            throw new NullPointerException("car is null");
        }

        if (car.getId().isEmpty()) {
            throw new IllegalArgumentException("car id is empty");
        }

        if (car.getBrand().isEmpty()) {
            throw new IllegalArgumentException("car brand is empty");
        }

        if (car.getType() == null) {
            throw new NullPointerException("car type is null");
        }

        carDao.save(car);
    }

    public Car getCarById(String id) {
        if (id == null) {
            throw new NullPointerException("id is null");
        }

        if (id.isEmpty()) {
            throw new IllegalArgumentException("id is empty");
        }

        return (Car) carDao.findVehicleById(id);
    }

}