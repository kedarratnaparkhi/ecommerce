package com.kedar.ecommerce.TO;

import com.kedar.ecommerce.domain.Address;
import com.kedar.ecommerce.domain.Orders;
import lombok.Builder;

import java.util.Date;
import java.util.List;

@Builder
public class OrdersTO {
    private Double order_total;

    private Orders.PaymentMethod paymentMethod;

    private Date orderDate;

    private Date deliveryDate;

    private Orders.OrderStatus orderStatus;

    private Orders.PaymentStatus paymentStatus;

    private Long customer;

    private Address address;

    public Double getOrder_total() {
        return order_total;
    }

    public void setOrder_total(Double order_total) {
        this.order_total = order_total;
    }

    public Orders.PaymentMethod getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(Orders.PaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public Date getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(Date deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    public Orders.OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(Orders.OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }

    public Orders.PaymentStatus getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(Orders.PaymentStatus paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public Long getCustomer() {
        return customer;
    }

    public void setCustomer(Long customer) {
        this.customer = customer;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

}
