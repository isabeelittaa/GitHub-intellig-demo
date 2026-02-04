package menu;

import database.DoctorDAO;
import database.PatientDAO; // Новый импорт
import exception.InvalidHospitalDataException;
import java.util.List;
import java.util.Scanner;
import model.*;

public class MenuManager implements Menu {
    private final Scanner scanner = new Scanner(System.in);
    private final PatientDAO patientDAO = new PatientDAO();
    private final DoctorDAO doctorDAO = new DoctorDAO(); // Работаем через DAO

    @Override
    public void displayMenu() {
        System.out.println("\n=== Hospital Management (FINAL DEFENSE) ===");
        System.out.println("1. Add Doctor");
        System.out.println("2. Add Patient");
        System.out.println("3. Show All Patients");
        System.out.println("4. Update Patient Info");
        System.out.println("5. Delete Patient");
        System.out.println("6. Search Patient by Name");
        System.out.println("7. Search by Age Range");
        System.out.println("8. Show All Doctors (from DB)");
        System.out.println("9. Hospital Status");
        System.out.println("10. Special Actions (Surgery)");
        System.out.println("0. Exit");
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
                    case 3 -> showPatients();
                    case 4 -> updatePatient();
                    case 5 -> deletePatient();
                    case 6 -> searchByName();
                    case 7 -> searchByAge();
                    case 8 -> showDoctors(); // Изменено
                    case 9 -> showStatus();
                    case 10 -> runActions(); // Изменено
                    case 0 -> { return; }
                    default -> System.out.println("Invalid option.");
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }

    // --- ЛОГИКА ДЛЯ ВРАЧЕЙ (БЕЗ ArrayList) ---
    private void addDoctor() throws InvalidHospitalDataException {
        System.out.print("ID: "); String id = scanner.nextLine();
        System.out.print("Name: "); String name = scanner.nextLine();
        System.out.print("Age: "); int age = Integer.parseInt(scanner.nextLine());
        System.out.print("Spec: "); String spec = scanner.nextLine();
        System.out.print("Exp: "); int exp = Integer.parseInt(scanner.nextLine());
        
        Doctor newDoctor = new Doctor(id, name, age, spec, exp);
        doctorDAO.insertDoctor(newDoctor); // СРАЗУ В БАЗУ
    }

    private void showDoctors() {
        List<Doctor> list = doctorDAO.getAllDoctors();
        if (list.isEmpty()) System.out.println("No doctors in database.");
        else list.forEach(System.out::println);
    }

    private void runActions() {
        // Подгружаем врачей из базы перед выполнением действий
        List<Doctor> list = doctorDAO.getAllDoctors();
        for (Doctor d : list) {
            d.performSurgery();
        }
    }

    // --- ЛОГИКА ДЛЯ ПАЦИЕНТОВ (УЖЕ БЕЗ ArrayList) ---
    private void addPatient() throws InvalidHospitalDataException {
        System.out.print("ID: "); String id = scanner.nextLine();
        System.out.print("Name: "); String name = scanner.nextLine();
        System.out.print("Age: "); int age = Integer.parseInt(scanner.nextLine());
        System.out.print("Ailment: "); String ailment = scanner.nextLine();
        patientDAO.insertPatient(new Patient(id, name, age, ailment));
    }

    private void showPatients() {
        patientDAO.getAllPatients().forEach(System.out::println);
    }

    private void updatePatient() throws InvalidHospitalDataException {
        System.out.print("Enter ID: "); String id = scanner.nextLine();
        Patient existing = patientDAO.getPatientById(id);
        if (existing != null) {
            System.out.print("New Name [" + existing.getName() + "]: ");
            String name = scanner.nextLine();
            if (name.isEmpty()) name = existing.getName();
            
            System.out.print("New Age: ");
            String ageInput = scanner.nextLine();
            int age = ageInput.isEmpty() ? existing.getAge() : Integer.parseInt(ageInput);
            
            System.out.print("New Ailment: ");
            String ailment = scanner.nextLine();
            if (ailment.isEmpty()) ailment = existing.getAilment();
            
            patientDAO.updatePatient(new Patient(id, name, age, ailment));
        } else System.out.println("❌ Not found.");
    }

    private void deletePatient() {
        System.out.print("ID to delete: "); String id = scanner.nextLine();
        System.out.print("Are you sure? (yes/no): ");
        if (scanner.nextLine().equalsIgnoreCase("yes")) {
            patientDAO.deletePatient(id);
        }
    }

    private void searchByName() {
        System.out.print("Search Name: ");
        patientDAO.searchByName(scanner.nextLine()).forEach(System.out::println);
    }

    private void searchByAge() {
        System.out.print("Min: "); int min = Integer.parseInt(scanner.nextLine());
        System.out.print("Max: "); int max = Integer.parseInt(scanner.nextLine());
        patientDAO.searchByAgeRange(min, max).forEach(System.out::println);
    }

    private void showStatus() {
        System.out.println("Hospital Status: Cardiology Wing (5 beds)");
    }
}