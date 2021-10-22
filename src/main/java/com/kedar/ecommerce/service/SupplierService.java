package com.kedar.ecommerce.service;

import com.kedar.ecommerce.domain.Supplier;
import com.kedar.ecommerce.repo.SupplierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SupplierService {

    SupplierRepository supplierRepository;

    @Autowired
    SupplierService(SupplierRepository supplierRepository){
        this.supplierRepository = supplierRepository;
    }

    public Supplier findById(Long id){
        return supplierRepository.findById(id).get();
    }

    public Supplier save(Supplier supplier){
        return supplierRepository.save(supplier);
    }

    public List<Supplier> findAll(){
        return (List<Supplier>) supplierRepository.findAll();
    }

    public Long count(){
        return supplierRepository.count();
    }

}
