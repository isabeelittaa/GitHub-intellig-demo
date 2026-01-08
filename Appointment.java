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


    public void confirmAppointment() {
        if (doctor.isAvailable()) {
            this.status = "Confirmed";
            System.out.println("Appointment " + appointmentId + " confirmed for " + date + ".");
        } else {
            this.status = "Waitlisted";
            System.out.println("Dr. " + doctor.getName() + " is busy. Added to waitlist.");
        }
    }

    public void completeVisit() {
        if (this.status.equals("Confirmed")) {
            this.status = "Completed";
            System.out.println("Visit completed for " + patient.getName());
        } else {
            System.out.println("Cannot complete visit. Status is " + this.status);
        }
    }

    @Override
    public String toString() {
        return "Appointment [ID=" + appointmentId + ", Date=" + date + ", Status=" + status + "]";
    }
}