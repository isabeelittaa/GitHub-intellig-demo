public class Patient {
    private String patientId;
    private String fullName;
    private int age;
    private String ailment;
    private boolean isAdmitted;

    public Patient(String patientId, String fullName, int age, String ailment) {
        this.patientId = patientId;
        this.fullName = fullName;
        this.age = age;
        this.ailment = ailment;
        this.isAdmitted = false;
    }

    public Patient() {
    }

    public String getPatientId() { return patientId; }
    public void setPatientId(String patientId) { this.patientId = patientId; }

    public String getFullName() { return fullName; }
    public void setFullName(String fullName) { this.fullName = fullName; }

    public int getAge() { return age; }
    public void setAge(int age) { this.age = age; }

    public String getAilment() { return ailment; }
    public void setAilment(String ailment) { this.ailment = ailment; }

    public boolean isAdmitted() { return isAdmitted; }
    public void setAdmitted(boolean admitted) { isAdmitted = admitted; }

    public void admitToHospital() {
        if (isAdmitted) {
            System.out.println("Patient " + fullName + " is already admitted.");
        } else {
            this.isAdmitted = true;
            System.out.println("Action: Patient " + fullName + " has been admitted for " + ailment + ".");
        }
    }

    public void discharge() {
        if (isAdmitted) {
            this.isAdmitted = false;
            this.ailment = "Recovered";
            System.out.println("Action: Patient " + fullName + " has been discharged successfully.");
        } else {
            System.out.println("Error: Cannot discharge " + fullName + ". They are not currently admitted.");
        }
    }

    @Override
    public String toString() {
        return "Patient [ID=" + patientId + ", Name=" + fullName + ", Age=" + age + ", Ailment=" + ailment + "]";
    }
}