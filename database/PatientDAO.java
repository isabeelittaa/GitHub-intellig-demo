package database;

import exception.InvalidHospitalDataException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import model.Patient;

public class PatientDAO {

    private Patient extractPatient(ResultSet rs) throws SQLException, InvalidHospitalDataException {
        return new Patient(
            rs.getString("patient_id"),
            rs.getString("name"),
            rs.getInt("age"),
            rs.getString("ailment")
        );
    }

    public void insertPatient(Patient patient) {
        String sql = "INSERT INTO patients (patient_id, name, age, ailment) VALUES (?, ?, ?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, patient.getId());
            pstmt.setString(2, patient.getName());
            pstmt.setInt(3, patient.getAge());
            pstmt.setString(4, patient.getAilment());
            pstmt.executeUpdate();
            System.out.println("Patient saved to database!");
        } catch (SQLException e) { e.printStackTrace(); }
    }

    public List<Patient> getAllPatients() {
        List<Patient> patients = new ArrayList<>();
        String sql = "SELECT * FROM patients ORDER BY name";
        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) { patients.add(extractPatient(rs)); }
        } catch (Exception e) { e.printStackTrace(); }
        return patients;
    }

    public Patient getPatientById(String id) {
        String sql = "SELECT * FROM patients WHERE patient_id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, id);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) return extractPatient(rs);
            }
        } catch (Exception e) { e.printStackTrace(); }
        return null;
    }

    public boolean updatePatient(Patient p) {
        String sql = "UPDATE patients SET name = ?, age = ?, ailment = ? WHERE patient_id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, p.getName());
            pstmt.setInt(2, p.getAge());
            pstmt.setString(3, p.getAilment());
            pstmt.setString(4, p.getId());
            return pstmt.executeUpdate() > 0;
        } catch (SQLException e) { e.printStackTrace(); return false; }
    }

    public boolean deletePatient(String id) {
        String sql = "DELETE FROM patients WHERE patient_id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, id);
            return pstmt.executeUpdate() > 0;
        } catch (SQLException e) { e.printStackTrace(); return false; }
    }

    public List<Patient> searchByName(String name) {
        List<Patient> list = new ArrayList<>();
        String sql = "SELECT * FROM patients WHERE name ILIKE ? ORDER BY name";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, "%" + name + "%");
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) list.add(extractPatient(rs));
        } catch (Exception e) { e.printStackTrace(); }
        return list;
    }

    public List<Patient> searchByAgeRange(int min, int max) {
        List<Patient> list = new ArrayList<>();
        String sql = "SELECT * FROM patients WHERE age BETWEEN ? AND ? ORDER BY age DESC";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, min);
            pstmt.setInt(2, max);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) list.add(extractPatient(rs));
        } catch (Exception e) { e.printStackTrace(); }
        return list;
    }
}