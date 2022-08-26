package com.softwaredevs.proyecto.entities;

import java.time.LocalDate;

public class Profile {
    private String id;
    private String image;
    private String phone;
    private Employee employee;
    private LocalDate createdAt;
    private LocalDate updateAt;
    public Profile(String image, String phone, Employee employee){
        this.image=image;
        this.phone=phone;
        this.employee=employee;
        this.createdAt=LocalDate.now();

    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
}