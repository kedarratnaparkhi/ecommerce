package com.kedar.ecommerce.domain;

import lombok.Builder;
import org.hibernate.criterion.Order;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Builder
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String registeredName;

    private Double price;

    private Double weight;

    private String description;

    private Date createDate;

    private Integer stock;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "PROD_SUPP", joinColumns = @JoinColumn(name="supp_id", referencedColumnName = "id"),
                                inverseJoinColumns=@JoinColumn(name="prod_id", referencedColumnName="id"))
    private List<Supplier> suppliers;

    @ManyToOne(fetch = FetchType.LAZY)
    private Category category;
}

