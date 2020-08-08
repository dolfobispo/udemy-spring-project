package com.udemy.repositories;

import com.udemy.entities.Category;
import com.udemy.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CategoryRepository extends JpaRepository<Category,Long> {


}
