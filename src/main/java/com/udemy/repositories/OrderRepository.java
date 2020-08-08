package com.udemy.repositories;

import com.udemy.entities.Order;
import com.udemy.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface OrderRepository extends JpaRepository<Order,Long> {


}
