public class MedicalRecord {
    // 1. Private fields (4+)
    private String recordId;
    private String patientName;
    private String diagnosis;
    private String notes;
    private boolean isArchived; // If true, record cannot be modified

    // 2. Constructor
    public MedicalRecord(String recordId, String patientName, String diagnosis) {
        this.recordId = recordId;
        this.patientName = patientName;
        this.diagnosis = diagnosis;
        this.notes = "Initial intake completed.";
        this.isArchived = false;
    }

    // 3. Getters and Setters
    public String getDiagnosis() { return diagnosis; }
    public String getNotes() { return notes; }

    // 4. Methods with Business Logic

    // Logic: Append new notes to the history, but only if not archived
    public void addDoctorNote(String newNote) {
        if (!isArchived) {
            this.notes += "\n - " + newNote;
            System.out.println("Note added to " + patientName + "'s record.");
        } else {
            System.out.println("Error: Cannot modify archived record for " + patientName);
        }
    }

    // Logic: Lock the record so no further changes can be made
    public void archiveRecord() {
        if (isArchived) {
            System.out.println("Record is already archived.");
        } else {
            this.isArchived = true;
            System.out.println("Action: Record for " + patientName + " has been archived and is now read-only.");
        }
    }
}