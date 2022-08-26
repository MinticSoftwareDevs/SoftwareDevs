package com.softwaredevs.proyecto.entities;

import java.time.LocalDate;
import java.util.List;

public class Enterprise {
    private long id;
    private String name;
    private String document;
    private String phone;
    private String address;
    //TODO Crear ArrayList de Employees y Transaction
    private List<Employee> employees;
    private List<Transaction> transactions;
    private LocalDate createAt;
    private LocalDate updateAt;

    public Enterprise(String name, String document, String phone, String address) {
        this.name = name;
        this.document = document;
        this.phone = phone;
        this.address = address;
        this.createAt=LocalDate.now();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
        this.updateAt=LocalDate.now();
    }

    public String getDocument() {
        return document;
    }

    public void setDocument(String document) {
        this.document = document;
        this.updateAt=LocalDate.now();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
        this.updateAt=LocalDate.now();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
        this.updateAt=LocalDate.now();
    }

    public LocalDate getCreateAt() {
        return createAt;
    }

    public LocalDate getUpdateAt() {
        return updateAt;
    }

    // -----TO STRING----//

    @Override
    public String toString() {
        return "Enterprise: " +
                "\n name='" + name + '\'' +
                "\n document='" + document + '\'' +
                "\n phone='" + phone + '\'' +
                "\n address='" + address + '\'' +
                "\n createAt=" + createAt;
    }
}
