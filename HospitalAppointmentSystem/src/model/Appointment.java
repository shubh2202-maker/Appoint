package model;

import java.time.LocalDate;
import java.time.LocalTime;

public class Appointment {

    private String appointmentId;
    private String patientId;
    private String doctorId;
    private LocalDate date;
    private LocalTime time;
    private String status;

    public Appointment(String appointmentId,
                       String patientId,
                       String doctorId,
                       LocalDate date,
                       LocalTime time) {

        this.appointmentId = appointmentId;
        this.patientId = patientId;
        this.doctorId = doctorId;
        this.date = date;
        this.time = time;
        this.status = "BOOKED";
    }

    public String getAppointmentId() {
        return appointmentId;
    }

    public String getPatientId() {
        return patientId;
    }

    public String getDoctorId() {
        return doctorId;
    }

    public LocalDate getDate() {
        return date;
    }

    public LocalTime getTime() {
        return time;
    }

    public String getStatus() {
        return status;
    }

    public void cancelAppointment() {
        status = "CANCELLED";
    }

    @Override
    public String toString() {
        return "Appointment ID: " + appointmentId +
                "\nPatient ID: " + patientId +
                "\nDoctor ID: " + doctorId +
                "\nDate: " + date +
                "\nTime: " + time +
                "\nStatus: " + status;
    }
}