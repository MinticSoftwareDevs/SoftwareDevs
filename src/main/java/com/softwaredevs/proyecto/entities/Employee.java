package com.softwaredevs.proyecto.entities;

import java.time.LocalDate;
import java.util.Date;

public class Employee {
    private long id;
    private String name;
    private String email;
    // TODO private Profile profile;
    private Enum_RoleName role;
    private Enterprise enterprise;

    // TODO LISTA TRANSACION

    private LocalDate updateAt;
    private LocalDate createdAt;

    public Employee(String name, String email, Enum_RoleName role, Enterprise enterprise) {
        this.name = name;
        this.email = email;
        this.role = role;
        this.enterprise = enterprise;
        this.createdAt = LocalDate.now();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Enum_RoleName getRole() {
        return role;
    }

    public void setRole(Enum_RoleName role) {
        this.role = role;
    }

    public Enterprise getEnterprise() {
        return enterprise;
    }

    public void setEnterprise(Enterprise enterprise) {
        this.enterprise = enterprise;
    }

    public LocalDate getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(LocalDate updateAt) {
        this.updateAt = updateAt;
    }

    public LocalDate getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDate createdAt) {
        this.createdAt = createdAt;
    }

    @Override
    public String toString() {
        return "Employee: " +
                "\n name='" + name + '\'' +
                "\n email='" + email + '\'' +
                "\n role=" + role + "\n" +
                "\n" + enterprise + "\n" +
                "\n createdAt=" + createdAt +
                '}';
    }
}
