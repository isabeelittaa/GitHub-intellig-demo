package model;
import exception.InvalidHospitalDataException;

public class Appointment implements Schedulable {
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

    @Override
    public void reschedule(String newDate) {
        this.date = newDate;
        System.out.println("Appointment " + appointmentId + " moved to " + newDate);
    }

    @Override
    public String getScheduleDetails() {
        return "Appointment on " + date + " with Dr. " + doctor.getName();
    }
}