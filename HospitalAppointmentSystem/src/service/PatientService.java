package service;

import model.Patient;
import storage.FileManager;

import java.util.ArrayList;
import java.util.List;

public class PatientService {

    private List<Patient> patients;

    public PatientService() {
        patients = new ArrayList<>();
        loadPatients();
    }

    // Load patients from file
    private void loadPatients() {
        patients = FileManager.loadPatients();
    }

    // Add a new patient
    public boolean addPatient(Patient patient) {

        if (findPatientById(patient.getPatientId()) != null) {
            return false;
        }

        patients.add(patient);
        FileManager.savePatient(patient);

        return true;
    }

    // View all patients
    public List<Patient> getAllPatients() {
        return new ArrayList<>(patients);
    }

    // Search patient by ID
    public Patient findPatientById(String patientId) {

        for (Patient patient : patients) {

            if (patient.getPatientId().equalsIgnoreCase(patientId)) {
                return patient;
            }
        }

        return null;
    }

    // Update patient details
    public boolean updatePatient(String patientId,
                                  String name,
                                  int age,
                                  String gender,
                                  String phone) {

        Patient patient = findPatientById(patientId);

        if (patient == null) {
            return false;
        }

        patient.setName(name);
        patient.setAge(age);
        patient.setGender(gender);
        patient.setPhone(phone);

        saveAllPatients();

        return true;
    }

    // Delete patient
    public boolean deletePatient(String patientId) {

        Patient patient = findPatientById(patientId);

        if (patient == null) {
            return false;
        }

        patients.remove(patient);
        saveAllPatients();

        return true;
    }

    // Rewrite patient file after update/delete
    private void saveAllPatients() {

        FileManager.overwritePatients(patients);
    }
}