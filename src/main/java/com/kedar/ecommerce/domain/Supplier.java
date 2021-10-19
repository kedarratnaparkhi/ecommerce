package com.kedar.ecommerce.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Supplier {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SUPP_SEQ")
    @SequenceGenerator(name = "SUPP_SEQ", sequenceName = "SUPP_SEQ", initialValue = 1001)
    private Long id;

    private String companyName;

    private String contactName;

    private String contactNumber;

    @OneToOne
    private Address address;

    @Enumerated(EnumType.STRING)
    private SupplierType type;

    private String currency;

    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "suppliers")
    //@JoinTable( name = "PROD_SUPP")
    private List<Product> products;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public SupplierType getType() {
        return type;
    }

    public void setType(SupplierType type) {
        this.type = type;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public enum SupplierType{
        ELECTRONICS,
        FOOD,
        COSMETICS,
        STATIONARY;
    }
}
