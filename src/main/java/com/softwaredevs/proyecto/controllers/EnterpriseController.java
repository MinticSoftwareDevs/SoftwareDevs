package com.softwaredevs.proyecto.controllers;
import com.softwaredevs.proyecto.entities.Employee;
import com.softwaredevs.proyecto.services.EmployeeService;
import com.softwaredevs.proyecto.entities.Enterprise;
import com.softwaredevs.proyecto.services.EnterpriseService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;

@Controller
public class EnterpriseController {
    EnterpriseService enterpriseService;
    private EmployeeService employeeService;
    public EnterpriseController(EnterpriseService enterpriseService, EmployeeService employeeService){
        this.enterpriseService=enterpriseService;
        this.employeeService=employeeService;
    }
    @GetMapping("/enterprises")
    public String getEnterprises(Model model, @AuthenticationPrincipal OidcUser principal){
        model.addAttribute("empresas",enterpriseService.getEnterpriseList());
        if(principal!=null){
        Employee employee=this.employeeService.getEmployee(principal.getClaims());
        model.addAttribute("user",employee);
        }else{
            model.addAttribute("user",null);
        }
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
