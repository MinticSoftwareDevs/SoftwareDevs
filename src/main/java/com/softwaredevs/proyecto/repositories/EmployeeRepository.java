
package com.softwaredevs.proyecto.repositories;

import com.softwaredevs.proyecto.entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee,Long> {
}
