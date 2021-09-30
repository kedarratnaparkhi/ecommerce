package com.kedar.ecommerce.domain;

import javax.persistence.*;

@Entity
public class OrderDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    private Orders order;

    @OneToOne
    private Product product;

    private Integer quantity;

    private Double discount;


}
