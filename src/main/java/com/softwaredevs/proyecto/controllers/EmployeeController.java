package com.softwaredevs.proyecto.controllers;

import com.softwaredevs.proyecto.entities.Employee;
import com.softwaredevs.proyecto.entities.Enterprise;
import com.softwaredevs.proyecto.services.EmployeeService;
import com.softwaredevs.proyecto.services.EnterpriseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.ldap.embedded.EmbeddedLdapAutoConfiguration;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController {
    // ATRIBUTOS

    EmployeeService employeeService;


    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/employee")
    public List<Employee> getEmployee() {
        return this.employeeService.getEmployeeList();
    }

    @GetMapping("/employee/{id}")
    public Employee getEmployee(@PathVariable("id") Long id) {
        return this.employeeService.getEmployeeId(id);
    }

    @PostMapping("/employee")
    public Employee createEmployee(@RequestBody Employee employee) {
        return this.employeeService.createEmployee(employee);
    }

   @DeleteMapping("/employee/{id}")
    public boolean /*List<Employee>*/ removeEmployee(@PathVariable("id") Long id) {
       return this.employeeService.removeEmployee(id);
    }

    @PatchMapping("/employee/{id}")
    public String /*Employee*/ modifyEmployee(@PathVariable("id") Long id, @RequestBody Employee employee) {
      return this.employeeService.modifyEmployee(id, employee);
    }
}
