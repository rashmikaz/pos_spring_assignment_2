package com.example.pos_assignment_2_spring.dao;

import com.example.pos_assignment_2_spring.entity.Impl.OrderDetailsEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderDetailsDao extends JpaRepository<OrderDetailsEntity,String> {
}
