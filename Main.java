public class Main {
    public static void main(String[] args) {
        System.out.println("=== Hospital Management System (Full Suite) ===");
        System.out.println();

        Patient patient = new Patient("P-101", "Sarah Maksimovich", 35, "Arrhythmia");
        Doctor doctor = new Doctor("D-07", "Dr. Arman Maratovich", "Cardiology", 15);
        Appointment appointment = new Appointment("APT-001", patient, doctor, "2025-04-01");
        Department cardioDept = new Department("DEPT-01", "Cardiology Wing", "Dr. Marat", 5);
        Medicine meds = new Medicine("MED-99", "HeartMed+", 50.00, 100, true);
        MedicalRecord record = new MedicalRecord("REC-100", patient.getFullName(), "Irregular Heartbeat");

        System.out.println("--- Testing toString() Methods ---");
        System.out.println(patient.toString());
        System.out.println(doctor.toString());
        System.out.println(appointment.toString());
        System.out.println(cardioDept.toString());
        System.out.println(meds.toString());
        System.out.println(record.toString());
        System.out.println();

        System.out.println("--- Testing Business Logic ---");
        
        cardioDept.admitPatientToWard();
        
        meds.dispense(10);
        meds.applyDiscount(20);

        record.addDoctorNote("Patient prescribed HeartMed+.");
        record.archiveRecord();

        doctor.performSurgery();
        patient.admitToHospital();
        appointment.confirmAppointment();

        System.out.println("\n=== Program Complete ===");
    }
}