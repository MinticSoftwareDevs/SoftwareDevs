package com.softwaredevs.proyecto.controllers;

import com.softwaredevs.proyecto.entities.Enterprise;
import com.softwaredevs.proyecto.services.EnterpriseService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EnterpriseController {
    EnterpriseService enterpriseService;

    public EnterpriseController(EnterpriseService enterpriseService) {
        this.enterpriseService = enterpriseService;
    }

    @GetMapping("/enterprises")
    public List<Enterprise> getEnterprises() {
        return this.enterpriseService.getEnterpriseList();
    }

    @GetMapping("/enterprises/{id}")
    public Enterprise getEnterprise(@PathVariable("id") Long id) {
        return this.enterpriseService.getEnterpriseId(id);
    }

    @PostMapping("/enterprises")
    public Enterprise createEnterprise(@RequestBody Enterprise enterprise) {
        return this.enterpriseService.createEnterprise(enterprise);
    }

    @DeleteMapping("/enterprises/{id}")
    public List<Enterprise> removeEnterprise(@PathVariable("id") Long id) {
        return this.enterpriseService.removeEnterprise(id);
    }

    @PatchMapping("/enterprises/{id}")
    public Enterprise modifyEnterprise(@PathVariable("id") Long id, @RequestBody Enterprise enterprise) {
        return this.enterpriseService.modifyEnterprise(id, enterprise);
    }
}
