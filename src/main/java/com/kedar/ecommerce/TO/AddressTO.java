package com.kedar.ecommerce.TO;

import com.kedar.ecommerce.domain.Address;
import lombok.Builder;

@Builder
public class AddressTO {

    private String Id;

    private String line_1;

    private String line_2;

    private Address.City city;

    private Address.County county;

    private Address.Country country;

    private String postCode;

    private Address.AddressType type;

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

    public Address.City getCity() {
        return city;
    }

    public void setCity(Address.City city) {
        this.city = city;
    }

    public Address.County getCounty() {
        return county;
    }

    public void setCounty(Address.County county) {
        this.county = county;
    }

    public Address.Country getCountry() {
        return country;
    }

    public void setCountry(Address.Country country) {
        this.country = country;
    }

    public String getPostCode() {
        return postCode;
    }

    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }

    public Address.AddressType getType() {
        return type;
    }

    public void setType(Address.AddressType type) {
        this.type = type;
    }


}
