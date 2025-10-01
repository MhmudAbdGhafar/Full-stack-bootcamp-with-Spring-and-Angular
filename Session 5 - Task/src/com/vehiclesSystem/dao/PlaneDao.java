package com.vehiclesSystem.dao;

import com.vehiclesSystem.config.DatabaseOperation;
import com.vehiclesSystem.model.Vehicle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;

@Component
public class PlaneDao implements VehicleDao {

    private DatabaseOperation databaseOperation;

    @Autowired
    public  void setDatabaseOperation(DatabaseOperation databaseOperation) {
        this.databaseOperation = databaseOperation;
    }

    @Override
    public void save(Vehicle vehicle) {

        databaseOperation.saveVehicle(vehicle);

    }

    @Override
    public void update(Vehicle vehicle) {

    }

    @Override
    public void delete(Vehicle vehicle) {

    }

    @Override
    public List<Vehicle> findAll() {
        return Collections.emptyList();
    }

    @Override
    public Vehicle findVehicleById(String id) {

        return databaseOperation.getVehicleById(id);

    }

}
