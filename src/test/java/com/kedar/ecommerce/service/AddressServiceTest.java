package com.kedar.ecommerce.service;

import com.kedar.ecommerce.Exception.DataValidationException;
import com.kedar.ecommerce.domain.Address;
import com.kedar.ecommerce.domain.Customer;
import com.kedar.ecommerce.repo.CustomerRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;
import java.util.Optional;

@SpringBootTest
@ExtendWith(SpringExtension.class)
public class AddressServiceTest {

    @Autowired
    AddressService addressService;

    @Autowired
    CustomerRepository customerRepository;


    @Test
    public void testAddressSave() throws DataValidationException {
        Optional<Customer> customer = customerRepository.findById(1L);

        Assertions.assertThat(customer.get().getId()).isNotNull();

        Address address = Address.builder()
                        .city(Address.City.BANGALORE)
                        .country(Address.Country.INDIA)
                        .county(Address.County.KA)
                        .line_1("henry street")
                        .line_2("")
                        .customer(customer.get())
                        .postCode("411023").build();

        Assertions.assertThat(addressService.save(address).getId()).isNotNull();

    }


    @Test
    public void testFindByPostCode(){
        String samplePostCode = "411021";
        List<Address> addressList = addressService.findByPostCode(samplePostCode);
        Assertions.assertThat(addressList).isNotEmpty();
    }
}
