package com.kedar.ecommerce.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;

import javax.persistence.*;

@Entity
@Builder
@AllArgsConstructor
public class Address {

    Address(){}

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String line_1;

    private String line_2;

    @Enumerated(EnumType.STRING)
    private City city;

    @Enumerated(EnumType.STRING)
    private County county;

    @Enumerated(EnumType.STRING)
    private Country country;

    private String postCode;

    @Enumerated(EnumType.STRING)
    private AddressType type;

    @ManyToOne(fetch = FetchType.LAZY)
    private Customer customer;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLine_1() {
        return line_1;
    }

    public void setLine_1(String line_1) {
        this.line_1 = line_1;
    }

    public String getLine_2() {
        return line_2;
    }

    public void setLine_2(String line_2) {
        this.line_2 = line_2;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public County getCounty() {
        return county;
    }

    public void setCounty(County county) {
        this.county = county;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public String getPostCode() {
        return postCode;
    }

    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }

    public AddressType getType() {
        return type;
    }

    public void setType(AddressType type) {
        this.type = type;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public enum City{
        PUNE,
        MUMBAI,
        BANGALORE,
        CHENNAI,
        NEWDELHI;
    }

    public enum County{
        MH,
        KA,
        TN,
        DL;
    }

    public enum Country{
        INDIA,
        USA,
        GERMANY,
        IRELAND;
    }

    public enum AddressType{
        SHIPPING,
        BILLING,
        BUSINESS_REG;
    }
}
