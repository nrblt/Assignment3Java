package com.company.entities;

import java.time.LocalDate;

public class Medicine {
    private int id;
    private String name;
    private double price;
    private LocalDate ex_Date;
    private String manufacturer;

    public Medicine() {
    }

    public Medicine(int id, String name, double price, LocalDate ex_Date, String manufacturer) {
        setId(id);
        setName(name);
        setPrice(price);
        setExpirationDate(ex_Date);
        setManufacturer(manufacturer);
    }

    public Medicine(String name, double price, LocalDate ex_Date, String manufacturer) {
        setName(name);
        setPrice(price);
        setExpirationDate(ex_Date);
        setManufacturer(manufacturer);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public LocalDate getExpirationDate() {
        return ex_Date;
    }

    public void setExpirationDate(LocalDate expirationDate) {
        this.ex_Date = expirationDate;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    @Override
    public String toString() {
        return "Medicine{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", expirationDate=" + ex_Date +
                ", manufacturer='" + manufacturer + '\'' +
                '}';
    }
}
