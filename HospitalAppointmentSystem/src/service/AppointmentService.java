package service;

import model.Appointment;
import storage.FileManager;

import java.util.ArrayList;
import java.util.List;

public class AppointmentService {

    private List<Appointment> appointments;

    public AppointmentService() {
        appointments = new ArrayList<>();
        loadAppointments();
    }

    private void loadAppointments() {
        appointments = FileManager.loadAppointments();
    }

    public boolean addAppointment(Appointment appointment) {

        if (findAppointmentById(appointment.getAppointmentId()) != null) {
            return false;
        }

        for (Appointment existing : appointments) {

            if (existing.getDoctorId().equalsIgnoreCase(appointment.getDoctorId())
                    && existing.getDate().equals(appointment.getDate())
                    && existing.getTime().equals(appointment.getTime())
                    && existing.getStatus().equalsIgnoreCase("BOOKED")) {

                return false;
            }
        }

        appointments.add(appointment);
        FileManager.saveAppointment(appointment);

        return true;
    }

    public List<Appointment> getAllAppointments() {
        return new ArrayList<>(appointments);
    }

    public Appointment findAppointmentById(String appointmentId) {

        for (Appointment appointment : appointments) {

            if (appointment.getAppointmentId()
                    .equalsIgnoreCase(appointmentId)) {

                return appointment;
            }
        }

        return null;
    }

    public boolean cancelAppointment(String appointmentId) {

        Appointment appointment = findAppointmentById(appointmentId);

        if (appointment == null) {
            return false;
        }

        if (appointment.getStatus().equalsIgnoreCase("CANCELLED")) {
            return false;
        }

        appointment.cancelAppointment();

        saveAllAppointments();

        return true;
    }

    private void saveAllAppointments() {

        FileManager.initializeDataFolder();

        try (java.io.BufferedWriter writer =
                     new java.io.BufferedWriter(
                             new java.io.FileWriter(
                                     "data" + java.io.File.separator
                                             + "Appointment.txt"))) {

            for (Appointment appointment : appointments) {

                writer.write(
                        appointment.getAppointmentId() + "|" +
                        appointment.getPatientId() + "|" +
                        appointment.getDoctorId() + "|" +
                        appointment.getDate() + "|" +
                        appointment.getTime() + "|" +
                        appointment.getStatus()
                );

                writer.newLine();
            }

        } catch (java.io.IOException e) {

            System.out.println(
                    "Error updating appointment data: "
                            + e.getMessage()
            );
        }
    }
}