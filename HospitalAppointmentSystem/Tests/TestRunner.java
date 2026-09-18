import model.Appointment;
import model.Bill;
import model.Doctor;
import model.Patient;

import service.AppointmentService;
import service.BillService;
import service.DoctorService;
import service.PatientService;

import java.time.LocalDate;
import java.time.LocalTime;

public class TestRunner {

    private static int passed = 0;
    private static int failed = 0;

    public static void main(String[] args) {

        System.out.println("========================================");
        System.out.println("       HOSPITAL SYSTEM TEST RUNNER");
        System.out.println("========================================");

        testPatient();
        testDoctor();
        testAppointment();
        testBill();

        System.out.println("\n========================================");
        System.out.println("              TEST RESULT");
        System.out.println("========================================");
        System.out.println("Tests Passed : " + passed);
        System.out.println("Tests Failed : " + failed);
        System.out.println("Total Tests  : " + (passed + failed));
        System.out.println("========================================");

        if (failed == 0) {
            System.out.println("ALL TESTS PASSED!");
        } else {
            System.out.println("SOME TESTS FAILED.");
        }
    }

    private static void testPatient() {

        System.out.println("\n----- PATIENT TESTS -----");

        PatientService service = new PatientService();

        String id = "TEST_P001";

        Patient existing = service.findPatientById(id);

        if (existing != null) {
            service.deletePatient(id);
        }

        Patient patient = new Patient(
                id,
                "Test Patient",
                20,
                "Male",
                "9999999999"
        );

        check(
                service.addPatient(patient),
                "Patient can be added"
        );

        check(
                service.findPatientById(id) != null,
                "Patient can be searched"
        );

        check(
                service.findPatientById(id)
                        .getName()
                        .equals("Test Patient"),
                "Patient data is stored correctly"
        );

        check(
                !service.addPatient(patient),
                "Duplicate patient ID is rejected"
        );

        check(
                service.updatePatient(
                        id,
                        "Updated Patient",
                        21,
                        "Male",
                        "8888888888"
                ),
                "Patient can be updated"
        );

        check(
                service.findPatientById(id)
                        .getName()
                        .equals("Updated Patient"),
                "Updated patient data is correct"
        );

        check(
                service.deletePatient(id),
                "Patient can be deleted"
        );
    }

    private static void testDoctor() {

        System.out.println("\n----- DOCTOR TESTS -----");

        DoctorService service = new DoctorService();

        String id = "TEST_D001";

        Doctor existing = service.findDoctorById(id);

        if (existing != null) {
            service.deleteDoctor(id);
        }

        Doctor doctor = new Doctor(
                id,
                "Test Doctor",
                "Cardiology",
                1000
        );

        check(
                service.addDoctor(doctor),
                "Doctor can be added"
        );

        check(
                service.findDoctorById(id) != null,
                "Doctor can be searched"
        );

        check(
                service.findDoctorById(id)
                        .getSpecialization()
                        .equals("Cardiology"),
                "Doctor data is stored correctly"
        );

        check(
                !service.addDoctor(doctor),
                "Duplicate doctor ID is rejected"
        );

        check(
                service.updateDoctor(
                        id,
                        "Updated Doctor",
                        "Neurology",
                        1500
                ),
                "Doctor can be updated"
        );

        check(
                service.findDoctorById(id)
                        .getConsultationFee() == 1500,
                "Updated doctor data is correct"
        );

        check(
                service.deleteDoctor(id),
                "Doctor can be deleted"
        );
    }

    private static void testAppointment() {

        System.out.println("\n----- APPOINTMENT TESTS -----");

        PatientService patientService = new PatientService();
        DoctorService doctorService = new DoctorService();
        AppointmentService appointmentService =
                new AppointmentService();

        String patientId = "TEST_AP001";
        String doctorId = "TEST_AD001";
        String appointmentId = "TEST_A001";
        String duplicateId = "TEST_A002";

        Patient oldPatient =
                patientService.findPatientById(patientId);

        if (oldPatient != null) {
            patientService.deletePatient(patientId);
        }

        Doctor oldDoctor =
                doctorService.findDoctorById(doctorId);

        if (oldDoctor != null) {
            doctorService.deleteDoctor(doctorId);
        }

        Appointment oldAppointment =
                appointmentService.findAppointmentById(
                        appointmentId
                );

        if (oldAppointment != null) {
            appointmentService.cancelAppointment(appointmentId);
        }

        Patient patient = new Patient(
                patientId,
                "Appointment Patient",
                25,
                "Male",
                "7777777777"
        );

        Doctor doctor = new Doctor(
                doctorId,
                "Appointment Doctor",
                "General Medicine",
                800
        );

        patientService.addPatient(patient);
        doctorService.addDoctor(doctor);

        Appointment appointment = new Appointment(
                appointmentId,
                patientId,
                doctorId,
                LocalDate.of(2026, 12, 10),
                LocalTime.of(10, 30)
        );

        check(
                appointmentService.addAppointment(appointment),
                "Appointment can be booked"
        );

        check(
                appointmentService.findAppointmentById(
                        appointmentId
                ) != null,
                "Appointment can be searched"
        );

        Appointment duplicateAppointment =
                new Appointment(
                        duplicateId,
                        patientId,
                        doctorId,
                        LocalDate.of(2026, 12, 10),
                        LocalTime.of(10, 30)
                );

        check(
                !appointmentService.addAppointment(
                        duplicateAppointment
                ),
                "Doctor time-slot conflict is prevented"
        );

        check(
                appointmentService.cancelAppointment(
                        appointmentId
                ),
                "Appointment can be cancelled"
        );

        check(
                appointmentService.findAppointmentById(
                        appointmentId
                ).getStatus().equals("CANCELLED"),
                "Appointment status changes to CANCELLED"
        );

        patientService.deletePatient(patientId);
        doctorService.deleteDoctor(doctorId);
    }

    private static void testBill() {

        System.out.println("\n----- BILL TESTS -----");

        BillService service = new BillService();

        String id = "TEST_B001";

        Bill existing = service.findBillById(id);

        if (existing != null) {
            System.out.println(
                    "Existing test bill found. Skipping duplicate ID test."
            );
        }

        Bill bill = new Bill(
                id,
                "TEST_P001",
                1000,
                500,
                300
        );

        check(
                service.addBill(bill),
                "Bill can be generated"
        );

        check(
                service.findBillById(id) != null,
                "Bill can be searched"
        );

        check(
                bill.calculateTotal() == 1800,
                "Bill total is calculated correctly"
        );

        check(
                !service.addBill(bill),
                "Duplicate bill ID is rejected"
        );
    }

    private static void check(
            boolean condition,
            String testName
    ) {

        if (condition) {

            System.out.println("[PASS] " + testName);
            passed++;

        } else {

            System.out.println("[FAIL] " + testName);
            failed++;
        }
    }
}