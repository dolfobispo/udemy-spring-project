package com.udemy.repositories;

import com.udemy.entities.Category;
import com.udemy.entities.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;


public interface OrderItemRepository extends JpaRepository<OrderItem,Long> {


}
