package com.kedar.ecommerce.repo;

import com.kedar.ecommerce.domain.Customer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends CrudRepository<Customer, Long> {

    public Boolean existsByEmail(String email);

    public List<Customer> findByFirstName(String firstName);
}
