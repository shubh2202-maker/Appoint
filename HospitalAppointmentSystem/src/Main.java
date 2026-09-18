import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Scanner;
import model.Appointment;
import model.Bill;
import model.Doctor;
import model.Patient;
import service.AppointmentService;
import service.BillService;
import service.DoctorService;
import service.PatientService;

public class Main {

    private static final Scanner scanner = new Scanner(System.in);

    private static final PatientService patientService =
            new PatientService();

    private static final DoctorService doctorService =
            new DoctorService();

    private static final AppointmentService appointmentService =
            new AppointmentService();

    private static final BillService billService =
            new BillService();

    public static void main(String[] args) {

        while (true) {

            System.out.println("\n========================================");
            System.out.println("       HOSPITAL APPOINTMENT SYSTEM");
            System.out.println("========================================");
            System.out.println("1. Patient Management");
            System.out.println("2. Doctor Management");
            System.out.println("3. Appointment Management");
            System.out.println("4. Billing");
            System.out.println("5. Reports");
            System.out.println("6. Exit");
            System.out.println("========================================");

            System.out.print("Enter your choice: ");

            int choice;

            try {
                choice = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("\nPlease enter a valid number.");
                continue;
            }

            switch (choice) {

                case 1:
                    patientMenu();
                    break;

                case 2:
                    doctorMenu();
                    break;

                case 3:
                    appointmentMenu();
                    break;

                case 4:
                    billingMenu();
                    break;

                case 5:
                    reportsMenu();
                    break;

                case 6:
                    System.out.println("\nThank you for using the system!");
                    scanner.close();
                    return;

                default:
                    System.out.println("\nInvalid choice. Try again.");
            }
        }
    }

    public static void patientMenu() {

        while (true) {

            System.out.println("\n========================================");
            System.out.println("         PATIENT MANAGEMENT");
            System.out.println("========================================");
            System.out.println("1. Add Patient");
            System.out.println("2. View All Patients");
            System.out.println("3. Search Patient");
            System.out.println("4. Update Patient");
            System.out.println("5. Delete Patient");
            System.out.println("6. Back");
            System.out.println("========================================");

            System.out.print("Enter your choice: ");

            int choice;

            try {
                choice = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("\nPlease enter a valid number.");
                continue;
            }

            switch (choice) {

                case 1:
                    addPatient();
                    break;

                case 2:
                    viewPatients();
                    break;

                case 3:
                    searchPatient();
                    break;

                case 4:
                    updatePatient();
                    break;

                case 5:
                    deletePatient();
                    break;

                case 6:
                    return;

                default:
                    System.out.println("\nInvalid choice. Try again.");
            }
        }
    }

    public static void doctorMenu() {

        while (true) {

            System.out.println("\n========================================");
            System.out.println("          DOCTOR MANAGEMENT");
            System.out.println("========================================");
            System.out.println("1. Add Doctor");
            System.out.println("2. View All Doctors");
            System.out.println("3. Search Doctor");
            System.out.println("4. Update Doctor");
            System.out.println("5. Delete Doctor");
            System.out.println("6. Back");
            System.out.println("========================================");

            System.out.print("Enter your choice: ");

            int choice;

            try {
                choice = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("\nPlease enter a valid number.");
                continue;
            }

            switch (choice) {

                case 1:
                    addDoctor();
                    break;

                case 2:
                    viewDoctors();
                    break;

                case 3:
                    searchDoctor();
                    break;

                case 4:
                    updateDoctor();
                    break;

                case 5:
                    deleteDoctor();
                    break;

                case 6:
                    return;

                default:
                    System.out.println("\nInvalid choice. Try again.");
            }
        }
    }

    public static void appointmentMenu() {

        while (true) {

            System.out.println("\n========================================");
            System.out.println("       APPOINTMENT MANAGEMENT");
            System.out.println("========================================");
            System.out.println("1. Add Appointment");
            System.out.println("2. View All Appointments");
            System.out.println("3. Search Appointment");
            System.out.println("4. Cancel Appointment");
            System.out.println("5. Back");
            System.out.println("========================================");

            System.out.print("Enter your choice: ");

            int choice;

            try {
                choice = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("\nPlease enter a valid number.");
                continue;
            }

            switch (choice) {

                case 1:
                    addAppointment();
                    break;

                case 2:
                    viewAppointments();
                    break;

                case 3:
                    searchAppointment();
                    break;

                case 4:
                    cancelAppointment();
                    break;

                case 5:
                    return;

                default:
                    System.out.println("\nInvalid choice. Try again.");
            }
        }
    }

    public static void billingMenu() {

        while (true) {

            System.out.println("\n========================================");
            System.out.println("              BILLING");
            System.out.println("========================================");
            System.out.println("1. Generate Bill");
            System.out.println("2. View All Bills");
            System.out.println("3. Search Bill");
            System.out.println("4. Back");
            System.out.println("========================================");

            System.out.print("Enter your choice: ");

            int choice;

            try {
                choice = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("\nPlease enter a valid number.");
                continue;
            }

            switch (choice) {

                case 1:
                    generateBill();
                    break;

                case 2:
                    viewBills();
                    break;

                case 3:
                    searchBill();
                    break;

                case 4:
                    return;

                default:
                    System.out.println("\nInvalid choice. Try again.");
            }
        }
    }

    public static void reportsMenu() {

        while (true) {

            System.out.println("\n========================================");
            System.out.println("              REPORTS");
            System.out.println("========================================");
            System.out.println("1. Patient Report");
            System.out.println("2. Doctor Report");
            System.out.println("3. Appointment Report");
            System.out.println("4. Billing Report");
            System.out.println("5. Hospital Summary");
            System.out.println("6. Back");
            System.out.println("========================================");

            System.out.print("Enter your choice: ");

            int choice;

            try {
                choice = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("\nPlease enter a valid number.");
                continue;
            }

            switch (choice) {

                case 1:
                    patientReport();
                    break;

                case 2:
                    doctorReport();
                    break;

                case 3:
                    appointmentReport();
                    break;

                case 4:
                    billingReport();
                    break;

                case 5:
                    hospitalSummary();
                    break;

                case 6:
                    return;

                default:
                    System.out.println("\nInvalid choice. Try again.");
            }
        }
    }

    public static void addPatient() {

        System.out.println("\n----- ADD PATIENT -----");

        System.out.print("Patient ID: ");
        String id = scanner.nextLine();

        if (patientService.findPatientById(id) != null) {
            System.out.println("\nPatient ID already exists.");
            return;
        }

        System.out.print("Name: ");
        String name = scanner.nextLine();

        System.out.print("Age: ");

        int age;

        try {
            age = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("\nInvalid age.");
            return;
        }

        System.out.print("Gender: ");
        String gender = scanner.nextLine();

        System.out.print("Phone: ");
        String phone = scanner.nextLine();

        Patient patient = new Patient(
                id,
                name,
                age,
                gender,
                phone
        );

        if (patientService.addPatient(patient)) {
            System.out.println("\nPatient added successfully!");
        } else {
            System.out.println("\nPatient could not be added.");
        }
    }

    public static void viewPatients() {

        System.out.println("\n----- ALL PATIENTS -----");

        List<Patient> patients = patientService.getAllPatients();

        if (patients.isEmpty()) {
            System.out.println("No patients found.");
            return;
        }

        for (Patient patient : patients) {
            System.out.println("\n------------------------");
            System.out.println(patient);
        }

        System.out.println("------------------------");
    }

    public static void searchPatient() {

        System.out.print("\nEnter Patient ID: ");
        String id = scanner.nextLine();

        Patient patient = patientService.findPatientById(id);

        if (patient == null) {
            System.out.println("\nPatient not found.");
        } else {
            System.out.println("\nPatient Found!");
            System.out.println("------------------------");
            System.out.println(patient);
        }
    }

    public static void updatePatient() {

        System.out.print("\nEnter Patient ID: ");
        String id = scanner.nextLine();

        Patient patient = patientService.findPatientById(id);

        if (patient == null) {
            System.out.println("\nPatient not found.");
            return;
        }

        System.out.print("New Name: ");
        String name = scanner.nextLine();

        System.out.print("New Age: ");

        int age;

        try {
            age = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("\nInvalid age.");
            return;
        }

        System.out.print("New Gender: ");
        String gender = scanner.nextLine();

        System.out.print("New Phone: ");
        String phone = scanner.nextLine();

        if (patientService.updatePatient(
                id,
                name,
                age,
                gender,
                phone
        )) {
            System.out.println("\nPatient updated successfully!");
        } else {
            System.out.println("\nPatient could not be updated.");
        }
    }

    public static void deletePatient() {

        System.out.print("\nEnter Patient ID: ");
        String id = scanner.nextLine();

        Patient patient = patientService.findPatientById(id);

        if (patient == null) {
            System.out.println("\nPatient not found.");
            return;
        }

        System.out.println("\nPatient to delete:");
        System.out.println(patient);

        System.out.print("\nAre you sure? (Y/N): ");
        String confirmation = scanner.nextLine();

        if (confirmation.equalsIgnoreCase("Y")) {

            if (patientService.deletePatient(id)) {
                System.out.println("\nPatient deleted successfully!");
            } else {
                System.out.println("\nPatient could not be deleted.");
            }

        } else {
            System.out.println("\nDelete operation cancelled.");
        }
    }

    public static void addDoctor() {

        System.out.println("\n----- ADD DOCTOR -----");

        System.out.print("Doctor ID: ");
        String id = scanner.nextLine();

        if (doctorService.findDoctorById(id) != null) {
            System.out.println("\nDoctor ID already exists.");
            return;
        }

        System.out.print("Name: ");
        String name = scanner.nextLine();

        System.out.print("Specialization: ");
        String specialization = scanner.nextLine();

        System.out.print("Consultation Fee: ");

        double fee;

        try {
            fee = Double.parseDouble(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("\nInvalid consultation fee.");
            return;
        }

        Doctor doctor = new Doctor(
                id,
                name,
                specialization,
                fee
        );

        if (doctorService.addDoctor(doctor)) {
            System.out.println("\nDoctor added successfully!");
        } else {
            System.out.println("\nDoctor could not be added.");
        }
    }

    public static void viewDoctors() {

        System.out.println("\n----- ALL DOCTORS -----");

        List<Doctor> doctors = doctorService.getAllDoctors();

        if (doctors.isEmpty()) {
            System.out.println("No doctors found.");
            return;
        }

        for (Doctor doctor : doctors) {
            System.out.println("\n------------------------");
            System.out.println(doctor);
        }

        System.out.println("------------------------");
    }

    public static void searchDoctor() {

        System.out.print("\nEnter Doctor ID: ");
        String id = scanner.nextLine();

        Doctor doctor = doctorService.findDoctorById(id);

        if (doctor == null) {
            System.out.println("\nDoctor not found.");
        } else {
            System.out.println("\nDoctor Found!");
            System.out.println("------------------------");
            System.out.println(doctor);
        }
    }

    public static void updateDoctor() {

        System.out.print("\nEnter Doctor ID: ");
        String id = scanner.nextLine();

        Doctor doctor = doctorService.findDoctorById(id);

        if (doctor == null) {
            System.out.println("\nDoctor not found.");
            return;
        }

        System.out.print("New Name: ");
        String name = scanner.nextLine();

        System.out.print("New Specialization: ");
        String specialization = scanner.nextLine();

        System.out.print("New Consultation Fee: ");

        double fee;

        try {
            fee = Double.parseDouble(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("\nInvalid consultation fee.");
            return;
        }

        if (doctorService.updateDoctor(
                id,
                name,
                specialization,
                fee
        )) {
            System.out.println("\nDoctor updated successfully!");
        } else {
            System.out.println("\nDoctor could not be updated.");
        }
    }

    public static void deleteDoctor() {

        System.out.print("\nEnter Doctor ID: ");
        String id = scanner.nextLine();

        Doctor doctor = doctorService.findDoctorById(id);

        if (doctor == null) {
            System.out.println("\nDoctor not found.");
            return;
        }

        System.out.println("\nDoctor to delete:");
        System.out.println(doctor);

        System.out.print("\nAre you sure? (Y/N): ");
        String confirmation = scanner.nextLine();

        if (confirmation.equalsIgnoreCase("Y")) {

            if (doctorService.deleteDoctor(id)) {
                System.out.println("\nDoctor deleted successfully!");
            } else {
                System.out.println("\nDoctor could not be deleted.");
            }

        } else {
            System.out.println("\nDelete operation cancelled.");
        }
    }

    public static void addAppointment() {

        System.out.println("\n----- ADD APPOINTMENT -----");

        System.out.print("Appointment ID: ");
        String appointmentId = scanner.nextLine();

        if (appointmentService.findAppointmentById(appointmentId) != null) {
            System.out.println("\nAppointment ID already exists.");
            return;
        }

        System.out.print("Patient ID: ");
        String patientId = scanner.nextLine();

        if (patientService.findPatientById(patientId) == null) {
            System.out.println("\nPatient not found.");
            return;
        }

        System.out.print("Doctor ID: ");
        String doctorId = scanner.nextLine();

        if (doctorService.findDoctorById(doctorId) == null) {
            System.out.println("\nDoctor not found.");
            return;
        }

        System.out.print("Date (YYYY-MM-DD): ");

        LocalDate date;

        try {
            date = LocalDate.parse(scanner.nextLine());
        } catch (RuntimeException e) {
            System.out.println("\nInvalid date format.");
            return;
        }

        System.out.print("Time (HH:MM): ");

        LocalTime time;

        try {
            time = LocalTime.parse(scanner.nextLine());
        } catch (RuntimeException e) {
            System.out.println("\nInvalid time format.");
            return;
        }

        Appointment appointment = new Appointment(
                appointmentId,
                patientId,
                doctorId,
                date,
                time
        );

        if (appointmentService.addAppointment(appointment)) {
            System.out.println("\nAppointment booked successfully!");
        } else {
            System.out.println("\nAppointment could not be booked.");
            System.out.println(
                    "Doctor may already have an appointment at this time."
            );
        }
    }

    public static void viewAppointments() {

        System.out.println("\n----- ALL APPOINTMENTS -----");

        List<Appointment> appointments =
                appointmentService.getAllAppointments();

        if (appointments.isEmpty()) {
            System.out.println("No appointments found.");
            return;
        }

        for (Appointment appointment : appointments) {
            System.out.println("\n------------------------");
            System.out.println(appointment);
        }

        System.out.println("------------------------");
    }

    public static void searchAppointment() {

        System.out.print("\nEnter Appointment ID: ");
        String id = scanner.nextLine();

        Appointment appointment =
                appointmentService.findAppointmentById(id);

        if (appointment == null) {
            System.out.println("\nAppointment not found.");
        } else {
            System.out.println("\nAppointment Found!");
            System.out.println("------------------------");
            System.out.println(appointment);
        }
    }

    public static void cancelAppointment() {

        System.out.print("\nEnter Appointment ID: ");
        String id = scanner.nextLine();

        Appointment appointment =
                appointmentService.findAppointmentById(id);

        if (appointment == null) {
            System.out.println("\nAppointment not found.");
            return;
        }

        System.out.println("\nAppointment to cancel:");
        System.out.println("------------------------");
        System.out.println(appointment);

        System.out.print("\nAre you sure? (Y/N): ");
        String confirmation = scanner.nextLine();

        if (confirmation.equalsIgnoreCase("Y")) {

            if (appointmentService.cancelAppointment(id)) {
                System.out.println(
                        "\nAppointment cancelled successfully!"
                );
            } else {
                System.out.println(
                        "\nAppointment is already cancelled."
                );
            }

        } else {
            System.out.println("\nCancellation aborted.");
        }
    }

    public static void generateBill() {

        System.out.println("\n----- GENERATE BILL -----");

        System.out.print("Bill ID: ");
        String billId = scanner.nextLine();

        if (billService.findBillById(billId) != null) {
            System.out.println("\nBill ID already exists.");
            return;
        }

        System.out.print("Patient ID: ");
        String patientId = scanner.nextLine();

        if (patientService.findPatientById(patientId) == null) {
            System.out.println("\nPatient not found.");
            return;
        }

        double consultationFee = 0;

        for (Appointment appointment :
                appointmentService.getAllAppointments()) {

            if (appointment.getPatientId()
                    .equalsIgnoreCase(patientId)
                    && appointment.getStatus()
                    .equalsIgnoreCase("BOOKED")) {

                Doctor doctor =
                        doctorService.findDoctorById(
                                appointment.getDoctorId()
                        );

                if (doctor != null) {
                    consultationFee =
                            doctor.getConsultationFee();
                    break;
                }
            }
        }

        if (consultationFee == 0) {

            System.out.print("Consultation Fee: ");

            try {
                consultationFee =
                        Double.parseDouble(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println(
                        "\nInvalid consultation fee."
                );
                return;
            }

        } else {

            System.out.println(
                    "Consultation Fee: " + consultationFee
            );
        }

        System.out.print("Medicine Charges: ");

        double medicineCharges;

        try {
            medicineCharges =
                    Double.parseDouble(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("\nInvalid medicine charges.");
            return;
        }

        System.out.print("Test Charges: ");

        double testCharges;

        try {
            testCharges =
                    Double.parseDouble(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("\nInvalid test charges.");
            return;
        }

        Bill bill = new Bill(
                billId,
                patientId,
                consultationFee,
                medicineCharges,
                testCharges
        );

        if (billService.addBill(bill)) {

            System.out.println("\nBill generated successfully!");
            System.out.println("------------------------");
            System.out.println(bill);

        } else {

            System.out.println("\nBill could not be generated.");
        }
    }

    public static void viewBills() {

        System.out.println("\n----- ALL BILLS -----");

        List<Bill> bills = billService.getAllBills();

        if (bills.isEmpty()) {
            System.out.println("No bills found.");
            return;
        }

        for (Bill bill : bills) {
            System.out.println("\n------------------------");
            System.out.println(bill);
        }

        System.out.println("------------------------");
    }

    public static void searchBill() {

        System.out.print("\nEnter Bill ID: ");
        String id = scanner.nextLine();

        Bill bill = billService.findBillById(id);

        if (bill == null) {
            System.out.println("\nBill not found.");
        } else {
            System.out.println("\nBill Found!");
            System.out.println("------------------------");
            System.out.println(bill);
        }
    }

    public static void patientReport() {

        List<Patient> patients =
                patientService.getAllPatients();

        System.out.println("\n----- PATIENT REPORT -----");
        System.out.println("Total Patients: " + patients.size());

        if (patients.isEmpty()) {
            System.out.println("No patient records available.");
            return;
        }

        System.out.println("\nPatient Records:");

        for (Patient patient : patients) {

            System.out.println("------------------------");
            System.out.println("ID: " + patient.getPatientId());
            System.out.println("Name: " + patient.getName());
            System.out.println("Age: " + patient.getAge());
            System.out.println("Gender: " + patient.getGender());
        }
    }

    public static void doctorReport() {

        List<Doctor> doctors =
                doctorService.getAllDoctors();

        System.out.println("\n----- DOCTOR REPORT -----");
        System.out.println("Total Doctors: " + doctors.size());

        if (doctors.isEmpty()) {
            System.out.println("No doctor records available.");
            return;
        }

        System.out.println("\nDoctor Records:");

        for (Doctor doctor : doctors) {

            System.out.println("------------------------");
            System.out.println("ID: " + doctor.getDoctorId());
            System.out.println("Name: Dr. " + doctor.getName());
            System.out.println(
                    "Specialization: "
                            + doctor.getSpecialization()
            );
            System.out.println(
                    "Consultation Fee: "
                            + doctor.getConsultationFee()
            );
        }
    }

    public static void appointmentReport() {

        List<Appointment> appointments =
                appointmentService.getAllAppointments();

        int booked = 0;
        int cancelled = 0;

        for (Appointment appointment : appointments) {

            if (appointment.getStatus()
                    .equalsIgnoreCase("BOOKED")) {

                booked++;

            } else if (appointment.getStatus()
                    .equalsIgnoreCase("CANCELLED")) {

                cancelled++;
            }
        }

        System.out.println("\n----- APPOINTMENT REPORT -----");
        System.out.println(
                "Total Appointments: "
                        + appointments.size()
        );
        System.out.println(
                "Booked Appointments: " + booked
        );
        System.out.println(
                "Cancelled Appointments: " + cancelled
        );
    }

    public static void billingReport() {

        List<Bill> bills =
                billService.getAllBills();

        double totalRevenue = 0;

        for (Bill bill : bills) {
            totalRevenue += bill.calculateTotal();
        }

        System.out.println("\n----- BILLING REPORT -----");
        System.out.println("Total Bills: " + bills.size());
        System.out.println(
                "Total Revenue: " + totalRevenue
        );
    }

    public static void hospitalSummary() {

        List<Patient> patients =
                patientService.getAllPatients();

        List<Doctor> doctors =
                doctorService.getAllDoctors();

        List<Appointment> appointments =
                appointmentService.getAllAppointments();

        List<Bill> bills =
                billService.getAllBills();

        int booked = 0;
        int cancelled = 0;
        double totalRevenue = 0;

        for (Appointment appointment : appointments) {

            if (appointment.getStatus()
                    .equalsIgnoreCase("BOOKED")) {

                booked++;

            } else if (appointment.getStatus()
                    .equalsIgnoreCase("CANCELLED")) {

                cancelled++;
            }
        }

        for (Bill bill : bills) {
            totalRevenue += bill.calculateTotal();
        }

        System.out.println("\n========================================");
        System.out.println("          HOSPITAL SUMMARY");
        System.out.println("========================================");
        System.out.println(
                "Total Patients        : " + patients.size()
        );
        System.out.println(
                "Total Doctors         : " + doctors.size()
        );
        System.out.println(
                "Total Appointments    : "
                        + appointments.size()
        );
        System.out.println(
                "Booked Appointments   : " + booked
        );
        System.out.println(
                "Cancelled Appointments: " + cancelled
        );
        System.out.println(
                "Total Bills           : " + bills.size()
        );
        System.out.println(
                "Total Revenue         : " + totalRevenue
        );
        System.out.println("========================================");
    }
}