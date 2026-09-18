package model;

public class Bill {

    private String billId;
    private String patientId;
    private double consultationFee;
    private double medicineCharges;
    private double testCharges;

    public Bill(String billId,
                String patientId,
                double consultationFee,
                double medicineCharges,
                double testCharges) {

        this.billId = billId;
        this.patientId = patientId;
        this.consultationFee = consultationFee;
        this.medicineCharges = medicineCharges;
        this.testCharges = testCharges;
    }

    public double calculateTotal() {
        return consultationFee + medicineCharges + testCharges;
    }

    public String getBillId() {
        return billId;
    }

    public String getPatientId() {
        return patientId;
    }

    public double getConsultationFee() {
        return consultationFee;
    }

    public double getMedicineCharges() {
        return medicineCharges;
    }

    public double getTestCharges() {
        return testCharges;
    }

    @Override
    public String toString() {
        return "Bill ID: " + billId +
                "\nPatient ID: " + patientId +
                "\nConsultation Fee: ₹" + consultationFee +
                "\nMedicine Charges: ₹" + medicineCharges +
                "\nTest Charges: ₹" + testCharges +
                "\n------------------------" +
                "\nTotal: ₹" + calculateTotal();
    }
}