package com.kedar.ecommerce.TO;

import com.kedar.ecommerce.domain.*;

import java.util.stream.Collectors;

public class Mapper {

    public static AddressTO toAddressTO(Address address){
        AddressTO addressTO = AddressTO.builder()
                                .city(address.getCity())
                                .country(address.getCountry())
                                .county(address.getCounty())
                                .line_1(address.getLine_1())
                                .line_2(address.getLine_2())
                                .postCode(address.getPostCode())
                                .type(address.getType()).build();

        return addressTO;
    }

    public static CustomerTO toCustomerTO(Customer customer){
        CustomerTO customerTO = CustomerTO.builder()
                                .addresses(customer.getAddresses())
                                .age(customer.getAge())
                                .email(customer.getEmail())
                                .firstName(customer.getFirstName())
                                .gender(customer.getGender())
                                .lastName(customer.getLastName())
                                .orders(customer.getOrders().stream().map(order -> order.getId()).collect(Collectors.toList()))
                                .build();

        return customerTO;
    }

    public static OrdersTO toOrdersTO(Orders order){

        OrdersTO ordersTO = OrdersTO.builder()
                .address(order.getAddress())
                .orderDate(order.getOrderDate())
                .order_total(order.getOrder_total())
                .customer(order.getCustomer().getId())
                .orderStatus(order.getOrderStatus())
                .deliveryDate(order.getDeliveryDate())
                .paymentMethod(order.getPaymentMethod())
                .paymentStatus(order.getPaymentStatus())
                .build();

        return ordersTO;
    }

    public static OrderDetailTO toOrderDetailTO(OrderDetail orderDetail){

        OrderDetailTO orderDetailTO = OrderDetailTO.builder()
                                        .discount(orderDetail.getDiscount())
                                        .product(Mapper.toProductTO(orderDetail.getProduct()))
                                        .quantity(orderDetail.getQuantity()).build();

        return orderDetailTO;
    }

    public static ProductTO toProductTO(Product product){

        ProductTO productTO = ProductTO.builder()
                                .category(product.getCategory())
                                .createDate(product.getCreateDate())
                                .description(product.getDescription())
                                .name(product.getName())
                                .price(product.getPrice())
                                .stock(product.getStock())
                                .suppliers(product.getSuppliers().stream().map(supplier -> Mapper.toSupplierTO(supplier)).collect(Collectors.toList()))
                                .weight(product.getWeight()).build();

        return productTO;
    }

    public static SupplierTO toSupplierTO(Supplier supplier){

        SupplierTO supplierTO = SupplierTO.builder()
                                .address(supplier.getAddress())
                                .companyName(supplier.getCompanyName())
                                .contactNumber(supplier.getContactNumber())
                                .currency(supplier.getCurrency())
                                .type(supplier.getType()).build();


        return supplierTO;
    }

}
