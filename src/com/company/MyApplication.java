package com.company;

import com.company.controllers.MedCon;


import java.util.Scanner;

public class MyApplication {
    private final MedCon medCon;
    private final Scanner scanner;

    public MyApplication(MedCon medicineController) {
        this.medCon = medicineController;
        scanner = new Scanner(System.in);
    }

    public void start() {
        while(true) {
            System.out.println("Choose one option:\n 1) Find by name\n 2) Find by id\n 3) Add medicine\n 4) Remove medicine\n 5)Get all medicines\n 0) Exit\n");
            int choice = scanner.nextInt();

            if (choice==1) {
                searchMedicineByNameMenu();
            }
            else if (choice==2) {
                getMedicineByIdMenu();
            }
            else if (choice==3) {
                addMedicineMenu();
            }
            else if (choice==4) {
                removeMedicineByIdMenu();
            }
            else if (choice==5) {
                getAllMedicine();
            }

            else {
                break;
            }

            System.out.println("*********************");
        }
    }

    public void searchMedicineByNameMenu() {
        System.out.println("Write the name of medicine!");
        String name = scanner.next();
        String result = medCon.searchMedicineByName(name);
        System.out.println(result);
    }
    public void getAllMedicine() {
        String result = medCon.getAllMedicine();
        System.out.println(result);
    }
    public void getMedicineByIdMenu() {
        System.out.println("Write the id of medicine!");
        int id = scanner.nextInt();
        String result = medCon.getMedicineById(id);
        System.out.println(result);
    }

    public void addMedicineMenu() {
        System.out.println("Name:");
        String name = scanner.next();
        System.out.println("Price:");
        double price = scanner.nextDouble();
        System.out.println("Manufacturer:");
        String manufacturer = scanner.next();

        String result = medCon.addMedicine(name, price, manufacturer);

        System.out.println(result);
    }

    public void removeMedicineByIdMenu() {
        System.out.println("Write medicine's id!");
        int id = scanner.nextInt();

        String result = medCon.removeMedicineById(id);

        System.out.println(result);
    }
}
