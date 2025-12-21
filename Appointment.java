public class Appointment {
    // 1. Private fields (4+)
    private String appointmentId;
    private Patient patient; // Storing the actual Patient object
    private Doctor doctor;   // Storing the actual Doctor object
    private String date;
    private String status;   // e.g., "Scheduled", "Completed", "Cancelled"

    // 2. Constructor
    public Appointment(String appointmentId, Patient patient, Doctor doctor, String date) {
        this.appointmentId = appointmentId;
        this.patient = patient;
        this.doctor = doctor;
        this.date = date;
        this.status = "Pending";
    }

    // 3. Getters and Setters
    public String getStatus() { return status; }

    // 4. Methods with Business Logic

    // Method to confirm appointment if doctor is available
    public void confirmAppointment() {
        if (doctor.isAvailable()) {
            this.status = "Confirmed";
            System.out.println("Appointment " + appointmentId + " confirmed for " + date + " with Dr. " + doctor.getName());
        } else {
            this.status = "Waitlisted";
            System.out.println("Dr. " + doctor.getName() + " is busy. Appointment added to waitlist.");
        }
    }

    // Method to complete the visit and update patient history
    public void completeVisit() {
        if (this.status.equals("Confirmed")) {
            this.status = "Completed";
            System.out.println("Visit completed. " + patient.getFullName() + " has seen Dr. " + doctor.getName());
        } else {
            System.out.println("Cannot complete visit. Appointment is " + this.status);
        }
    }
}