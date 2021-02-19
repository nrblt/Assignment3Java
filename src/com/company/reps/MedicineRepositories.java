package com.company.reps;

import com.company.data.interfaces.IDBManager;
import com.company.entities.Medicine;
import com.company.reps.interfaces.IMedicineRepositories;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;


public class MedicineRepositories implements IMedicineRepositories {
    private final IDBManager dbManager;

    public MedicineRepositories(IDBManager dbManager) {
        this.dbManager = dbManager;
    }

    @Override
    public ArrayList<Medicine> searchMedicineByName(String name) {
        Connection connection = null;

        try {
            connection = dbManager.getConnection();

            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM medicine WHERE name LIKE '%" + name + "%'"); // '%name%' мол -> парацетамол

            ResultSet resultSet = preparedStatement.executeQuery();

            ArrayList<Medicine> medicines = new ArrayList<>();

            while (resultSet.next()) {
                Medicine medicine = new Medicine(resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getDouble("price"),
                        resultSet.getDate("ex_date").toLocalDate(),
                        resultSet.getString("manufacturer"));

                medicines.add(medicine);
            }

            return medicines;
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Medicine getMedicineById(int id) {
        Connection connection = null;

        try {
            connection = dbManager.getConnection();

            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM medicine WHERE id=?");

            preparedStatement.setInt(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();

            Medicine medicine = new Medicine();

            if (resultSet.next()) {
                medicine.setId(resultSet.getInt("id"));
                medicine.setName(resultSet.getString("name"));
                medicine.setPrice(resultSet.getDouble("price"));
                medicine.setExpirationDate(resultSet.getDate("ex_date").toLocalDate());
                medicine.setManufacturer(resultSet.getString("manufacturer"));
            }

            return medicine;
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public boolean addMedicine(Medicine medicine) {
        Connection connection = null;

        try {
            connection = dbManager.getConnection();

            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO medicine (name, price, ex_date, manufacturer) VALUES(?,?,?,?)");

            preparedStatement.setString(1, medicine.getName());
            preparedStatement.setDouble(2, medicine.getPrice());
            preparedStatement.setDate(3, Date.valueOf(medicine.getExpirationDate()));
            preparedStatement.setString(4, medicine.getManufacturer());

            preparedStatement.execute();

            return true;
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }

    @Override
    public boolean removeMedicineById(int id) {
        Connection connection = null;

        try {
            connection = dbManager.getConnection();

            PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM medicine WHERE id=?");

            preparedStatement.setInt(1, id);

            preparedStatement.execute();

            return true;
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }

    @Override
    public ArrayList<Medicine> getAllMedicine() {
        Connection connection = null;
        try {
            connection = dbManager.getConnection();

            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM medicine "); // '%name%' мол -> парацетамол

            ResultSet resultSet = preparedStatement.executeQuery();

            ArrayList<Medicine> medicines = new ArrayList<>();

            while (resultSet.next()) {
                Medicine medicine = new Medicine(resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getDouble("price"),
                        resultSet.getDate("ex_date").toLocalDate(),
                        resultSet.getString("manufacturer"));
                        medicines.add(medicine);
            }
            return medicines;
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
