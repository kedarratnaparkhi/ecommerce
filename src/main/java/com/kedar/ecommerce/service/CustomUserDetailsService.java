package com.kedar.ecommerce.service;

import com.kedar.ecommerce.TO.CustomUserDetails;
import com.kedar.ecommerce.domain.User;
import com.kedar.ecommerce.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired UserRepository userRepository;

    @Override public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {

        Optional<User> userObj = userRepository.findByUserName(s);

        userObj.orElseThrow(() -> new UsernameNotFoundException("Not found: "+ s));

        return new CustomUserDetails(userObj.get());
    }
}
