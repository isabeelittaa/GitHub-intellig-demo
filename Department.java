public class Department {

    private String deptId;
    private String deptName;
    private String headDoctor;
    private int totalBeds;
    private int occupiedBeds;

    public Department(String deptId, String deptName, String headDoctor, int totalBeds) {
        this.deptId = deptId;
        this.deptName = deptName;
        this.headDoctor = headDoctor;
        this.totalBeds = totalBeds;
        this.occupiedBeds = 0;
    }

    public String getDeptName() {
        return deptName;
    }

    public int getOccupiedBeds() {
        return occupiedBeds;
    }

    public void admitPatientToWard() {
        if (occupiedBeds < totalBeds) {
            occupiedBeds++;
            System.out.println("Patient admitted to " + deptName + ". Beds used: " + occupiedBeds + "/" + totalBeds);
        } else {
            System.out.println("Alert: " + deptName + " is at full capacity! Cannot admit patient.");
        }
    }

    public void dischargePatientFromWard() {
        if (occupiedBeds > 0) {
            occupiedBeds--;
            System.out.println("Patient discharged from " + deptName + ". Beds available: " + (totalBeds - occupiedBeds));
        } else {
            System.out.println("Error: No patients to discharge in " + deptName);
        }
    }
}