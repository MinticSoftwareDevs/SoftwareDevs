package com.softwaredevs.proyecto.controllers;

import com.softwaredevs.proyecto.entities.Enterprise;
import com.softwaredevs.proyecto.entities.Transaction;
import com.softwaredevs.proyecto.services.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TransactionController {

    @Autowired
    TransactionService transactionService;


    @PostMapping("/enterprises/{id}/movements")
    private void crearTransaction(@RequestBody Transaction transaction){
        transactionService.createTransaction(transaction);
    }
    @GetMapping("/enterprises/{id}/movements")
    public List<Transaction> getTransactions(){
        return this.transactionService.getTransactionList();
    }
    @GetMapping("/enterprises/{id}/movements")
    public Transaction getTransaction(@PathVariable("id") Long id){
        return this.transactionService.getTransactionId(id);
    }
    @DeleteMapping("/enterprises/{id}/movements")
    private void deleteTransaction(@PathVariable("id") long id){
        transactionService.deleteTransaction(id);
    }
    @PatchMapping("/enterprises/{id}/movements")
    public String modifyTransaction(@PathVariable("id") Long id, @RequestBody Transaction transaction) {
        return this.transactionService.modifyTransaction(id, transaction);
    }
}
