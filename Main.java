import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArrayList<Person> hospitalPeople = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        hospitalPeople.add(new Doctor("D-01", "Dr. Arman", 40, "Cardiology"));
        hospitalPeople.add(new Patient("P-01", "Sarah", 25, "Arrhythmia"));

        while (true) {
            try {
                System.out.println("\n=== Hospital Management System ===");
                System.out.println("1. Add Doctor");
                System.out.println("2. Add Patient");
                System.out.println("3. Show All People (Polymorphism)");
                System.out.println("4. Run Role-Specific Actions (instanceof/Casting)");
                System.out.println("5. Exit");
                System.out.print("Select choice: ");

                int choice = scanner.nextInt();
                scanner.nextLine(); 

                if (choice == 1) {
                    System.out.print("Enter ID: "); String id = scanner.nextLine();
                    System.out.print("Enter Name: "); String name = scanner.nextLine();
                    
                    System.out.print("Enter Age: "); 
                    int age = scanner.nextInt(); 
                    scanner.nextLine(); 
                    
                    System.out.print("Enter Specialization: "); String spec = scanner.nextLine();
                    hospitalPeople.add(new Doctor(id, name, age, spec));
                    System.out.println("Doctor added successfully!");

                } else if (choice == 2) {
                    System.out.print("Enter ID: "); String id = scanner.nextLine();
                    System.out.print("Enter Name: "); String name = scanner.nextLine();
                    
                    System.out.print("Enter Age: "); 
                    int age = scanner.nextInt();
                    scanner.nextLine();
                    
                    System.out.print("Enter Ailment: "); String ailment = scanner.nextLine();
                    hospitalPeople.add(new Patient(id, name, age, ailment));
                    System.out.println("Patient added successfully!");

                } else if (choice == 3) {
                    System.out.println("\n--- Current Hospital Directory ---");
                    if (hospitalPeople.isEmpty()) {
                        System.out.println("List is empty.");
                    } else {
                        for (Person p : hospitalPeople) {
                            System.out.println(p.toString());
                            p.performRole(); 
                        }
                    }

                } else if (choice == 4) {
                    System.out.println("\n--- Special Actions ---");
                    for (Person p : hospitalPeople) {
                        if (p instanceof Doctor) {
                            ((Doctor) p).performSurgery();
                        } else if (p instanceof Patient) {
                            ((Patient) p).takeMedicine();
                        }
                    }

                } else if (choice == 5) {
                    System.out.println("Exiting program...");
                    break;
                } else {
                    System.out.println("Invalid choice. Try again.");
                }

            } catch (InputMismatchException e) {
                System.out.println("\n!!! ERROR: You entered text instead of a number. Please try again. !!!");
                scanner.nextLine();
            }
        }
        scanner.close();
    }
}