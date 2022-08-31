package com.softwaredevs.proyecto.services;

import com.softwaredevs.proyecto.entities.Enterprise;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class EnterpriseService {
    private Enterprise enterprise;
    private List<Enterprise> listEnterprise = new ArrayList<>();
    public Enterprise createEnterprise(Enterprise enterprise){
        this.enterprise=enterprise;
        this.listEnterprise.add(enterprise);
        return this.enterprise;
    }
    public Enterprise getEnterpriseId(long id){
        return this.listEnterprise.stream().filter(e->e.getId()==id).findAny().orElse(null);
    }
    public List<Enterprise> getEnterpriseList(){
        return this.listEnterprise;
    }
    public List<Enterprise> removeEnterprise(long id){
        this.listEnterprise.removeIf(e -> e.getId()==id);
        return this.listEnterprise;
    }
    public Enterprise modifyEnterprise(long id, Enterprise enterprise){
        Enterprise enterprise1 = this.listEnterprise.stream().filter(e->e.getId()==id).findAny().orElse(null);
        if(enterprise1!=null){
            this.listEnterprise.remove(enterprise1);
            enterprise.setUpdateAt(LocalDate.now());
            this.listEnterprise.add(enterprise);
            return enterprise;
        }
        return null;
    }
}