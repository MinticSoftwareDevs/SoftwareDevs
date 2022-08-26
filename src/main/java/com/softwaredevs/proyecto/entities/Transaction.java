package com.softwaredevs.proyecto.entities;

import java.time.LocalDate;

public class Transaction {

    private long id;
    private String concept;
    private float amount;

    private Employee employeer;

    private Enterprise enterprise;
    private LocalDate createAt;
    private LocalDate updateAt;



    //Constructor
    public Transaction(String concept, float amount, Employee employeer) {
        this.concept = concept;
        this.amount = amount;
        this.employeer = employeer;
    }

    //Getter and Setter
    public String getConcept() {
        return concept;
    }

    public void setConcept(String concept) {
        this.concept = concept;
    }

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    public LocalDate getCreateAt() {
        return createAt;
    }

    public void setCreateAt(LocalDate createAt) {
        this.createAt = createAt;
    }

    public LocalDate getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(LocalDate updateAt) {
        this.updateAt = updateAt;
    }

    //Mostrar datos ó ToString

    @Override
    public String toString() {
        return "Transaction{" +
                "concept='" + concept + '\'' +
                ", amount=" + amount +
                ", employeer=" + employeer +
                ", enterprise=" + enterprise +
                ", createAt=" + createAt +
                ", updateAt=" + updateAt +
                '}';
    }
}
