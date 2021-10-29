package com.kedar.ecommerce.TO;

import com.kedar.ecommerce.domain.Address;
import com.kedar.ecommerce.domain.Customer;
import com.kedar.ecommerce.domain.Orders;
import lombok.Builder;

import java.util.List;

@Builder
public class CustomerTO {

    private String firstName;

    private String lastName;

    private Integer age;

    private Customer.Gender gender;

    private List<Address> addresses;

    private List<Long> orders;

    private String email;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Customer.Gender getGender() {
        return gender;
    }

    public void setGender(Customer.Gender gender) {
        this.gender = gender;
    }

    public List<Address> getAddresses() {
        return addresses;
    }

    public void setAddresses(List<Address> addresses) {
        this.addresses = addresses;
    }

    public List<Long> getOrders() {
        return orders;
    }

    public void setOrders(List<Long> orders) {
        this.orders = orders;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
