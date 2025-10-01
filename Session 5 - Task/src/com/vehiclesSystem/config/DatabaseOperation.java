package com.vehiclesSystem.config;

import com.vehiclesSystem.model.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.*;

@Setter
@Getter
@Component
public class DatabaseOperation {

    @Value("${spring.datasource.url}")
    private String url;

    @Value("${spring.datasource.username}")
    private String username;

    @Value("${spring.datasource.password}")
    private String password;

    public void saveVehicle(Vehicle vehicle) {

        try {

            Connection con = DriverManager.getConnection(url, username, password);

            Statement st = con.createStatement();

            String query = getInsertQuery(vehicle);

            try (PreparedStatement pstmt = con.prepareStatement(query)) {

                pstmt.setString(1, vehicle.getId());
                pstmt.setString(2, vehicle.getBrand());
                pstmt.setString(3, String.valueOf(vehicle.getType()));

                int rowsInserted = pstmt.executeUpdate();
                System.out.println("✅ Rows inserted: " + rowsInserted);
            }

        }catch (Exception e){
            e.printStackTrace();
        }

    }

    public Vehicle getVehicleById(String id) {

        if(search(Type.CAR, id) != null){
            Car car = (Car)search(Type.CAR, id);

            System.out.println("✅ User found: " + car.toString());

            return car;
        }
        else if(search(Type.BIKE, id) != null){
            Bike bike = (Bike)search(Type.BIKE, id);

            System.out.println("✅ User found: " + bike.toString());

            return bike;
        }
        else if (search(Type.PLANE, id) != null){
            Plane plane = (Plane)search(Type.PLANE, id);

            System.out.println("✅ User found: " + plane.toString());

            return plane;
        }

        System.out.println("⚠️ No user found with ID: " + id);

        return null;
    }

    private static String getInsertQuery(Vehicle vehicle) {

        if (vehicle.getType().equals(Type.CAR)) {
            return "INSERT INTO car (id, brand, type) VALUES (?, ?, ?)";
        }

        if (vehicle.getType().equals(Type.PLANE)) {
            return "INSERT INTO plane (id, brand, type) VALUES (?, ?, ?)";
        }

        return "INSERT INTO bike (id, brand, type) VALUES (?, ?, ?)";

    }

    private static String getSearchQuery(Vehicle vehicle) {

        if(vehicle.getType().equals(Type.CAR)) {
            return "SELECT * FROM car WHERE id = ?";
        }

        if(vehicle.getType().equals(Type.PLANE)) {
            return "SELECT * FROM plane WHERE id = ?";
        }

        return "SELECT * FROM bike WHERE id = ?";

    }

    private Vehicle search(Type type, String id) {

        Vehicle vehicle = null;

        try {

            Connection con = DriverManager.getConnection(url, username, password);

            Statement st = con.createStatement();

            String query;

            if (type.equals(Type.CAR)) {
                query = getSearchQuery(new Car());
            }
            else if (type.equals(Type.PLANE)) {
                query = getSearchQuery(new Plane());
            }
            else {
                query = getSearchQuery(new Bike());
            }

            PreparedStatement pstmt = con.prepareStatement(query);
            pstmt.setString(1, id);

            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {

                String vehicleId = rs.getString("id");
                String vehicleBrand = rs.getString("brand");
                String vehicleType = rs.getString("type");

                if (vehicleType.equals(String.valueOf(Type.CAR))) {
                    Car car = new Car();
                    car.setId(vehicleId);
                    car.setBrand(vehicleBrand);

                    vehicle = car;
                }
                else if (vehicleType.equals(String.valueOf(Type.PLANE))) {
                    Plane plane = new Plane();
                    plane.setId(vehicleId);
                    plane.setBrand(vehicleBrand);

                    vehicle = plane;
                }
                else {
                    Bike bike = new Bike();
                    bike.setId(vehicleId);
                    bike.setBrand(vehicleBrand);

                    vehicle = bike;
                }

            }

            rs.close();

        }catch (Exception e){
            e.printStackTrace();
        }

        return vehicle;
    }

    @PostConstruct
    private void connectToDatabase(){

        try (Connection conn = DriverManager.getConnection(url, username, password)) {

            System.out.println("✅ Connected to database!");
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @PreDestroy
    private void disconnectFromDatabase(){

        try (Connection conn = DriverManager.getConnection(url, username, password)) {

            conn.close();

            System.out.println("❌ Database connection pool closed.");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}