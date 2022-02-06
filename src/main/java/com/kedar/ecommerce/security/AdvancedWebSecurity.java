package com.kedar.ecommerce.security;

import com.kedar.ecommerce.service.CustomUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
public class AdvancedWebSecurity extends WebSecurityConfigurerAdapter {

    @Autowired
    private CustomUserDetailsService customUserDetailService;

    /*
    Learned from Tutorials:
    https://www.youtube.com/watch?v=caCJAJC41Rk
    https://www.youtube.com/watch?v=payxWrmF_0k
    * */


    //This is the AUTHENTICATION part
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(customUserDetailService);
    }

    //This is the AUTHORIZATION part
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/customer/**").hasRole("ADMIN")
                //.antMatchers("/address/**").hasAnyRole("USER")
                .antMatchers("/").permitAll()
                .and().httpBasic()
                .and().cors()
                .and().csrf().disable();
    }


    @Bean
    public PasswordEncoder getPasswordEncoder(){
        return NoOpPasswordEncoder.getInstance();
    }
}
