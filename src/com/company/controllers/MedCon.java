package com.company.controllers;

import com.company.entities.Medicine;
import com.company.reps.interfaces.IMedicineRepositories;

import java.time.LocalDate;

public class MedCon {
    private final IMedicineRepositories medRep;

    public MedCon(IMedicineRepositories medicineRepository) {
        this.medRep = medicineRepository;
    }

    public String searchMedicineByName(String name) {
        String result = medRep.searchMedicineByName(name).toString();

        return result;
    }

    public String getAllMedicine() {
        String result = medRep.getAllMedicine().toString();
        return result;
    }
    public String getMedicineById(int id) {
        String result = medRep.getMedicineById(id).toString();

        return result;
    }


    public String addMedicine(String name, double price, String manufacturer) {
        LocalDate expirationDate = LocalDate.now();
        boolean added = medRep.addMedicine(new Medicine(name, price, expirationDate, manufacturer));
        if (added) {
            return "Medicine was added!";
        }
        return "Medicine was not added!";
    }

    public String removeMedicineById(int id) {
        boolean removed = medRep.removeMedicineById(id);
        if (removed) {
            return "Medicine was removed!";
        }
        return "Medicine was not removed!";
    }
}
