package com.kedar.ecommerce.controller;

import com.google.gson.Gson;
import com.kedar.ecommerce.Exception.DataValidationException;
import com.kedar.ecommerce.TO.AddressTO;
import com.kedar.ecommerce.domain.Address;
import com.kedar.ecommerce.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("address")
public class AddressController {

    private AddressService addressService;

    @Autowired
    AddressController(AddressService addressService){
        this.addressService = addressService;
    }

    Gson gson = new Gson();

    @GetMapping(path = "/")
    public List<Address> getAllAddress(){
        return addressService.findAll();
    }

    @GetMapping(path = "/{postcode}")
    public Address getAddressByPostCode(@PathVariable String postcode){
        return addressService.findByPostCode(postcode).get(0);
    }


    @PostMapping("/add")
    public AddressTO addAddress(@RequestBody String requestBody) throws DataValidationException {
        Address addressToBeSaved = gson.fromJson(requestBody, Address.class);
        return addressService.save(addressToBeSaved);
    }
}
