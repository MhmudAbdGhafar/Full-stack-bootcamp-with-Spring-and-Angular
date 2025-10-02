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

            String query = "INSERT INTO vehicles (id, brand, type) VALUES (?, ?, ?)";

            try (PreparedStatement pstmt = con.prepareStatement(query)) {

                pstmt.setString(1, vehicle.getId());
                pstmt.setString(2, vehicle.getBrand());
                pstmt.setString(3, String.valueOf(vehicle.getType()));

                System.out.println("✅ New row inserted: ");
            }

        }catch (Exception e){
            e.printStackTrace();
        }

    }

    public Vehicle getVehicleById(String id) {

        try {

            Connection con = DriverManager.getConnection(url, username, password);

            Statement st = con.createStatement();

            String query = "SELECT * FROM vehicles WHERE id = ?";

            PreparedStatement pstmt = con.prepareStatement(query);
            pstmt.setString(1, id);

            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {

                String vehicleId = rs.getString("id");
                String vehicleBrand = rs.getString("brand");
                String vehicleType = rs.getString("type");

                if(vehicleType.equals(String.valueOf(Type.CAR))){

                    Car car = new Car();
                    car.setId(vehicleId);
                    car.setBrand(vehicleBrand);

                    System.out.println("✅ User found: " + car.toString());

                    return car;
                }
                else if(vehicleType.equals(String.valueOf(Type.PLANE))){

                    Plane plane = new Plane();
                    plane.setId(vehicleId);
                    plane.setBrand(vehicleBrand);

                    System.out.println("✅ User found: " + plane.toString());

                    return plane;
                }
                else if(vehicleType.equals(String.valueOf(Type.BIKE))){

                    Bike bike = new Bike();
                    bike.setId(vehicleId);
                    bike.setBrand(vehicleBrand);

                    System.out.println("✅ User found: " + bike.toString());

                    return bike;
                }
            }

            rs.close();

        }catch (Exception e){
            e.printStackTrace();
        }


        return null;
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