package storage;

import java.io.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import model.*;

public class FileManager {

    private static final String DATA_FOLDER = "data";

    private static final String PATIENT_FILE =
            DATA_FOLDER + File.separator + "Patient.txt";

    private static final String DOCTOR_FILE =
            DATA_FOLDER + File.separator + "Doctor.txt";

    private static final String APPOINTMENT_FILE =
            DATA_FOLDER + File.separator + "Appointment.txt";

    private static final String BILL_FILE =
            DATA_FOLDER + File.separator + "Bill.txt";

    public static void initializeDataFolder() {

        File folder = new File(DATA_FOLDER);

        if (!folder.exists()) {
            folder.mkdirs();
        }
    }

    public static void savePatient(Patient patient) {

        initializeDataFolder();

        try (BufferedWriter writer =
                     new BufferedWriter(new FileWriter(PATIENT_FILE, true))) {

            writer.write(
                    patient.getPatientId() + "|" +
                    patient.getName() + "|" +
                    patient.getAge() + "|" +
                    patient.getGender() + "|" +
                    patient.getPhone()
            );

            writer.newLine();

        } catch (IOException e) {
            System.out.println("Error saving patient: " + e.getMessage());
        }
    }

    public static List<Patient> loadPatients() {

        List<Patient> patients = new ArrayList<>();

        File file = new File(PATIENT_FILE);

        if (!file.exists()) {
            return patients;
        }

        try (BufferedReader reader =
                     new BufferedReader(new FileReader(file))) {

            String line;

            while ((line = reader.readLine()) != null) {

                if (line.trim().isEmpty()) {
                    continue;
                }

                String[] data = line.split("\\|");

                if (data.length == 5) {

                    Patient patient = new Patient(
                            data[0],
                            data[1],
                            Integer.parseInt(data[2]),
                            data[3],
                            data[4]
                    );

                    patients.add(patient);
                }
            }

        } catch (IOException | NumberFormatException e) {
            System.out.println("Error loading patients: " + e.getMessage());
        }

        return patients;
    }

    public static void overwritePatients(List<Patient> patients) {

        initializeDataFolder();

        try (BufferedWriter writer =
                     new BufferedWriter(new FileWriter(PATIENT_FILE))) {

            for (Patient patient : patients) {

                writer.write(
                        patient.getPatientId() + "|" +
                        patient.getName() + "|" +
                        patient.getAge() + "|" +
                        patient.getGender() + "|" +
                        patient.getPhone()
                );

                writer.newLine();
            }

        } catch (IOException e) {
            System.out.println(
                    "Error updating patient data: " + e.getMessage()
            );
        }
    }

    public static void saveDoctor(Doctor doctor) {

        initializeDataFolder();

        try (BufferedWriter writer =
                     new BufferedWriter(new FileWriter(DOCTOR_FILE, true))) {

            writer.write(
                    doctor.getDoctorId() + "|" +
                    doctor.getName() + "|" +
                    doctor.getSpecialization() + "|" +
                    doctor.getConsultationFee()
            );

            writer.newLine();

        } catch (IOException e) {
            System.out.println("Error saving doctor: " + e.getMessage());
        }
    }

    public static List<Doctor> loadDoctors() {

        List<Doctor> doctors = new ArrayList<>();

        File file = new File(DOCTOR_FILE);

        if (!file.exists()) {
            return doctors;
        }

        try (BufferedReader reader =
                     new BufferedReader(new FileReader(file))) {

            String line;

            while ((line = reader.readLine()) != null) {

                if (line.trim().isEmpty()) {
                    continue;
                }

                String[] data = line.split("\\|");

                if (data.length == 4) {

                    Doctor doctor = new Doctor(
                            data[0],
                            data[1],
                            data[2],
                            Double.parseDouble(data[3])
                    );

                    doctors.add(doctor);
                }
            }

        } catch (IOException | NumberFormatException e) {
            System.out.println("Error loading doctors: " + e.getMessage());
        }

        return doctors;
    }

    public static void overwriteDoctors(List<Doctor> doctors) {

        initializeDataFolder();

        try (BufferedWriter writer =
                     new BufferedWriter(new FileWriter(DOCTOR_FILE))) {

            for (Doctor doctor : doctors) {

                writer.write(
                        doctor.getDoctorId() + "|" +
                        doctor.getName() + "|" +
                        doctor.getSpecialization() + "|" +
                        doctor.getConsultationFee()
                );

                writer.newLine();
            }

        } catch (IOException e) {
            System.out.println(
                    "Error updating doctor data: " + e.getMessage()
            );
        }
    }

    public static void saveAppointment(Appointment appointment) {

        initializeDataFolder();

        try (BufferedWriter writer =
                     new BufferedWriter(
                             new FileWriter(APPOINTMENT_FILE, true))) {

            writer.write(
                    appointment.getAppointmentId() + "|" +
                    appointment.getPatientId() + "|" +
                    appointment.getDoctorId() + "|" +
                    appointment.getDate() + "|" +
                    appointment.getTime() + "|" +
                    appointment.getStatus()
            );

            writer.newLine();

        } catch (IOException e) {
            System.out.println(
                    "Error saving appointment: " + e.getMessage()
            );
        }
    }

    public static List<Appointment> loadAppointments() {

        List<Appointment> appointments = new ArrayList<>();

        File file = new File(APPOINTMENT_FILE);

        if (!file.exists()) {
            return appointments;
        }

        try (BufferedReader reader =
                     new BufferedReader(new FileReader(file))) {

            String line;

            while ((line = reader.readLine()) != null) {

                if (line.trim().isEmpty()) {
                    continue;
                }

                String[] data = line.split("\\|");

                if (data.length == 6) {

                    Appointment appointment = new Appointment(
                            data[0],
                            data[1],
                            data[2],
                            LocalDate.parse(data[3]),
                            LocalTime.parse(data[4])
                    );

                    if (data[5].equalsIgnoreCase("CANCELLED")) {
                        appointment.cancelAppointment();
                    }

                    appointments.add(appointment);
                }
            }

        } catch (IOException | RuntimeException e) {
            System.out.println(
                    "Error loading appointments: " + e.getMessage()
            );
        }

        return appointments;
    }

    public static void saveBill(Bill bill) {

        initializeDataFolder();

        try (BufferedWriter writer =
                     new BufferedWriter(new FileWriter(BILL_FILE, true))) {

            writer.write(
                    bill.getBillId() + "|" +
                    bill.getPatientId() + "|" +
                    bill.getConsultationFee() + "|" +
                    bill.getMedicineCharges() + "|" +
                    bill.getTestCharges()
            );

            writer.newLine();

        } catch (IOException e) {
            System.out.println("Error saving bill: " + e.getMessage());
        }
    }

    public static List<Bill> loadBills() {

        List<Bill> bills = new ArrayList<>();

        File file = new File(BILL_FILE);

        if (!file.exists()) {
            return bills;
        }

        try (BufferedReader reader =
                     new BufferedReader(new FileReader(file))) {

            String line;

            while ((line = reader.readLine()) != null) {

                if (line.trim().isEmpty()) {
                    continue;
                }

                String[] data = line.split("\\|");

                if (data.length == 5) {

                    Bill bill = new Bill(
                            data[0],
                            data[1],
                            Double.parseDouble(data[2]),
                            Double.parseDouble(data[3]),
                            Double.parseDouble(data[4])
                    );

                    bills.add(bill);
                }
            }

        } catch (IOException | NumberFormatException e) {
            System.out.println("Error loading bills: " + e.getMessage());
        }

        return bills;
    }
}