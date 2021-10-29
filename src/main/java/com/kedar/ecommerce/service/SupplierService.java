package com.kedar.ecommerce.service;

import com.kedar.ecommerce.TO.Mapper;
import com.kedar.ecommerce.TO.SupplierTO;
import com.kedar.ecommerce.domain.Supplier;
import com.kedar.ecommerce.repo.SupplierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SupplierService {

    SupplierRepository supplierRepository;

    @Autowired
    SupplierService(SupplierRepository supplierRepository){
        this.supplierRepository = supplierRepository;
    }

    public SupplierTO findById(Long id){
        return Mapper.toSupplierTO(supplierRepository.findById(id).get());
    }

    public Supplier save(Supplier supplier){
        return supplierRepository.save(supplier);
    }

    public List<SupplierTO> findAll(){
        List<SupplierTO> supplierList = new ArrayList<>();

        supplierRepository.findAll().forEach(supplier -> supplierList.add(Mapper.toSupplierTO(supplier)));

        return supplierList;
    }

    public Long count(){
        return supplierRepository.count();
    }

}
