package com.kedar.ecommerce.repo;

import com.kedar.ecommerce.domain.Address;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AddressRepository extends CrudRepository<Address, Long> {

    public List<Address> findByPostCode(String postCode);

}
