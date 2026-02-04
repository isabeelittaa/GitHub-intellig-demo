package database;

import model.Doctor;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DoctorDAO {
    public void insertDoctor(Doctor d) {
        String sql = "INSERT INTO doctors (doctor_id, name, age, specialization, experience) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, d.getId());
            pstmt.setString(2, d.getName());
            pstmt.setInt(3, d.getAge());
            pstmt.setString(4, "General"); // или добавь геттер в Doctor.java
            pstmt.setInt(5, 5); // или добавь геттер в Doctor.java
            pstmt.executeUpdate();
        } catch (SQLException e) { e.printStackTrace(); }
    }

    public List<Doctor> getAllDoctors() {
        List<Doctor> list = new ArrayList<>();
        String sql = "SELECT * FROM doctors";
        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                list.add(new Doctor(rs.getString("doctor_id"), rs.getString("name"), 
                         rs.getInt("age"), rs.getString("specialization"), rs.getInt("experience")));
            }
        } catch (Exception e) { e.printStackTrace(); }
        return list;
    }
}