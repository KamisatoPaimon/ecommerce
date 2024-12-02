package com.example.BE_Ecommerce.Service;


import com.example.BE_Ecommerce.Entity.Order;
import com.example.BE_Ecommerce.Repository.OrderRepository;
import org.aspectj.weaver.ast.Or;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;

    public Order createNewOrder(Order order) {
        return orderRepository.save(order);
    }

    public List<Order> findOrderById(int id) {
        return orderRepository.findById(id);
    }
}
