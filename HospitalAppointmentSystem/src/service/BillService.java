package service;

import model.Bill;
import storage.FileManager;

import java.util.ArrayList;
import java.util.List;

public class BillService {

    private List<Bill> bills;

    public BillService() {
        bills = new ArrayList<>();
        loadBills();
    }

    private void loadBills() {
        bills = FileManager.loadBills();
    }

    public boolean addBill(Bill bill) {

        if (findBillById(bill.getBillId()) != null) {
            return false;
        }

        bills.add(bill);
        FileManager.saveBill(bill);

        return true;
    }

    public List<Bill> getAllBills() {
        return new ArrayList<>(bills);
    }

    public Bill findBillById(String billId) {

        for (Bill bill : bills) {

            if (bill.getBillId().equalsIgnoreCase(billId)) {
                return bill;
            }
        }

        return null;
    }
}