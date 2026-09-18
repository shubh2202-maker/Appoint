package service;

import model.Doctor;
import storage.FileManager;

import java.util.ArrayList;
import java.util.List;

public class DoctorService {

    private List<Doctor> doctors;

    public DoctorService() {
        doctors = new ArrayList<>();
        loadDoctors();
    }

    private void loadDoctors() {
        doctors = FileManager.loadDoctors();
    }

    public boolean addDoctor(Doctor doctor) {

        if (findDoctorById(doctor.getDoctorId()) != null) {
            return false;
        }

        doctors.add(doctor);
        FileManager.saveDoctor(doctor);

        return true;
    }

    public List<Doctor> getAllDoctors() {
        return new ArrayList<>(doctors);
    }

    public Doctor findDoctorById(String doctorId) {

        for (Doctor doctor : doctors) {

            if (doctor.getDoctorId().equalsIgnoreCase(doctorId)) {
                return doctor;
            }
        }

        return null;
    }

    public boolean updateDoctor(String doctorId,
                                 String name,
                                 String specialization,
                                 double consultationFee) {

        Doctor doctor = findDoctorById(doctorId);

        if (doctor == null) {
            return false;
        }

        doctor.setName(name);
        doctor.setSpecialization(specialization);
        doctor.setConsultationFee(consultationFee);

        saveAllDoctors();

        return true;
    }

    public boolean deleteDoctor(String doctorId) {

        Doctor doctor = findDoctorById(doctorId);

        if (doctor == null) {
            return false;
        }

        doctors.remove(doctor);
        saveAllDoctors();

        return true;
    }

    private void saveAllDoctors() {
        FileManager.overwriteDoctors(doctors);
    }
}