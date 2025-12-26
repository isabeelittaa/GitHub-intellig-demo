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

    public Department() {
    }

    public String getDeptId() { return deptId; }
    public void setDeptId(String deptId) { this.deptId = deptId; }

    public String getDeptName() { return deptName; }
    public void setDeptName(String deptName) { this.deptName = deptName; }

    public String getHeadDoctor() { return headDoctor; }
    public void setHeadDoctor(String headDoctor) { this.headDoctor = headDoctor; }

    public int getTotalBeds() { return totalBeds; }
    public void setTotalBeds(int totalBeds) { this.totalBeds = totalBeds; }

    public int getOccupiedBeds() { return occupiedBeds; }
    public void setOccupiedBeds(int occupiedBeds) { this.occupiedBeds = occupiedBeds; }

    public void admitPatientToWard() {
        if (occupiedBeds < totalBeds) {
            occupiedBeds++;
            System.out.println("Patient admitted to " + deptName + ". Beds used: " + occupiedBeds + "/" + totalBeds);
        } else {
            System.out.println("Alert: " + deptName + " is at full capacity!");
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

    @Override
    public String toString() {
        return "Department [Name=" + deptName + ", Head=" + headDoctor + ", Capacity=" + occupiedBeds + "/" + totalBeds + "]";
    }
}