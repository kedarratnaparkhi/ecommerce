package com.kedar.ecommerce.service;

import com.kedar.ecommerce.domain.Supplier;
import com.kedar.ecommerce.repo.SupplierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

}
