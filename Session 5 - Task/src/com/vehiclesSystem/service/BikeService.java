package com.vehiclesSystem.service;

import com.vehiclesSystem.dao.BikeDao;
import com.vehiclesSystem.model.Bike;
import com.vehiclesSystem.model.Plane;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@NoArgsConstructor
public class BikeService {

    private BikeDao bikeDao;

    @Autowired
    public BikeService(BikeDao bikeDao) {
        this.bikeDao = bikeDao;
    }

    public void saveBike(Bike bike) {

        if(bike == null){
            throw new NullPointerException("bike is null");
        }

        if (bike.getId().isEmpty()) {
            throw new IllegalArgumentException("bike id is empty");
        }

        if (bike.getBrand().isEmpty()) {
            throw new IllegalArgumentException("bike brand is empty");
        }

        if (bike.getType() == null) {
            throw new NullPointerException("bike type is null");
        }

        bikeDao.save(bike);
    }

    public Bike getBikeById(String id) {

        if (id == null) {
            throw new NullPointerException("id is null");
        }

        if (id.isEmpty()) {
            throw new IllegalArgumentException("id is empty");
        }

        return (Bike) bikeDao.findVehicleById(id);
    }

}
