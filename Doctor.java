public class Doctor {
    // 1. Private fields (4+)
    private String doctorId;
    private String name;
    private String specialization;
    private int yearsOfExperience;
    private boolean isAvailable;

    // 2. Constructor
    public Doctor(String doctorId, String name, String specialization, int yearsOfExperience) {
        this.doctorId = doctorId;
        this.name = name;
        this.specialization = specialization;
        this.yearsOfExperience = yearsOfExperience;
        this.isAvailable = true; // Default to available
    }

    // 3. Getters and Setters
    public String getName() { return name; }
    public boolean isAvailable() { return isAvailable; }
    public void setAvailable(boolean available) { isAvailable = available; }

    // 4. Methods with Business Logic

    // Method to perform a diagnosis
    public void diagnosePatient(Patient patient) {
        if (isAvailable) {
            System.out.println("Dr. " + name + " is diagnosing " + patient.getFullName() + " for " + patient.getAilment() + ".");
        } else {
            System.out.println("Dr. " + name + " is currently unavailable to diagnose patients.");
        }
    }

    // Method to perform surgery (logic based on experience)
    public void performSurgery() {
        if (yearsOfExperience >= 5) {
            this.isAvailable = false; // Doctor becomes busy
            System.out.println("Dr. " + name + " is performing a complex surgery. (Status: Busy)");
        } else {
            System.out.println("Dr. " + name + " does not have enough experience for this surgery. Consulting a senior doctor.");
        }
    }
}