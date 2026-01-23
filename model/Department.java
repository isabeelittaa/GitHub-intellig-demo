package model;
import exception.InvalidHospitalDataException;

public class Department {
    private String deptName;
    private String headDoctor;
    private int totalBeds;
    private int occupiedBeds;

    public Department(String deptName, String headDoctor, int totalBeds) {
        this.deptName = deptName;
        this.headDoctor = headDoctor;
        this.totalBeds = totalBeds;
        this.occupiedBeds = 0;
    }

    public void admitPatientToWard() {
        if (occupiedBeds < totalBeds) {
            occupiedBeds++;
            System.out.println("Patient admitted to " + deptName);
        }
    }
    public void setTotalBeds(int totalBeds) throws InvalidHospitalDataException {
        if (totalBeds < 0) throw new InvalidHospitalDataException("Beds cannot be negative.");
        this.totalBeds = totalBeds;
    }
    @Override
    public String toString() {
        return deptName + " (" + occupiedBeds + "/" + totalBeds + ")";
    }
}