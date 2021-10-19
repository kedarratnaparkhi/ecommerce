package com.kedar.ecommerce.controller;

import com.google.gson.Gson;
import com.kedar.ecommerce.Exception.DataValidationException;
import com.kedar.ecommerce.domain.Customer;
import com.kedar.ecommerce.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("customer")
public class CustomerController {

    private CustomerService customerService;

    @Autowired
    CustomerController(CustomerService customerService){
        this.customerService = customerService;
    }

    Gson gson = new Gson();

    @GetMapping(path = "/")
    public List<Customer> getAllCustomers(){
        return customerService.findAll();
    }

    @GetMapping(path = "/{firstName}")
    public List<Customer> getCustomerByFirstName(@PathVariable String firstName){
        return customerService.findByFirstName(firstName);
    }


    @PostMapping("/add")
    public Customer addCustomer(@RequestBody String requestBody) throws DataValidationException {
        Customer customerToBeSaved = gson.fromJson(requestBody, Customer.class);
        return customerService.save(customerToBeSaved);
    }
}
