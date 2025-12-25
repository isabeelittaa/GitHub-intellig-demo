public class Doctor {
    // 1. Private fields (4+)
    private String doctorId;
    private String name;
    private String specialization;
    private int yearsOfExperience;
    private boolean isAvailable;

    // 2a. Parameterized Constructor
    public Doctor(String doctorId, String name, String specialization, int yearsOfExperience) {
        this.doctorId = doctorId;
        this.name = name;
        this.specialization = specialization;
        this.yearsOfExperience = yearsOfExperience;
        this.isAvailable = true;
    }

    // 2b. Default Constructor (REQUIRED BY RUBRIC)
    public Doctor() {
    }

    // 3. Getters and Setters for ALL fields
    public String getDoctorId() { return doctorId; }
    public void setDoctorId(String doctorId) { this.doctorId = doctorId; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getSpecialization() { return specialization; }
    public void setSpecialization(String specialization) { this.specialization = specialization; }

    public int getYearsOfExperience() { return yearsOfExperience; }
    public void setYearsOfExperience(int yearsOfExperience) { this.yearsOfExperience = yearsOfExperience; }

    public boolean isAvailable() { return isAvailable; }
    public void setAvailable(boolean available) { isAvailable = available; }

    // 4. Methods with Business Logic
    public void diagnosePatient(Patient patient) {
        if (isAvailable) {
            System.out.println("Dr. " + name + " is diagnosing " + patient.getFullName() + ".");
        } else {
            System.out.println("Dr. " + name + " is currently unavailable.");
        }
    }

    public void performSurgery() {
        if (yearsOfExperience >= 5) {
            this.isAvailable = false;
            System.out.println("Dr. " + name + " is performing a complex surgery. (Status: Busy)");
        } else {
            System.out.println("Dr. " + name + " needs more experience for this surgery.");
        }
    }

    // 5. toString Method (REQUIRED BY RUBRIC)
    @Override
    public String toString() {
        return "Doctor [ID=" + doctorId + ", Name=" + name + ", Spec=" + specialization + ", Exp=" + yearsOfExperience + " yrs]";
    }
}