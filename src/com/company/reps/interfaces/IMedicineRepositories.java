package com.company.reps.interfaces;

import com.company.entities.Medicine;

import java.util.ArrayList;
import java.util.List;

public interface IMedicineRepositories {
    public ArrayList<Medicine> searchMedicineByName(String name);
    public Medicine getMedicineById(int id);
    public boolean addMedicine(Medicine medicine);
    public boolean removeMedicineById(int id);
    public ArrayList<Medicine> getAllMedicine();
}
