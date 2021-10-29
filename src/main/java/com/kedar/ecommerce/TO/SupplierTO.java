package com.kedar.ecommerce.TO;

import com.kedar.ecommerce.domain.Address;
import com.kedar.ecommerce.domain.Supplier;
import lombok.Builder;

@Builder
public class SupplierTO{

    private String companyName;

    private String contactName;

    private String contactNumber;

    private Address address;

    private Supplier.SupplierType type;

    private String currency;

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getContactName() {
        return contactName;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Supplier.SupplierType getType() {
        return type;
    }

    public void setType(Supplier.SupplierType type) {
        this.type = type;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }
}
