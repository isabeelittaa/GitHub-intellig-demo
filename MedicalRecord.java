public class MedicalRecord {
    // 1. Private fields (4+)
    private String recordId;
    private String patientName;
    private String diagnosis;
    private String notes;
    private boolean isArchived;

    // 2a. Parameterized Constructor
    public MedicalRecord(String recordId, String patientName, String diagnosis) {
        this.recordId = recordId;
        this.patientName = patientName;
        this.diagnosis = diagnosis;
        this.notes = "Initial intake completed.";
        this.isArchived = false;
    }

    // 2b. Default Constructor (REQUIRED BY RUBRIC)
    public MedicalRecord() {
    }

    // 3. Getters and Setters for ALL fields
    public String getRecordId() { return recordId; }
    public void setRecordId(String recordId) { this.recordId = recordId; }

    public String getPatientName() { return patientName; }
    public void setPatientName(String patientName) { this.patientName = patientName; }

    public String getDiagnosis() { return diagnosis; }
    public void setDiagnosis(String diagnosis) { this.diagnosis = diagnosis; }

    public String getNotes() { return notes; }
    public void setNotes(String notes) { this.notes = notes; }

    public boolean isArchived() { return isArchived; }
    public void setArchived(boolean archived) { isArchived = archived; }

    // 4. Methods with Business Logic
    public void addDoctorNote(String newNote) {
        if (!isArchived) {
            this.notes += "\n - " + newNote;
            System.out.println("Note added to " + patientName + "'s record.");
        } else {
            System.out.println("Error: Cannot modify archived record for " + patientName);
        }
    }

    public void archiveRecord() {
        if (isArchived) {
            System.out.println("Record is already archived.");
        } else {
            this.isArchived = true;
            System.out.println("Action: Record for " + patientName + " has been archived.");
        }
    }

    // 5. toString Method (REQUIRED BY RUBRIC)
    @Override
    public String toString() {
        return "MedicalRecord [ID=" + recordId + ", Patient=" + patientName + ", Diagnosis=" + diagnosis + ", Archived=" + isArchived + "]";
    }
}