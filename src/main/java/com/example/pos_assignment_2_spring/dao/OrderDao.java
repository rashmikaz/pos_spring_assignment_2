package com.example.pos_assignment_2_spring.dao;

import com.example.pos_assignment_2_spring.entity.Impl.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderDao extends JpaRepository<OrderEntity,String> {
}
