public class Main {
    public static void main(String[] args) {
        // 1. Welcome message
        System.out.println("=== Hospital Management System (Full Suite) ===");
        System.out.println();

        // 2. Create objects
        // Core Entities
        Patient patient = new Patient("P-101", "Sarah Connor", 35, "Arrhythmia");
        Doctor doctor = new Doctor("D-55", "Dr. Gregory House", "Cardiology", 15);
        Appointment appointment = new Appointment("APT-001", patient, doctor, "2023-11-15");

        // New Entities
        Department cardioDept = new Department("DEPT-01", "Cardiology Wing", "Dr. House", 5);
        Medicine meds = new Medicine("MED-99", "HeartMed+", 50.00, 100, true);
        MedicalRecord record = new MedicalRecord("REC-500", patient.getFullName(), "Irregular Heartbeat");

        // 3. Display initial state
        System.out.println("--- Initial State ---");
        System.out.println("Patient: " + patient.getFullName());
        System.out.println("Department: " + cardioDept.getDeptName() + " | Occupied Beds: " + cardioDept.getOccupiedBeds());
        System.out.println("Medicine: " + meds.getName() + " | Stock: " + meds.getStockQuantity());
        System.out.println("Medical Record Notes: " + record.getNotes());
        System.out.println();

        // 4. Test getters
        System.out.println("--- Testing Getters ---");
        System.out.println("Doctor Name: " + doctor.getName());
        System.out.println("Medicine Price: $" + meds.getPrice());
        System.out.println("Record Diagnosis: " + record.getDiagnosis());
        System.out.println();

        // 5. Test setters
        System.out.println("--- Testing Setters ---");
        // Update patient ailment
        patient.setAilment("Stable Heart Condition"); 
        System.out.println("Updated Ailment: " + patient.getAilment());
        
        // Update doctor availability
        doctor.setAvailable(false); 
        System.out.println("Doctor Busy: " + !doctor.isAvailable());
        System.out.println();

        // 6. Test additional methods (Business Logic)
        System.out.println("--- Testing Logic Methods ---");

        // A. Department Logic (Bed Management)
        System.out.println("[Department Operations]");
        cardioDept.admitPatientToWard(); // Bed count increases
        cardioDept.admitPatientToWard(); // Bed count increases again
        
        // B. Medicine Logic (Inventory & Pricing)
        System.out.println("\n[Pharmacy Operations]");
        meds.dispense(10); // Reduce stock
        meds.applyDiscount(20); // 20% off price

        // C. Medical Record Logic (History & Archiving)
        System.out.println("\n[Record Operations]");
        record.addDoctorNote("Patient prescribed HeartMed+."); 
        record.archiveRecord(); // Lock the record
        record.addDoctorNote("This should fail because record is archived."); // Test logic failure
        
        // D. Appointment/Doctor Logic
        System.out.println("\n[Doctor Operations]");
        // Doctor performs surgery logic
        doctor.performSurgery();
        System.out.println();

        // 7. Display final state
        System.out.println("--- Final State ---");
        System.out.println("Department Beds Occupied: " + cardioDept.getOccupiedBeds());
        System.out.println("Medicine Stock: " + meds.getStockQuantity());
        System.out.println("Medicine New Price: $" + meds.getPrice());
        System.out.println("Final Record Notes: \n" + record.getNotes());

        // 8. Completion message
        System.out.println("\n=== Program Complete ===");
    }
}