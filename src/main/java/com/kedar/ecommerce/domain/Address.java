package com.kedar.ecommerce.domain;

import javax.persistence.*;

@Entity
public class Address {

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
