public class Appointment {
    private String appointmentId;
    private Patient patient;
    private Doctor doctor;
    private String date;
    private String status;

    public Appointment(String id, Patient patient, Doctor doctor, String date) {
        this.appointmentId = id;
        this.patient = patient;
        this.doctor = doctor;
        this.date = date;
        this.status = "Pending";
    }

    public void confirmAppointment() {
        if (doctor.isAvailable()) {
            status = "Confirmed";
            System.out.println("Appointment confirmed for " + date);
        } else {
            status = "Waitlisted";
        }
    }

    public void completeVisit() {
        if (status.equals("Confirmed")) {
            status = "Completed";
            System.out.println("Visit completed for " + patient.getFullName());
        }
    }

    @Override
    public String toString() {
        return "Appointment [ID=" + appointmentId + ", Status=" + status + "]";
    }
}