package com.kedar.ecommerce.service;

import com.kedar.ecommerce.Exception.DataValidationException;
import com.kedar.ecommerce.TO.CustomerTO;
import com.kedar.ecommerce.TO.Mapper;
import com.kedar.ecommerce.domain.Customer;
import com.kedar.ecommerce.repo.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerService {

     CustomerRepository customerRepository;

     @Autowired
     CustomerService(CustomerRepository customerRepository){
         this.customerRepository = customerRepository;
     }

     public Customer save(Customer customerObj) throws DataValidationException {

         if(!customerObj.getEmail().contains("@"))
             throw new DataValidationException("Invalid email ID entered");
         if(!(customerObj.getAge() >= 18))
             throw new DataValidationException("Minimum age requirement for Customers is 18 ");
         if(customerObj.getFirstName().equals(customerObj.getLastName()))
             throw new DataValidationException("First Name and Last Name cannot be same");

         return customerRepository.save(customerObj);
     }

     public List<Customer> findAll(){
         return (List<Customer>) customerRepository.findAll();
     }

    public List<CustomerTO> findByFirstName(String firstName){
         List<CustomerTO> customerTOS = new ArrayList<>();
        customerRepository.findByFirstName(firstName).stream().forEach(customer -> customerTOS.add(Mapper.toCustomerTO(customer)));
        return customerTOS;
    }
}
