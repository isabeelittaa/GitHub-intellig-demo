import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        ArrayList<Person> people = new ArrayList<>();

        people.add(new Doctor("D-01", "Dr. Arman", 45, "Cardiology", 12));
        people.add(new Patient("P-01", "Sarah", 25, "Arrhythmia"));
        Department department = new Department("Cardiology Wing", "Dr. Marat", 5);
        Medicine medicine = new Medicine("HeartMed+", 50.0, 100);
        while (true) {
            try {
                System.out.println("\n=== Hospital Management System ===");
                System.out.println("1. Add Doctor");
                System.out.println("2. Add Patient");
                System.out.println("3. Show All People (Polymorphism)");
                System.out.println("4. Run Special Actions (instanceof)");
                System.out.println("5. Show Hospital Status (Beds / Prices)");
                System.out.println("6. Exit");
                System.out.print("Choice: ");

                int choice = scanner.nextInt();
                scanner.nextLine(); 

                switch (choice) {

                    case 1 -> {
                        System.out.print("Doctor ID: ");
                        String id = scanner.nextLine();

                        System.out.print("Name: ");
                        String name = scanner.nextLine();

                        System.out.print("Age: ");
                        int age = scanner.nextInt();
                        scanner.nextLine();

                        System.out.print("Specialization: ");
                        String spec = scanner.nextLine();

                        System.out.print("Years of Experience: ");
                        int exp = scanner.nextInt();
                        scanner.nextLine();

                        people.add(new Doctor(id, name, age, spec, exp));
                        System.out.println("Doctor added successfully.");
                    }

                    case 2 -> {
                        System.out.print("Patient ID: ");
                        String id = scanner.nextLine();

                        System.out.print("Full Name: ");
                        String name = scanner.nextLine();

                        System.out.print("Age: ");
                        int age = scanner.nextInt();
                        scanner.nextLine();

                        System.out.print("Ailment: ");
                        String ailment = scanner.nextLine();

                        people.add(new Patient(id, name, age, ailment));
                        System.out.println("Patient added successfully.");
                    }

                    case 3 -> {
                        System.out.println("\n--- All Hospital People ---");
                        for (Person p : people) {
                            System.out.println(p);
                            p.performRole();
                        }
                    }

                    case 4 -> {
                        System.out.println("\n--- Special Actions ---");
                        for (Person p : people) {
                            if (p instanceof Doctor d) {
                                d.performSurgery();    
                            } else if (p instanceof Patient pat) {
                                pat.takeMedicine();   
                            }
                        }
                    }

                    
                    case 5 -> {
                        System.out.println("\n=== Hospital Status ===");

                        int doctors = 0;
                        int patients = 0;

                        for (Person p : people) {
                            if (p instanceof Doctor) doctors++;
                            else if (p instanceof Patient) patients++;
                        }

                        System.out.println("Doctors count: " + doctors);
                        System.out.println("Patients count: " + patients);

                        System.out.println("\nDepartment Info:");
                        System.out.println(department.toString());

                        System.out.println("\n5Medicine Info:");
                        System.out.println(medicine.toString());
                    }
                    case 6 -> {
                        System.out.println("Exiting system...");
                        scanner.close();
                        return;
                    }
                    default -> System.out.println("Invalid option.");
                }

            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Numbers only.");
                scanner.nextLine();
            }
        }
    }
}