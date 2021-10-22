package com.kedar.ecommerce.controller;

import com.google.gson.Gson;
import com.kedar.ecommerce.domain.Supplier;
import com.kedar.ecommerce.service.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("supplier")
public class SupplierController {

    SupplierService supplierService;

    Gson gson = new Gson();

    @Autowired
    SupplierController(SupplierService supplierService){
        this.supplierService = supplierService;
    }

    @GetMapping("/")
    public List<Supplier> getAllSuppliers(){
        return supplierService.findAll();
    }

    @GetMapping("/{id}")
    public Supplier getSupplierById(@PathVariable Long id){
        return supplierService.findById(id);
    }

    @PostMapping("/add")
    public Supplier saveSupplier(@RequestBody String requestBody){
        Supplier supplierToBeSaved = gson.fromJson(requestBody, Supplier.class);

        return supplierService.save(supplierToBeSaved);
    }

    @GetMapping("/sample")
    public ResponseEntity<List<Supplier>> sampleFunc(){
        HttpHeaders httpHeaders = new HttpHeaders();
        List<Supplier> supplierList = supplierService.findAll();
        httpHeaders.add("Count", supplierList.size()+"");
        return new ResponseEntity<>(supplierList, httpHeaders, HttpStatus.OK);
    }
}
