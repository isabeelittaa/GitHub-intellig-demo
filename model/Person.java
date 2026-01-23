package model;
import exception.InvalidHospitalDataException;

public abstract class Person {
    private String id;
    private String name;
    private int age;

    public Person(String id, String name, int age) throws InvalidHospitalDataException {
        this.id = id;
        this.name = name;
        setAge(age);
    }

    public String getId() { return id; }
    public String getName() { return name; }
    public int getAge() { return age; }

    public void setAge(int age) throws InvalidHospitalDataException {
        if (age < 0 || age > 120) {
            throw new InvalidHospitalDataException("Age must be between 0 and 120.");
        }
        this.age = age;
    }

    public abstract void performRole();

    @Override
    public String toString() {
        return "ID: " + id + ", Name: " + name + ", Age: " + age;
    }
}