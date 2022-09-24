package com.softwaredevs.proyecto.controllers;

import com.softwaredevs.proyecto.entities.Employee;
import com.softwaredevs.proyecto.entities.Enterprise;
import com.softwaredevs.proyecto.entities.Profile;
import com.softwaredevs.proyecto.services.EmployeeService;
import com.softwaredevs.proyecto.services.EnterpriseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.ldap.embedded.EmbeddedLdapAutoConfiguration;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

@Controller
public class EmployeeController {
    // ATRIBUTOS
    @Autowired
    EmployeeService employeeService;

    // Controlador para mostrar todos los empleados
    @GetMapping("/employees")
    public String getEmployees(Model model, @AuthenticationPrincipal OidcUser principal) {
        if(principal!=null){
            Employee employee=this.employeeService.getEmployee(principal.getClaims());
            model.addAttribute("user",employee);

            List<Employee> listEmployees = this.employeeService.getEmployeeList();
            model.addAttribute("listEmployees",listEmployees);
        }else{
            model.addAttribute("user",null);
        }
        return "employee/list-employee";
    }

    // Mostrar formulario para crear un nuevo empleado
    @GetMapping("/user/{id}")
    public Employee getEmployee(@PathVariable("id") Long id) {
        return this.employeeService.getEmployeeId(id);
    }
    // Gardar un nuevo empleado, este es el que conecta cuando hundimos el boton guardar
    @PostMapping("/users")
    public Employee createEmployee(@RequestBody Employee employee) {
        return this.employeeService.createEmployee(employee);
    }

    // metodo para eliminar
    @DeleteMapping("/employee/{id}")
    public RedirectView removeEmployee(@PathVariable("id") Long id) {
        this.employeeService.removeEmployee(id);
        return new RedirectView("employee/list-employee");
    }


    // metodo para llamar al formulario de editar de empleado
    @GetMapping("/employee/{id}")
    public String viewFormEditEmployee(@PathVariable("id") Long id, Model model,  @AuthenticationPrincipal OidcUser principal){
        if(principal!=null){
            Employee employee=this.employeeService.getEmployee(principal.getClaims());
            model.addAttribute("user",employee);

            Employee employeeModel = employeeService.getEmployeeId(id);
            Profile profileEmployeeModel = employeeModel.getProfile();
            model.addAttribute("employeeModel", employeeModel);
            model.addAttribute("profileEmployeeModel", profileEmployeeModel);
        }else{
            model.addAttribute("user",null);
        }
        return "employee/edit-employee";
    }


    // Metodo para actualizar
    @PatchMapping("/user/{id}")
    public RedirectView modificarEmployee (@PathVariable("id") Long id, @ModelAttribute("employeeModel") Employee employee, @ModelAttribute("profileEmployeeModel") Profile profile) {
        employeeService.modifyEmployee(id, employee, profile);
        return new RedirectView("/employees");
    }
}
