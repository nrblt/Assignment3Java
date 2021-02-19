package com.company;


import com.company.controllers.MedCon;
import com.company.data.DBManager;
import com.company.data.interfaces.IDBManager;
import com.company.reps.MedicineRepositories;
import com.company.reps.interfaces.IMedicineRepositories;

public class Main {
    public static void main(String[] args) {
        IDBManager dbManager = new DBManager();
        IMedicineRepositories medicineRepository = new MedicineRepositories(dbManager);
        MedCon medicineController = new MedCon(medicineRepository);
        MyApplication myApplication = new MyApplication(medicineController);
        myApplication.start();
    }
}
