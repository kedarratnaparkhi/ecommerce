package com.kedar.ecommerce.service;

import com.kedar.ecommerce.Exception.DataValidationException;
import com.kedar.ecommerce.domain.Customer;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@SpringBootTest
@ExtendWith(SpringExtension.class)
public class CustomerServiceTest {

    @Autowired
    CustomerService customerService;


    @Test
    public void testCustomerSave() throws DataValidationException {
        Customer customer = Customer.builder()
                            .age(28)
                            .email("kedarr@me.com")
                            .firstName("Kedar")
                            .lastName("R")
                            .gender(Customer.Gender.MALE).build();

        Assertions.assertThat(customerService.save(customer).getId()).isNotNull();
    }

    @Test
    public void testCustomerSaveInvalidAge() throws DataValidationException {
        Customer customer = Customer.builder()
                .age(10)
                .email("kedarr@me.com")
                .firstName("Kedar")
                .lastName("R")
                .gender(Customer.Gender.MALE).build();

        org.junit.jupiter.api.Assertions.assertThrows(DataValidationException.class,
                () -> customerService.save(customer), "Exception thrown");
    }

    @Test
    public void testCustomerSaveInvalidEmail(){
        Customer customer = Customer.builder()
                .age(20)
                .email("kedarrme.com")
                .firstName("Kedar")
                .lastName("R")
                .gender(Customer.Gender.MALE).build();

        org.junit.jupiter.api.Assertions.assertThrows(DataValidationException.class,
                () -> customerService.save(customer), "Exception thrown");
    }
}
