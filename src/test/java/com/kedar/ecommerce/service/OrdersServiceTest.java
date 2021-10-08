package com.kedar.ecommerce.service;

import com.kedar.ecommerce.Exception.DataValidationException;
import com.kedar.ecommerce.domain.Address;
import com.kedar.ecommerce.domain.Customer;
import com.kedar.ecommerce.domain.OrderDetail;
import com.kedar.ecommerce.domain.Orders;
import com.kedar.ecommerce.repo.AddressRepository;
import com.kedar.ecommerce.repo.CustomerRepository;
import com.kedar.ecommerce.repo.ProductRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@SpringBootTest
@ExtendWith(SpringExtension.class)
public class OrdersServiceTest {

    @Autowired
    OrdersService ordersService;

    @Autowired CustomerRepository customerRepository;

    @Autowired ProductRepository productRepository;

    @Autowired AddressRepository addressRepository;

    private List<OrderDetail> getDummyOrderDetails(){
        List<OrderDetail> orderDetailList = new ArrayList<>();
        orderDetailList.add(new OrderDetail(productRepository.findById(1L).get(), 20, 0.0));
        orderDetailList.add(new OrderDetail(productRepository.findById(2L).get(), 2, 11.0));
        orderDetailList.add(new OrderDetail(productRepository.findById(7L).get(), 5, 5.99));
        return orderDetailList;
    }

    @Test
    public void testOrdersSave() throws DataValidationException {

        Customer customer = customerRepository.findById(1L).get();

        Address address = addressRepository.findById(508L).get();

        Orders order = Orders.builder()
                        .order_total(2000.00)
                        .orderDetails(getDummyOrderDetails())
                        .orderDate(new Date())
                        .orderStatus(Orders.OrderStatus.PENDING)
                        .customer(customer)
                        .address(address)
                        .deliveryDate(new Date())
                        .paymentMethod(Orders.PaymentMethod.CASH)
                        .paymentStatus(Orders.PaymentStatus.PENDING).build();

        Assertions.assertThat(ordersService.save(order).getId()).isNotNull();
    }
}
