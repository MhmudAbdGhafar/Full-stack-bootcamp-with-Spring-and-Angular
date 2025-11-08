package main.com.myApp.dao;

import main.com.myApp.model.Employee;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.sql.*;

@Component
public class EmployeeDao {

    @Value("${spring.datasource.url}")
    private String url;

    @Value("${spring.datasource.username}")
    private String username;

    @Value("${spring.datasource.password}")
    private String password;

    public void save(Employee employee) {

        String query = "INSERT INTO employees (userName, email, password) VALUES (?, ?, ?)";

        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {

            pstmt.setString(1, employee.getUserName());
            pstmt.setString(2, employee.getEmail());
            pstmt.setString(3, employee.getPassword());

            int rowsInserted = pstmt.executeUpdate();
            System.out.println("✅ Rows inserted: " + rowsInserted);

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    private Connection getConnection() throws SQLException {

        return DriverManager.getConnection(url, username, password);
    }

    @PostConstruct
    private void connectToDatabase() {

        try {
            Class.forName("com.mysql.jdbc.Driver");

            Connection conn = DriverManager.getConnection(url, username, password);

            System.out.println("✅ Connected to database!");

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    @PreDestroy
    private void disconnectFromDatabase() {

        try (Connection conn = DriverManager.getConnection(url, username, password)) {
            conn.close();
            System.out.println("❌ Database connection pool closed.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}