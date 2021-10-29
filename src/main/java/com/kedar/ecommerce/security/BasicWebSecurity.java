package com.kedar.ecommerce.security;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
public class BasicWebSecurity extends WebSecurityConfigurerAdapter {

    /*
    Learned from Tutorials:
    https://www.youtube.com/watch?v=caCJAJC41Rk
    https://www.youtube.com/watch?v=payxWrmF_0k
    * */

    //This is the AUTHENTICATION part
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("kedar")
                .password("kedar")
                .roles("USER", "EXTRA_ROLE")
                .and()
                .withUser("admin")
                .password("admin")
                .roles("ADMIN");
    }

    //This is the AUTHORIZATION part
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/customer/**").hasRole("ADMIN")
                .antMatchers("/address/**").hasRole("USER")
                .antMatchers("/").permitAll()
                .and().httpBasic();
    }

    @Bean
    public PasswordEncoder getPasswordEncoder(){
        return NoOpPasswordEncoder.getInstance();
    }
}
