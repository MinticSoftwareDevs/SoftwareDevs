package com.softwaredevs.proyecto.services;

import com.softwaredevs.proyecto.entities.Employee;
import com.softwaredevs.proyecto.entities.Enterprise;
import com.softwaredevs.proyecto.repositories.EmployeeRepository;
import com.softwaredevs.proyecto.repositories.EnterpriseRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    //Atributos
    private EmployeeRepository employeeRepository;
    private EnterpriseRepository enterpriseRepository;

    //COnstructor
    public EmployeeService(EmployeeRepository employeeRepository, EnterpriseRepository enterpriseRepository){
        this.employeeRepository = employeeRepository;
        this.enterpriseRepository = enterpriseRepository;
    }

    //Crear empleado
    public Employee createEmployee (Employee employee) {
        Optional<Enterprise> dbEnterprise = this.enterpriseRepository.findById(employee.getEnterprise().getId());
        if (dbEnterprise.isPresent()) {
            employee.setEnterprise(dbEnterprise.get());
            employee.setCreatedAt(LocalDate.now());
            return this.employeeRepository.save(employee);
        }
        else
            return null;
    }

    //Encontrar Empleado por ID
    public Employee getEmployeeId(long id){
        Optional<Employee> employee= this.employeeRepository.findById(id);
        return employee.orElse(null);

    }

    //Encontrar todos los empleados
    public List<Employee> getEmployeeList(){
        return this.employeeRepository.findAll();
    }


    //Remover empleado
    public boolean removeEmployee(long id){

        try {
            this.employeeRepository.deleteById(id);
            return true;
        }catch ( Exception ex){
            return false;
        }

    }


    public String modifyEmployee(long id, Employee employee){
        Optional<Employee> dbEmployee = this.employeeRepository.findById(id);
        Optional<Enterprise>dbEnterprise = this.enterpriseRepository.findById(employee.getEnterprise().getId());
        if(dbEmployee.isPresent() && dbEnterprise.isPresent()){
            //Employee e = dbEmployee.get();
            Employee e = employee;
            e.setUpdateAt(LocalDate.now());
            employee.setId(id);
            e.setEnterprise(dbEnterprise.get());
            e.setCreatedAt(dbEmployee.get().getCreatedAt());
            this.employeeRepository.save(e);
            return "Empleado modificado con éxito.";
        }else{
            return "No se pudo modificar el empleado, por favor, intente con un id de empresa o empleado válido.";
        }
    }
}