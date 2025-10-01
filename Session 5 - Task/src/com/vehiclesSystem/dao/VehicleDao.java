package com.vehiclesSystem.dao;

import com.vehiclesSystem.model.Vehicle;

import java.util.List;

public interface VehicleDao {

    void save(Vehicle vehicle);

    void update(Vehicle vehicle);

    void delete(Vehicle vehicle);

    List<Vehicle> findAll();

    Vehicle findVehicleById(String id);
}
