public class Department {
    // 1. Private fields (4+)
    private String deptId;
    private String deptName;
    private String headDoctor;
    private int totalBeds;
    private int occupiedBeds;

    // 2. Constructor
    public Department(String deptId, String deptName, String headDoctor, int totalBeds) {
        this.deptId = deptId;
        this.deptName = deptName;
        this.headDoctor = headDoctor;
        this.totalBeds = totalBeds;
        this.occupiedBeds = 0; // Starts empty
    }

    // 3. Getters and Setters
    public String getDeptName() { return deptName; }
    public int getOccupiedBeds() { return occupiedBeds; }

    // 4. Methods with Business Logic

    // Logic: Admit a patient to the ward if there is space
    public void admitPatientToWard() {
        if (occupiedBeds < totalBeds) {
            occupiedBeds++;
            System.out.println("Patient admitted to " + deptName + ". Beds used: " + occupiedBeds + "/" + totalBeds);
        } else {
            System.out.println("Alert: " + deptName + " is at full capacity! Cannot admit patient.");
        }
    }

    // Logic: Discharge a patient and free up a bed
    public void dischargePatientFromWard() {
        if (occupiedBeds > 0) {
            occupiedBeds--;
            System.out.println("Patient discharged from " + deptName + ". Beds available: " + (totalBeds - occupiedBeds));
        } else {
            System.out.println("Error: No patients to discharge in " + deptName);
        }
    }
}