package model;

public class Patient {

    private String patientId;
    private String name;
    private int age;
    private String gender;
    private String phone;

    public Patient(String patientId, String name, int age,
                   String gender, String phone) {
        this.patientId = patientId;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.phone = phone;
    }

    public String getPatientId() {
        return patientId;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getGender() {
        return gender;
    }

    public String getPhone() {
        return phone;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "Patient ID: " + patientId +
                "\nName: " + name +
                "\nAge: " + age +
                "\nGender: " + gender +
                "\nPhone: " + phone;
    }
}