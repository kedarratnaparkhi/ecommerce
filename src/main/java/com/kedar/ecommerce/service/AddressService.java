package com.kedar.ecommerce.service;

import com.kedar.ecommerce.Exception.DataValidationException;
import com.kedar.ecommerce.domain.Address;
import com.kedar.ecommerce.repo.AddressRepository;
import com.kedar.ecommerce.repo.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressService {

    AddressRepository addressRepository;
    CustomerRepository customerRepository;

    @Autowired
    AddressService(AddressRepository addressRepository, CustomerRepository customerRepository){
        this.addressRepository = addressRepository;
        this.customerRepository = customerRepository;
    }

    public Address save(Address addressObj) throws DataValidationException {

        if(!findByPostCode(addressObj.getPostCode()).isEmpty())
            throw new DataValidationException("Postcode already in use");
        if(!addressObj.getLine_1().contains("street") && !addressObj.getLine_1().contains("road"))
            throw new DataValidationException("Data in Line 1 incomplete");
        return addressRepository.save(addressObj);
    }

    public List<Address> findByPostCode(String postCode){
        List<Address> addressList = addressRepository.findByPostCode(postCode);
        return addressList;
    }

    public List<Address> findAll(){
        return (List<Address>) addressRepository.findAll();
    }
}
