package main.com.myApp.dao;

import main.com.myApp.mode.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.sql.*;

@Component
public class UserDao {

    @Value("${spring.datasource.url}")
    private String url;

    @Value("${spring.datasource.username}")
    private String username;

    @Value("${spring.datasource.password}")
    private String password;

    public void save(User user) {

        String query = "INSERT INTO users (first_name, last_name, email, city, dateOfBirth) VALUES (?, ?, ?, ?, ?)";

        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {

            pstmt.setString(1, user.getFirstName());
            pstmt.setString(2, user.getLastName());
            pstmt.setString(3, user.getEmail());
            pstmt.setString(4, user.getCity());
            pstmt.setDate(5, Date.valueOf(user.getDateOfBirth()));

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

        try (Connection conn = DriverManager.getConnection(url, username, password)) {

            System.out.println("✅ Connected to database!");
        } catch (SQLException e) {
            e.printStackTrace();
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