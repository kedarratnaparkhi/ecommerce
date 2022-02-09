package com.kedar.ecommerce.controller;

import com.google.gson.Gson;
import com.kedar.ecommerce.Exception.DataValidationException;
import com.kedar.ecommerce.TO.Mapper;
import com.kedar.ecommerce.TO.OrderDetailTO;
import com.kedar.ecommerce.TO.OrdersTO;
import com.kedar.ecommerce.domain.OrderDetail;
import com.kedar.ecommerce.domain.Orders;
import com.kedar.ecommerce.service.OrdersService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("order")
public class OrdersController {

    private OrdersService orderService;

    @Autowired
    OrdersController(OrdersService orderService){
        this.orderService = orderService;
    }

    Gson gson = new Gson();

    @ApiOperation(value = "Get Orders By Id", notes="get orders",nickname = "getOrderById", response = Orders.class)
    @GetMapping(path = "/{orderId}")
    public OrdersTO getOrderById(@PathVariable @ApiParam(value = "THis is the Order ID", required = true) Long orderId){

        return orderService.findById(orderId);
    }


    @PostMapping("/add")
    public Orders addOrder(@RequestBody String requestBody) throws DataValidationException {

        Orders orderToBeSaved = gson.fromJson(requestBody, Orders.class);
        return orderService.save(orderToBeSaved);
    }

    @GetMapping(path = "/orderDetails/{orderId}")
    public List<OrderDetailTO> getOrderDetailsById(@PathVariable Long orderId){

        return orderService.findOrderDetailsById(orderId).stream().map(orderDetail -> Mapper.toOrderDetailTO(orderDetail)).collect(
                Collectors.toList());
    }
}
