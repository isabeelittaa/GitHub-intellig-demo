package menu;

import exception.InvalidHospitalDataException;
import java.util.ArrayList;
import java.util.Scanner;
import model.*;

public class MenuManager implements Menu {
    private final Scanner scanner = new Scanner(System.in);
    private final ArrayList<Person> people = new ArrayList<>();
    private final Department department = new Department("Cardiology Wing", "Dr. Marat", 5);
    private final Medicine medicine = new Medicine("HeartMed+", 50.0, 100);

    @Override
    public void displayMenu() {
        System.out.println("\n=== Hospital Management System ===");
        System.out.println("1. Add Doctor");
        System.out.println("2. Add Patient");
        System.out.println("3. Show All People");
        System.out.println("4. Special Actions");
        System.out.println("5. Hospital Status");
        System.out.println("6. Exit");
        System.out.print("Choice: ");
    }

    @Override
    public void run() {
        while (true) {
            try {
                displayMenu();
                int choice = Integer.parseInt(scanner.nextLine());

                switch (choice) {
                    case 1 -> addDoctor();
                    case 2 -> addPatient();
                    case 3 -> showPeople();
                    case 4 -> runActions();
                    case 5 -> showStatus();
                    case 6 -> { return; }
                    default -> System.out.println("Invalid option.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Error: Please enter a valid number.");
            } catch (InvalidHospitalDataException e) {
                System.out.println("Data Error: " + e.getMessage());
            } catch (Exception e) {
                System.out.println("An unexpected error occurred: " + e.getMessage());
            }
        }
    }

    private void addDoctor() throws InvalidHospitalDataException {
        System.out.print("ID: "); String id = scanner.nextLine();
        System.out.print("Name: "); String name = scanner.nextLine();
        System.out.print("Age: "); int age = Integer.parseInt(scanner.nextLine());
        System.out.print("Specialization: "); String spec = scanner.nextLine();
        System.out.print("Experience: "); int exp = Integer.parseInt(scanner.nextLine());
        people.add(new Doctor(id, name, age, spec, exp));
    }

    private void addPatient() throws InvalidHospitalDataException {
        System.out.print("ID: "); String id = scanner.nextLine();
        System.out.print("Name: "); String name = scanner.nextLine();
        System.out.print("Age: "); int age = Integer.parseInt(scanner.nextLine());
        System.out.print("Ailment: "); String ailment = scanner.nextLine();
        people.add(new Patient(id, name, age, ailment));
    }

    private void showPeople() {
        for (Person p : people) {
            System.out.println(p);
            p.performRole();
        }
    }

    private void runActions() {
        for (Person p : people) {
            if (p instanceof Doctor d) d.performSurgery();
            else if (p instanceof Patient pat) pat.takeMedicine();
        }
    }

    private void showStatus() {
        System.out.println(department);
        System.out.println(medicine);
    }
}