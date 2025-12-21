public class Main {
    public static void main(String[] args) {

        System.out.println("=== Hospital Management System (Full Suite) ===");
        System.out.println();

        Patient patient = new Patient("P-101", "Sarah Connor", 35, "Arrhythmia");
        Doctor doctor = new Doctor("D-55", "Dr. Gregory House", "Cardiology",15);
        Appointment appointment = new Appointment("APT-001", patient, doctor, "2023-11-15");

        Department cardioDept = new Department("DEPT-01", "Cardiology Wing", "Dr. House", 5);
        Medicine meds = new Medicine("MED-99", "HeartMed+", 50.00, 100, true);
        MedicalRecord record = new MedicalRecord("REC-500", patient.getFullName(), "Irregular Heartbeat");

        System.out.println("--- Initial State ---");
        System.out.println("Patient: " + patient.getFullName());
        System.out.println("Department: " + cardioDept.getDeptName() + " | Occupied Beds: " + cardioDept.getOccupiedBeds());
        System.out.println("Medicine: " + meds.getName() + " | Stock: " + meds.getStockQuantity());
        System.out.println("Medical Record Notes: " + record.getNotes());
        System.out.println();

        System.out.println("--- Testing Getters ---");
        System.out.println("Doctor Name: " + doctor.getName());
        System.out.println("Medicine Price: $" + meds.getPrice());
        System.out.println("Record Diagnosis: " + record.getDiagnosis());
        System.out.println();

        System.out.println("--- Testing Setters ---");
        patient.setAilment("Stable Heart Condition");
        System.out.println("Updated Ailment: " + patient.getAilment());

        doctor.setAvailable(false);
        System.out.println("Doctor Busy: " + !doctor.isAvailable());
        System.out.println();

        System.out.println("--- Testing Logic Methods ---");

        System.out.println("[Department Operations]");
        cardioDept.admitPatientToWard();
        cardioDept.admitPatientToWard();

        System.out.println("\n[Pharmacy Operations]");
        meds.dispense(10);
        meds.applyDiscount(20);

        System.out.println("\n[Record Operations]");
        record.addDoctorNote("Patient prescribed HeartMed+.");
        record.archiveRecord();
        record.addDoctorNote("This should fail because record is archived.");

        System.out.println("\n[Doctor Operations]");
        doctor.performSurgery();
        System.out.println();

        System.out.println("--- Final State ---");
        System.out.println("Department Beds Occupied: " + cardioDept.getOccupiedBeds());
        System.out.println("Medicine Stock: " + meds.getStockQuantity());
        System.out.println("Medicine New Price: $" + meds.getPrice());
        System.out.println("Final Record Notes: \n" + record.getNotes());

        System.out.println("\n=== Program Complete ===");
    }
}