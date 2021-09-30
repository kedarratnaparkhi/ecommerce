package com.kedar.ecommerce.domain;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
public class Orders {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Double order_total;

    @Enumerated(EnumType.STRING)
    private PaymentMethod paymentMethod;

    private Date orderDate;

    private Date deliveryDate;

    @Enumerated(EnumType.STRING)
    private OrderStatus orderStatus;

    @Enumerated(EnumType.STRING)
    private PaymentStatus paymentStatus;

    @ManyToOne
    private Customer customer;


    @OneToMany(mappedBy = "order")
    private List<OrderDetail> orderDetails;


    public enum PaymentMethod{
        CASH,
        CREDIT_CARD,
        NET_BANKING,
        UPI
    }

    public enum OrderStatus{
        PENDING,
        CONFIRMED,
        IN_TRANSIT,
        DELIVERED
    }

    public enum PaymentStatus{
        PENDING,
        ACCEPTED,
        CANCELLED,
        DECLINED
    }
}
