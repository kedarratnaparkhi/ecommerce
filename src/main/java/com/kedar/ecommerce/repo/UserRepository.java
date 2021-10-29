package com.kedar.ecommerce.repo;

import com.kedar.ecommerce.domain.User;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserRepository extends CrudRepository<User, Long> {

    public Optional<User> findByUserName(String userName);
}
