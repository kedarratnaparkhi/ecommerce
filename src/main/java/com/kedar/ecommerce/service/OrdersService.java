package com.kedar.ecommerce.service;

import com.kedar.ecommerce.Exception.DataValidationException;
import com.kedar.ecommerce.domain.Orders;
import com.kedar.ecommerce.repo.OrdersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrdersService {

    OrdersRepository ordersRepository;

    @Autowired
    OrdersService(OrdersRepository ordersRepository){
        this.ordersRepository = ordersRepository;
    }

    public Orders save(Orders order) throws DataValidationException{
        if(order.getOrderDetails().isEmpty())
            throw new DataValidationException("Invalid Order with no Order details");
        return ordersRepository.save(order);
    }

    public Boolean updateDiscount(){
        //todo: implement updateDiscount method
        return null;
    }
}