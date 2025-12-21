public class Appointment {

    private String appointmentId;
    private Patient patient;
    private Doctor doctor;
    private String date;
    private String status;

    public Appointment(String appointmentId, Patient patient, Doctor doctor, String date) {
        this.appointmentId = appointmentId;
        this.patient = patient;
        this.doctor = doctor;
        this.date = date;
        this.status = "Pending";
    }

    public String getStatus() {
        return status;
    }

    public void confirmAppointment() {
        if (doctor.isAvailable()) {
            this.status = "Confirmed";
            System.out.println("Appointment " + appointmentId + " confirmed for " + date + " with Dr. " + doctor.getName());
        } else {
            this.status = "Waitlisted";
            System.out.println("Dr. " + doctor.getName() + " is busy. Appointment added to waitlist.");
        }
    }

    public void completeVisit() {
        if (this.status.equals("Confirmed")) {
            this.status = "Completed";
            System.out.println("Visit completed. " + patient.getFullName() + " has seen Dr. " + doctor.getName());
        } else {
            System.out.println("Cannot complete visit. Appointment is " + this.status);
        }
    }
}