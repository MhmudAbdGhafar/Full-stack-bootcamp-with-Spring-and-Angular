package com.vehiclesSystem.service;

import com.vehiclesSystem.dao.VehicleDao;
import com.vehiclesSystem.model.Vehicle;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@NoArgsConstructor
public class VehicleService {

    private VehicleDao VehicleDao;

    @Autowired
    public VehicleService(VehicleDao VehicleDao) {
        this.VehicleDao = VehicleDao;
    }

    public void saveVehicle(Vehicle Vehicle) {

        if(Vehicle == null){
            throw new NullPointerException("Vehicle is null");
        }

        if (Vehicle.getId().isEmpty()) {
            throw new IllegalArgumentException("Vehicle id is empty");
        }

        if (Vehicle.getBrand().isEmpty()) {
            throw new IllegalArgumentException("Vehicle brand is empty");
        }

        if (Vehicle.getType() == null) {
            throw new NullPointerException("Vehicle type is null");
        }

        VehicleDao.save(Vehicle);
    }

    public Vehicle getVehicleById(String id) {

        if (id == null) {
            throw new NullPointerException("id is null");
        }

        if (id.isEmpty()) {
            throw new IllegalArgumentException("id is empty");
        }

        return (Vehicle) VehicleDao.findVehicleById(id);
    }

    public List<Vehicle> getAllVehicles() {

        return (List<Vehicle>) VehicleDao.findAllVehicles();

    }

    public void updateVehicle(Vehicle Vehicle) {

        if(Vehicle == null){
            throw new NullPointerException("Vehicle is null");
        }

        if (Vehicle.getId().isEmpty()) {
            throw new IllegalArgumentException("Vehicle id is empty");
        }

        if (Vehicle.getBrand().isEmpty()) {
            throw new IllegalArgumentException("Vehicle brand is empty");
        }

        if (Vehicle.getType() == null) {
            throw new NullPointerException("Vehicle type is null");
        }

        VehicleDao.update(Vehicle);
    }

    public void deleteVehicle(String deleteId) {

        if (deleteId == null) {
            throw new IllegalArgumentException("deleteId is null");
        }

        if (deleteId.isEmpty()) {
            throw new IllegalArgumentException("deleteId is empty");
        }

        VehicleDao.delete(deleteId);
    }

}