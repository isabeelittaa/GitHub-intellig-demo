package model;
import exception.InvalidHospitalDataException;

public class Doctor extends Person {
    private String specialization;
    private int yearsOfExperience;
    private boolean isAvailable;

    public Doctor(String id, String name, int age, String specialization, int yearsOfExperience) throws InvalidHospitalDataException {
        super(id, name, age);
        this.specialization = specialization;
        setYearsOfExperience(yearsOfExperience);
        this.isAvailable = true;
    }

    public void setYearsOfExperience(int years) throws InvalidHospitalDataException {
        if (years < 0) throw new InvalidHospitalDataException("Experience cannot be negative.");
        this.yearsOfExperience = years;
    }

    public boolean isAvailable() { return isAvailable; }

    public void performSurgery() {
        if (yearsOfExperience >= 5) {
            isAvailable = false;
            System.out.println("Dr. " + getName() + " is performing surgery.");
        } else {
            System.out.println("Dr. " + getName() + " lacks experience.");
        }
    }

    @Override
    public void performRole() {
        System.out.println("Dr. " + getName() + " works in " + specialization);
    }
}