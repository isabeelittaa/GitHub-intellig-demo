public class MedicalRecord {

    private String recordId;
    private String patientName;
    private String diagnosis;
    private String notes;
    private boolean isArchived;

    public MedicalRecord(String recordId, String patientName, String diagnosis) {
        this.recordId = recordId;
        this.patientName = patientName;
        this.diagnosis = diagnosis;
        this.notes = "Initial intake completed.";
        this.isArchived = false;
    }

    public String getDiagnosis() {
        return diagnosis;
    }

    public String getNotes() {
        return notes;
    }

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
            System.out.println("Action: Record for " + patientName + " has been archived and is now read-only.");
        }
    }
}