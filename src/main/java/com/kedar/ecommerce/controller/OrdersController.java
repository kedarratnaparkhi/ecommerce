package com.kedar.ecommerce.controller;

import com.google.gson.Gson;
import com.kedar.ecommerce.Exception.DataValidationException;
import com.kedar.ecommerce.domain.OrderDetail;
import com.kedar.ecommerce.domain.Orders;
import com.kedar.ecommerce.service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("order")
public class OrdersController {

    private OrdersService orderService;

    @Autowired
    OrdersController(OrdersService orderService){
        this.orderService = orderService;
    }

    Gson gson = new Gson();

    @GetMapping(path = "/{orderId}")
    public Orders getOrderById(@PathVariable Long orderId){

        return orderService.findById(orderId);
    }


    @PostMapping("/add")
    public Orders addOrder(@RequestBody String requestBody) throws DataValidationException {

        Orders orderToBeSaved = gson.fromJson(requestBody, Orders.class);
        return orderService.save(orderToBeSaved);
    }

    @GetMapping(path = "/orderDetails/{orderId}")
    public List<OrderDetail> getOrderDetailsById(@PathVariable Long orderId){

        List<OrderDetail> orderDetailList = orderService.findById(orderId).getOrderDetails();
        return orderDetailList;
    }
}
