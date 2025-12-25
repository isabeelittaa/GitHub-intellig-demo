public class Main {
    public static void main(String[] args) {
        System.out.println("=== Hospital Management System (Full Suite) ===");
        System.out.println();

        // 1. Create objects
        Patient patient = new Patient("P-101", "Sarah Connor", 35, "Arrhythmia");
        Doctor doctor = new Doctor("D-55", "Dr. Gregory House", "Cardiology", 15);
        Appointment appointment = new Appointment("APT-001", patient, doctor, "2023-11-15");
        Department cardioDept = new Department("DEPT-01", "Cardiology Wing", "Dr. House", 5);
        Medicine meds = new Medicine("MED-99", "HeartMed+", 50.00, 100, true);
        MedicalRecord record = new MedicalRecord("REC-500", patient.getFullName(), "Irregular Heartbeat");

        // 2. Display objects using toString() (MEETS RUBRIC)
        System.out.println("--- Testing toString() Methods ---");
        System.out.println(patient.toString());
        System.out.println(doctor.toString());
        System.out.println(appointment.toString());
        System.out.println(cardioDept.toString());
        System.out.println(meds.toString());
        System.out.println(record.toString());
        System.out.println();

        // 3. Test Business Logic
        System.out.println("--- Testing Business Logic ---");
        
        // Department Logic
        cardioDept.admitPatientToWard();
        
        // Medicine Logic
        meds.dispense(10);
        meds.applyDiscount(20);

        // Record Logic
        record.addDoctorNote("Patient prescribed HeartMed+.");
        record.archiveRecord();

        // Doctor/Patient/Appointment Logic
        doctor.performSurgery();
        patient.admitToHospital();
        appointment.confirmAppointment();

        System.out.println("\n=== Program Complete ===");
    }
}