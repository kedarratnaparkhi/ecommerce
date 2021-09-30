package com.kedar.ecommerce.domain;

import javax.persistence.*;
import java.util.List;

@Entity
public class Supplier {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String companyName;

    private String contactName;

    private String contactNumber;

    private Long addressId;

    @Enumerated(EnumType.STRING)
    private SupplierType type;

    private String currency;

    @ManyToMany(mappedBy = "suppliers", fetch = FetchType.LAZY)
    private List<Product> products;

    public enum SupplierType{
        ELECTRONICS,
        FOOD,
        COSMETICS,
        STATIONARY;
    }
}
