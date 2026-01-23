package model;

import exception.InvalidHospitalDataException;

public class Patient extends Person {
    private String ailment;
    private boolean isAdmitted;
    
    public Patient(String id, String name, int age, String ailment) throws InvalidHospitalDataException {
        super(id, name, age);
        this.ailment = ailment;
        this.isAdmitted = false;
    }

    public String getFullName() {
        return getName();
    }

    public void admitToHospital() {
        if (!isAdmitted) {
            isAdmitted = true;
            System.out.println("Patient admitted: " + getName());
        }
    }

    public void discharge() {
        isAdmitted = false;
        ailment = "Recovered";
        System.out.println("Patient discharged: " + getName());
    }

    public void takeMedicine() {
        System.out.println(getName() + " takes medicine for " + ailment);
    }

    @Override
    public void performRole() {
        System.out.println("Patient " + getName() + " treated for " + ailment);
    }

    @Override
    public String toString() {
        return "Patient [" + super.toString() + ", Ailment=" + ailment + "]";
    }
}