public class Patient extends Person {
    private String ailment;

    public Patient(String id, String name, int age, String ailment) {
        super(id, name, age); 
        this.ailment = ailment;
    }

    @Override
    public void performRole() {
        System.out.println("Patient " + getName() + " is receiving treatment for " + ailment + ".");
    }

    @Override
    public String toString() {
        return "Patient [" + super.toString() + ", Ailment: " + ailment + "]";
    }

    public void takeMedicine() {
        System.out.println(getName() + " is taking prescribed medication.");
    }
}