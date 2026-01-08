public class Doctor extends Person {
    private String specialization;
    private int yearsOfExperience;
    private boolean isAvailable;

    public Doctor(String id, String name, int age, String specialization, int yearsOfExperience) {
        super(id, name, age);
        this.specialization = specialization;
        this.yearsOfExperience = yearsOfExperience;
        this.isAvailable = true;
    }

    public boolean isAvailable() { return isAvailable; }

    public void diagnosePatient(Patient patient) {
        if (isAvailable) {
            System.out.println("Dr. " + getName() + " is diagnosing " + patient.getFullName());
        }
    }

    public void performSurgery() {
        if (yearsOfExperience >= 5) {
            isAvailable = false;
            System.out.println("Dr. " + getName() + " is performing surgery (Busy)");
        } else {
            System.out.println("Dr. " + getName() + " lacks experience.");
        }
    }

    @Override
    public void performRole() {
        System.out.println("Dr. " + getName() + " works in " + specialization);
    }

    @Override
    public String toString() {
        return "Doctor [" + super.toString() +
                ", Spec=" + specialization +
                ", Exp=" + yearsOfExperience + "]";
    }
}