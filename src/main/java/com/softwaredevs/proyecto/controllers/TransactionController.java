package com.softwaredevs.proyecto.controllers;

import com.softwaredevs.proyecto.entities.Employee;
import com.softwaredevs.proyecto.entities.Enterprise;
import com.softwaredevs.proyecto.entities.Transaction;
import com.softwaredevs.proyecto.services.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import javax.persistence.PostUpdate;
import java.util.List;

@Controller
public class TransactionController {

    @Autowired
    TransactionService transactionService;


    @GetMapping("/transactions")
    public String getTransactions(Model model) {
        model.addAttribute("transacciones", transactionService.getTransactionList());
        return "transactions";
    }


    @GetMapping("/transactions/add")
    public String addTransaction(Model model) {
        model.addAttribute("transaccion", new Transaction());
        return "new-transaction";
    }

    @GetMapping("/transactions/{id}/movements")
    public String getTransaction(@PathVariable("id") Long id, Model model) {
        model.addAttribute("transaccion", this.transactionService.getTransactionId(id));
        return "edit-transaction";
    }

    @PostMapping("/transactions/{id}/movements")
    public RedirectView createTransaction(@ModelAttribute @DateTimeFormat(pattern = "YYYY-MM-DD") Transaction transaction, Model model) {
        model.addAttribute(transaction);
        this.transactionService.createTransaction(transaction);
        return new RedirectView("/transactions");
    }

    @DeleteMapping("/transactions/{id}/movements")
    public RedirectView removeTransaction(@PathVariable("id") Long id) {
        this.transactionService.deleteTransaction(id);
        return new RedirectView("/transactions");
    }

    @PatchMapping("/transactions/{id}/movements")
    public RedirectView modifyTransaction(@PathVariable("id") Long id, @ModelAttribute @DateTimeFormat(pattern = "YYYY-MM-DD") Transaction transaction) {
        this.transactionService.modifyTransaction(id, transaction);
        return new RedirectView("/transactions");
    }
}
