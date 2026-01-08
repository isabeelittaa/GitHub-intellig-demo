public class Doctor extends Person {
    private String specialization;
    private boolean isAvailable = true;

    public Doctor(String id, String name, int age, String specialization) {
        super(id, name, age);
        this.specialization = specialization;
    }

    public void performSurgery() {
        System.out.println("Dr. " + getName() + " is performing a complex surgery.");
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    @Override
    public void performRole() {
        System.out.println("Dr. " + getName() + " is examining patients in " + specialization + ".");
    }

    @Override
    public String toString() {
        return "Doctor [" + super.toString() + ", Spec: " + specialization + "]";
    }
}