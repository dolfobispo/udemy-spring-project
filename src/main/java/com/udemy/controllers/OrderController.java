package com.udemy.controllers;

import com.udemy.entities.Order;
import com.udemy.entities.User;
import com.udemy.services.OrderService;
import com.udemy.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping(value ="/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;
    @GetMapping
    public ResponseEntity<List<Order>> findAll(){
        List<Order> orders = orderService.findAll();
        return ResponseEntity.ok(orders);
    }
    @GetMapping(value = "/{id}")
    public ResponseEntity<Order> findById(@PathVariable Long id){
        Order order  = orderService.findById(id);
        return ResponseEntity.ok(order);
    }
}
