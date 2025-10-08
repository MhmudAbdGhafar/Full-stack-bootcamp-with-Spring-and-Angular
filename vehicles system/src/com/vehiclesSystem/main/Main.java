package com.vehiclesSystem.main;

import com.vehiclesSystem.config.AppConfig;
import com.vehiclesSystem.model.*;
import com.vehiclesSystem.service.VehicleService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        VehicleService vehicleService = context.getBean(VehicleService.class);

        vehicleService.saveVehicle(new Car("car1", "BMW", Type.CAR));
        vehicleService.saveVehicle(new Car("plane1", "F16", Type.PLANE));
        vehicleService.saveVehicle(new Car("bike1", "GalaxyBike", Type.BIKE));

        Vehicle vehicle = vehicleService.getVehicleById("bike1");
        System.out.println("✅ User found: " + vehicle.toString());


        vehicle.setBrand("Galaxy50Bike");
        vehicleService.updateVehicle(vehicle);
        vehicleService.deleteVehicle(vehicle.getId());


        List<Vehicle> vehicles = vehicleService.getAllVehicles();

        for (Vehicle v : vehicles) {
            System.out.println(v.toString());
        }


        context.close();

    }

}