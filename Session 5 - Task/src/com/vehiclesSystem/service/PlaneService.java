package com.vehiclesSystem.service;

import com.vehiclesSystem.dao.PlaneDao;
import com.vehiclesSystem.model.Car;
import com.vehiclesSystem.model.Plane;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PlaneService {

    private PlaneDao planeDao;

    @Autowired
    public PlaneService(PlaneDao planeDao) {
        this.planeDao = planeDao;
    }

    public void savePlane(Plane plane) {

        if(plane == null){
            throw new NullPointerException("plane is null");
        }

        if (plane.getId().isEmpty()) {
            throw new IllegalArgumentException("plane id is empty");
        }
        
        if (plane.getBrand().isEmpty()) {
            throw new IllegalArgumentException("plane brand is empty");
        }
        
        if (plane.getType() == null) {
            throw new NullPointerException("plane type is null");
        }

        planeDao.save(plane);
    }

    public Plane getPlaneById(String id) {

        if (id == null) {
            throw new NullPointerException("id is null");
        }

        if (id.isEmpty()) {
            throw new IllegalArgumentException("id is empty");
        }

        return (Plane) planeDao.findVehicleById(id);
    }

}
