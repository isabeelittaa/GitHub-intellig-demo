package model;
public class MedicalRecord {
    private String recordId;
    private Patient patient;
    private String diagnosis;
    private boolean archived;

    public MedicalRecord(String id, Patient patient, String diagnosis) {
        this.recordId = id;
        this.patient = patient;
        this.diagnosis = diagnosis;
        this.archived = false;
    }

    public void addDoctorNote(String note) {
        if (!archived) {
            System.out.println("Note added: " + note);
        }
    }

    public void archiveRecord() {
        archived = true;
        System.out.println("Record archived.");
    }

    @Override
    public String toString() {
        return "Record [" + recordId + ", Patient=" + patient.getFullName() + "]";
    }
}