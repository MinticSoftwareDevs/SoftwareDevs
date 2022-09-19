package com.softwaredevs.proyecto.controllers;

import com.softwaredevs.proyecto.entities.Enterprise;
import com.softwaredevs.proyecto.services.EnterpriseService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

@Controller
public class EnterpriseController {
    EnterpriseService enterpriseService;
    public EnterpriseController(EnterpriseService enterpriseService){
        this.enterpriseService=enterpriseService;
    }
    @GetMapping("/enterprises")
    public String getEnterprises(Model model){
        model.addAttribute("empresas",enterpriseService.getEnterpriseList());
        return "enterprises";
    }
    @GetMapping("/enterprises/add")
    public String addEnterprise(Model model){
        model.addAttribute("empresa",new Enterprise());
        return "new-enterprise";
    }
    @GetMapping("/enterprises/{id}")
    public String getEnterprise(@PathVariable("id") Long id, Model model){
        model.addAttribute("empresa",this.enterpriseService.getEnterpriseId(id));
        return "edit-enterprise";
    }
    @PostMapping("/enterprises")
    public RedirectView createEnterprise(@ModelAttribute @DateTimeFormat(pattern = "YYYY-MM-DD") Enterprise enterprise, Model model){
        model.addAttribute(enterprise);
        this.enterpriseService.createEnterprise(enterprise);
        return new RedirectView("/enterprises");
    }
    @DeleteMapping("/enterprises/{id}")
    public RedirectView removeEnterprise(@PathVariable("id") Long id){
        this.enterpriseService.removeEnterprise(id);
        return new RedirectView("/enterprises");
    }
    @PatchMapping("/enterprises/{id}")
    public RedirectView modifyEnterprise(@PathVariable("id") Long id, @ModelAttribute @DateTimeFormat(pattern = "YYYY-MM-DD") Enterprise enterprise){
        //model.addAttribute(enterprise);
        this.enterpriseService.modifyEnterprise(id,enterprise);
        return new RedirectView("/enterprises");
    }
}
