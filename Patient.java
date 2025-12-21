public class Patient {
    // 1. Private fields (4+)
    private String patientId;
    private String fullName;
    private int age;
    private String ailment; // The reason they are at the hospital
    private boolean isAdmitted;

    // 2. Constructor
    public Patient(String patientId, String fullName, int age, String ailment) {
        this.patientId = patientId;
        this.fullName = fullName;
        this.age = age;
        this.ailment = ailment;
        this.isAdmitted = false; // Default to not admitted
    }

    // 3. Getters and Setters
    public String getFullName() { return fullName; }
    public void setFullName(String fullName) { this.fullName = fullName; }
    
    public String getAilment() { return ailment; }
    public void setAilment(String ailment) { this.ailment = ailment; }

    public boolean isAdmitted() { return isAdmitted; }

    // 4. Methods with Business Logic

    // Method to admit a patient to the hospital
    public void admitToHospital() {
        if (isAdmitted) {
            System.out.println("Patient " + fullName + " is already admitted.");
        } else {
            this.isAdmitted = true;
            System.out.println("Action: Patient " + fullName + " has been admitted for " + ailment + ".");
        }
    }

    // Method to discharge the patient
    public void discharge() {
        if (isAdmitted) {
            this.isAdmitted = false;
            this.ailment = "Recovered"; // Update ailment status
            System.out.println("Action: Patient " + fullName + " has been discharged successfully.");
        } else {
            System.out.println("Error: Cannot discharge " + fullName + ". They are not currently admitted.");
        }
    }
}