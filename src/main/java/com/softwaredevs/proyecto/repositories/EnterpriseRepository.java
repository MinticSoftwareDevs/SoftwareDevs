package com.softwaredevs.proyecto.repositories;

import com.softwaredevs.proyecto.entities.Enterprise;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EnterpriseRepository extends JpaRepository<Enterprise,Long> {
}
