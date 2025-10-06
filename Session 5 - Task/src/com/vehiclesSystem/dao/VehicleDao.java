package com.vehiclesSystem.dao;

import com.vehiclesSystem.model.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@Component
public class VehicleDao{

    @Value("${spring.datasource.url}")
    private String url;

    @Value("${spring.datasource.username}")
    private String username;

    @Value("${spring.datasource.password}")
    private String password;

    public void save(Vehicle vehicle) {

        String query = "INSERT INTO vehicles (id, brand, type) VALUES (?, ?, ?)";

        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {

            pstmt.setString(1, vehicle.getId());
            pstmt.setString(2, vehicle.getBrand());
            pstmt.setString(3, String.valueOf(vehicle.getType()));

            int rowsInserted = pstmt.executeUpdate();
            System.out.println("✅ Rows inserted: " + rowsInserted);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public Vehicle findVehicleById(String id) {

        String query = "SELECT * FROM vehicles WHERE id = ?";

        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {

            pstmt.setString(1, id);

            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {

                return getVehicle(
                        rs.getString("id"),
                        rs.getString("brand"),
                        rs.getString("type")
                );
            }

            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    public List<Vehicle> findAllVehicles() {

        List<Vehicle> vehicles = new ArrayList<>();

        String query = "SELECT * FROM vehicles";

        try (Connection conn = getConnection();
                Statement stmt = conn.createStatement()){

            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                vehicles.add(getVehicle(
                        rs.getString("id"),
                        rs.getString("brand"),
                        rs.getString("type")
                ));
            }

        }catch (SQLException e){
            e.printStackTrace();
        }

        return vehicles;

    }

    public void update(Vehicle vehicle) {

        String updateQuery = "UPDATE vehicles SET brand = ?, type = ? WHERE id = ?";

        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(updateQuery)) {

            pstmt.setString(1, vehicle.getBrand());
            pstmt.setString(2, String.valueOf(vehicle.getType()));
            pstmt.setString(3, vehicle.getId());

            int rows = pstmt.executeUpdate();
            if (rows > 0) {
                System.out.println("✅ Vehicle updated (ID: " + vehicle.getId() + ")");
            } else {
                System.out.println("⚠️ No Vehicle found with ID: " + vehicle.getId());
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void delete(String deleteId) {

        String deleteQuery = "DELETE FROM vehicles WHERE id = ?";

        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(deleteQuery)) {
            pstmt.setString(1, deleteId);

            int rowsDeleted = pstmt.executeUpdate();
            if (rowsDeleted > 0) {
                System.out.println("🗑️ Vehicle deleted successfully (ID: " + deleteId + ")");
            } else {
                System.out.println("⚠️ No Vehicle found with ID: " + deleteId);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    private Vehicle getVehicle(String vehicleId, String vehicleBrand, String vehicleType) {

        Vehicle vehicle;
        if (vehicleType.equals(String.valueOf(Type.CAR))) {
            vehicle = new Car(vehicleId, vehicleBrand, Type.CAR);
        } else if (vehicleType.equals(String.valueOf(Type.PLANE))) {
            vehicle = new Plane(vehicleId, vehicleBrand, Type.PLANE);
        } else {
            vehicle = new Bike(vehicleId, vehicleBrand, Type.BIKE);
        }

        return vehicle;
    }

    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, username, password);
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