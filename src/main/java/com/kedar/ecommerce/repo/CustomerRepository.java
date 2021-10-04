package com.kedar.ecommerce.repo;

import com.kedar.ecommerce.domain.Customer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends CrudRepository<Customer, Long> {

    public Boolean existsByEmail(String email);
}
